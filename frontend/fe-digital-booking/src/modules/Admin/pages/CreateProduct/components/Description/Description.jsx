import styles from './Description.module.scss';
import PropTypes from 'prop-types';
import { Text, TextArea } from '../../../../../../atoms';

const Description = ({ description }) => {
  return (
    <div className={styles.description}>
      <Text variant="t2" classname={styles.text}>
        Descripción
      </Text>
      <TextArea {...description} variant="t1" />
    </div>
  );
};

Description.propTypes = {
  description: PropTypes.shape({
    value: PropTypes.string,
    onChange: PropTypes.func,
    hasError: PropTypes.bool,
    errorMessage: PropTypes.string,
  }).isRequired,
};

export default Description;
