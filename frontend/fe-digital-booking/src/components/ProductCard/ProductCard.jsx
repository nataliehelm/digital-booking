import React from 'react';
import { Heading, Text } from '../../atoms';
import styles from './ProductCard.module.scss';

const ProductCard = ({
  img,
  category,
  title,
  score,
  location,
  description,
}) => {
  return (
    <div className={styles.card}>
      <figure>
        <img src={img} alt={title}></img>
      </figure>
      <div className={styles['card-description']}>
        <div className={styles['product-name']}>
          <div>
            <Heading variant="h4">
              {category}
              <img src="assets/starts.png" alt="califiacion" />
            </Heading>
            <Heading variant="h1">{title}</Heading>
          </div>
          <div className={styles['score-container']}>
            <span className={styles['product-score']}>{score}</span>
            <p>Muy bueno</p>
          </div>
        </div>
        <div className={styles.location}>
          <i className="fa-solid fa-location-dot"></i>
          <Text variant="t1">
            {location} - <span> MOSTRAR EN EL MAPA</span>
          </Text>
        </div>
        <div className={styles.description}>
          <Heading variant="h4">{description}</Heading>
        </div>
      </div>
    </div>
  );
};

export default ProductCard;
