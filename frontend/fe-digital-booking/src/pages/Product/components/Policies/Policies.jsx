import { Heading } from '../../../../atoms';
import { Policy } from './components';
import PropTypes from 'prop-types';
import styles from './Policies.module.scss';

const Policies = ({ policies }) => {
  return (
    <section className={styles['policies-container']}>
      <Heading variant="h1" classname={styles['title']}>
        Qué tenés que saber
      </Heading>
      <div className={styles.divider}></div>
      <div className={styles.policies}>
        {policies.map(({ id, title, subPolicies }) => (
          <Policy key={id} title={title} subPolicies={subPolicies} />
        ))}
      </div>
    </section>
  );
};

Policies.propTypes = {
  policies: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      title: PropTypes.string.isRequired,
      subPolicies: PropTypes.arrayOf(
        PropTypes.shape({
          id: PropTypes.number.isRequired,
          description: PropTypes.string.isRequired,
        })
      ).isRequired,
    })
  ).isRequired,
};

export default Policies;