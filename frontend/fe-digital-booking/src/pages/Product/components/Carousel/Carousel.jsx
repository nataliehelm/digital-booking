import { useState, useEffect, useCallback } from 'react';
import { useBreakpoint } from '../../../../hooks';
import { ImageSlider } from './components/ImageSlider';
import styles from './Carousel.module.scss';

const Carousel = ({ images }) => {
  const [showSlider, setShowSlider] = useState(false);

  const breakpoint = useBreakpoint();

  const imageSlider = () => {
    setShowSlider(true);
  };

  if (!images.length) return null;

  if (breakpoint === 'sm' || breakpoint === 'md') {
    return <CarouselMobile images={images} />;
  }
  return (
    <div className={styles['carousel-container']}>
      <div className={styles['product-image-container']}>
        <div className={styles['product-image-left']}>
          <img src={images[0].url} alt="img" />
        </div>
        <div className={styles['product-image-right']}>
          {images.slice(1, 5).map((image) => {
            return <img src={image.url} key={image.id} alt={image.title}></img>;
          })}
        </div>
        <button className={styles['button']} onClick={imageSlider}>
          Ver más
        </button>
      </div>
      {showSlider && <ImageSlider setSlider={setShowSlider} images={images} />}
    </div>
  );
};

const CarouselMobile = ({ images }) => {
  const [currentIndex, setCurrentIndex] = useState(0);

  const changeImage = useCallback(
    (index) => {
      if (index !== images.length - 1) {
        setCurrentIndex(index + 1);
      } else {
        setCurrentIndex(0);
      }
    },
    [images.length]
  );

  useEffect(() => {
    const interval = setInterval(() => changeImage(currentIndex), 3000);
    return () => clearInterval(interval);
  }, [changeImage, currentIndex]);

  return (
    <div className={styles['product-image-container']}>
      <img src={images[currentIndex].url} alt="img" />
      <span className={styles['image-number']}>
        {currentIndex + 1}/{images.length}
      </span>
    </div>
  );
};

export default Carousel;
