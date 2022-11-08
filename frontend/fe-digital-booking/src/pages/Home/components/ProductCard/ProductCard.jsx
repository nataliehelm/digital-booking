import { Link } from 'react-router-dom';
import { Button, Heading, Text, Rank } from '../../../../atoms';
import styles from './ProductCard.module.scss';

const ProductCard = ({
  id,
  img,
  category,
  title,
  score,
  location,
  description,
  ranking,
  features,
}) => {
  return (
    <div className={styles.card}>
      <figure className={styles['image-container']}>
        <div className={styles.like}>
          <i className="fa-solid fa-heart"></i>
        </div>
        <img src={img} alt={title}></img>
      </figure>
      <div className={styles['card-description']}>
        <div>
          <div className={styles['product-name']}>
            <div>
              <Heading variant="h4">
                <span>
                  {category}
                  <Rank ranking={ranking} />
                </span>
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
              <span>
                {location} -{' '}
                <span className={styles['show-map']}> MOSTRAR EN EL MAPA</span>
              </span>
            </Text>
          </div>
          <div className={styles.services}>
            {features.slice(0, 3).map((feature) => (
              <i key={feature.id} className={feature.icon}></i>
            ))}
          </div>
        </div>
        <div>
          <div className={styles.description}>
            <Heading variant="h4">{description}</Heading>
          </div>
          <Link to={`product/${id}`}>
            <Button variant="b1">ver más</Button>
          </Link>
        </div>
      </div>
    </div>
  );
};

export default ProductCard;
