import PropTypes from 'prop-types';
import Text from '../../../../atoms/Text/Text';
import styles from './Services.module.scss';
import cn from 'classnames';

const Services = ({ items }) => {
  return (
    <section className={styles['services-container']}>
      {items.map(({ label, icon, id }) => (
        <article key={id} className={styles.article}>
          <i className={cn(icon, styles.icon)}></i>
          <Text variant="t1">{label}</Text>
        </article>
      ))}
    </section>
  );
};

Services.propTypes = {
  items: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      icon: PropTypes.string.isRequired,
      label: PropTypes.string.isRequired,
    })
  ).isRequired,
};
export default Services;
