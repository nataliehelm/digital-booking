import PropTypes from 'prop-types';
import Text from '../../../../atoms/Text/Text';
import styles from './Features.module.scss';
import cn from 'classnames';

const Features = ({ items }) => {
  return (
    <section className={styles['features-container']}>
      {items.map(({ name, icon, id }) => (
        <article key={id} className={styles.article}>
          <i className={cn(icon, styles.icon)}></i>
          <Text variant="t1">{name}</Text>
        </article>
      ))}
    </section>
  );
};

Features.propTypes = {
  items: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      icon: PropTypes.string.isRequired,
      name: PropTypes.string.isRequired,
    })
  ).isRequired,
};
export default Features;
