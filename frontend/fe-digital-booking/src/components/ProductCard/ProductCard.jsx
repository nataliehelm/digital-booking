import React from 'react';
import { Button, Heading, Text } from '../../atoms';
import styles from './ProductCard.module.scss';

const ProductCard = ({
  img,
  category,
  title,
  score,
  location,
  description,
}) => {
  //const screen = window.screen.width;
  return (
    <div className={styles.card}>
      <figure>
        <img src={img} alt={title}></img>
      </figure>
      <div className={styles.like}>
        <i className="fa-solid fa-heart"></i>
      </div>
      <div className={styles['card-description']}>
        <div className={styles['product-name']}>
          <div>
            <Heading variant="h4">
              {category}
              <img src="assets/starts.png" alt="calificacion" />
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
        <div className={styles.services}>
          <i className="fa-solid fa-wifi"></i>
          <i className="fa-solid fa-person-swimming"></i>
        </div>
        <div className={styles.description}>
          {/*           {screen > 768 ? (
            <Heading variant="h4">
              {description.substring(0, 65) + '...'}
            </Heading>
          ) : (
            <Heading variant="h4">{description}</Heading>
          )} */}
          <Heading variant="h4">{description}</Heading>
          <Button onClick={() => {}} variant="b1">
            ver más
          </Button>
        </div>
      </div>
    </div>
  );
};

export default ProductCard;
