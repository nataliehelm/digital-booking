import PropTypes from 'prop-types';
import { Heading } from '../Heading';
import styles from './Subheader.module.scss';

const Subheader = ({ title, subtitle, onBackClick }) => {
  return (
    <section className={styles['subheader-container']}>
      <aside>
        <Heading variant="h4">{title?.toUpperCase() || ''}</Heading>
        <Heading variant="h1">{subtitle}</Heading>
      </aside>
      <figure onClick={onBackClick}>
        <i className="fa-solid fa-chevron-left"></i>
      </figure>
    </section>
  );
};

Subheader.prototype = {
  title: PropTypes.string,
  subtitle: PropTypes.string,
  onBackClick: PropTypes.func,
};

export default Subheader;
