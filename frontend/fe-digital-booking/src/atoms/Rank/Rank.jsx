import styles from './Rank.module.scss';
import cn from 'classnames';

const Rank = ({ ranking }) => {
  const totalStars = 5;
  const roundRanking = Math.round(ranking);

  return (
    <span className={styles.rank}>
      {[...new Array(totalStars)].map((_, index) => (
        <i
          key={index}
          className={cn('fa-solid fa-star', {
            [styles['star-on']]: index <= roundRanking - 1,
            [styles['star-off']]: index > roundRanking - 1,
          })}
        />
      ))}
    </span>
  );
};

export default Rank;
