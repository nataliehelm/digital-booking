import styles from './Score.module.scss';

const Score = ({ score }) => {
  return (
    <section className={styles['score-container']}>
      <span className={styles['product-score']}>{score}</span>
    </section>
  );
};

export default Score;
