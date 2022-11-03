import styles from './Rank.module.scss';
import cn from 'classnames';

const Rank = ({ ranking }) => {
  const stars = 'fa-solid fa-star';
  const totalStars = 5;

  return (
    <span className={styles.rank}>
      {[...new Array(totalStars)].map((_, index) => (
        <i
          key={index}
          className={cn(stars, {
            [styles['star-on']]: index <= ranking - 1,
            [styles['star-off']]: index > ranking - 1,
          })}
        />
      ))}
    </span>
  );
};

export default Rank;
