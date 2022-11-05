import styles from './Score.module.scss';

const Score = ({ score }) => {
  return (
    <section className={styles['score-container']}>
      <span>{score}</span>
    </section>
  );
};

export default Score;
