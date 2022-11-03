import React, { useState, useEffect } from 'react';
import styles from './Carousel.module.scss';
import useBreakpoint from '../../../../hooks/useBreakpoint';
import ImagesSlider from '../ImagesSlider';

const Carousel = ({ images }) => {
  const [showSlider, setShowSlider] = useState(false);

  const breakpoint = useBreakpoint();

  const imageSlider = () => {
    setShowSlider(true);
  };

  if (breakpoint === 'sm' || breakpoint === 'md') {
    return <CarouselMobile images={images} />;
  }
  return (
    <div className={styles['carousel-container']}>
      <div className={styles['product-image-container']}>
        <div className={styles['product-image-left']}>
          <img src={images[0]} alt="img" />
        </div>
        <div className={styles['product-image-right']}>
          {images.slice(1, 5).map((image, index) => {
            return <img src={image} key={index} alt=""></img>;
          })}
        </div>
        <button className={styles['button']} onClick={imageSlider}>
          Ver más
        </button>
      </div>
      {showSlider && <ImagesSlider setSlider={setShowSlider} images={images} />}
    </div>
  );
};

const CarouselMobile = ({ images }) => {
  const [currentIndex, setCurrentIndex] = useState(0);

  useEffect(() => {
    const interval = setInterval(() => changeImage(currentIndex), 3000);
    return () => clearInterval(interval);
  }, [currentIndex]);

  const changeImage = (index) => {
    if (index !== images.length - 1) {
      setCurrentIndex(index + 1);
    } else {
      setCurrentIndex(0);
    }
  };

  return (
    <div className={styles['product-image-container']}>
      <img src={images[currentIndex]} alt="img" />
      <span className={styles['image-number']}>
        {currentIndex + 1}/{images.length}
      </span>
    </div>
  );
};

export default Carousel;
