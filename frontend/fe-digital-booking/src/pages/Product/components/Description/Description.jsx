import { Heading, Text } from '../../../../atoms';
import PropTypes from 'prop-types';
import styles from './Description.module.scss';

const Description = ({ title, description }) => {
  return (
    <section className={styles['description-container']}>
      <Heading variant="h1" classname={styles.title}>
        {title}
      </Heading>
      <Text variant="t1" classname={styles.description}>
        {description}
      </Text>
    </section>
  );
};

Description.propTypes = {
  title: PropTypes.string.isRequired,
  description: PropTypes.string.isRequired,
};

export default Description;
