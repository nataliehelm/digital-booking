import { Heading } from '../../../../atoms';
import styles from './CategoryCard.module.scss';

const CategoryCard = ({ img, title, description }) => {
  return (
    <div className={styles.card}>
      <img src={img} alt={title}></img>
      <div className={styles['card-description']}>
        <Heading variant="h2">{title}</Heading>
        <Heading variant="h4">{description}</Heading>
      </div>
    </div>
  );
};

export default CategoryCard;
