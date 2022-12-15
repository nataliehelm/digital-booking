import { Carousel } from 'react-responsive-carousel';
import useLayoutDimension from '../../../../../../components/Layout/hook/useLayoutDimension';

import styles from './ImageSlider.module.scss';
import './carousel.scss';
import 'react-responsive-carousel/lib/styles/carousel.min.css';

const ImageSlider = ({ setSlider, images }) => {
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
              {images.map(({ id, title, url }) => {
                return <img src={url} key={id} alt={title}></img>;
              })}
            </Carousel>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ImageSlider;
