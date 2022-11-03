import { Heading } from '../Heading';
import styles from './Subheader.module.scss';

const Subheader = ({ title, subtitle, onBackClick }) => {
  return (
    <section className={styles['subheader-container']}>
      <aside>
        <Heading variant="h4">{title}</Heading>
        <Heading variant="h1">{subtitle}</Heading>
      </aside>
      <figure onClick={onBackClick}>
        <i className="fa-solid fa-chevron-left"></i>
      </figure>
    </section>
  );
};

export default Subheader;
