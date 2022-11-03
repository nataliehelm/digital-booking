import styles from './ImageSlider.module.scss';
import './carousel.scss';
import 'react-responsive-carousel/lib/styles/carousel.min.css'; // requires a loader
import { Carousel } from 'react-responsive-carousel';
import useLayoutDimension from '../../../../components/Layout/hook/useLayoutDimension';

const ImagesSlider = ({ setSlider, images }) => {
  const { fullHeight, headerHeight } = useLayoutDimension();
  return (
    <div
      style={{ height: fullHeight, marginTop: headerHeight }}
      className={styles['container']}
    >
      <div className={styles['modal']}>
        <div className={styles.carousel}>
          <div
            className={styles['close-modal']}
            onClick={() => setSlider(false)}
          >
            <i className="fa-solid fa-x"></i>
          </div>
          <div className={styles['carousel-layout']}>
            <Carousel>
              {images.map((image, index) => {
                return (
                  <img
                    src={image}
                    id={`dh-img-${index}`}
                    key={index}
                    alt=""
                  ></img>
                );
              })}
            </Carousel>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ImagesSlider;
