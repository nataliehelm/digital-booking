import styles from './Policies.module.scss';
import PropTypes from 'prop-types';
import { Heading, Text, TextArea } from '../../../../../../atoms';

const Policies = ({ policyCancel, policyHouse, policySecurity }) => {
  return (
    <div className={styles['policies-container']}>
      <Heading variant="h2" classname={styles['features-title']}>
        Políticas del producto
      </Heading>
      <div className={styles['policies']}>
        <section>
          <Heading variant="h3" classname={styles['features-title']}>
            Normas de la casa
          </Heading>
          <Text variant="t2" classname={styles.text}>
            Descripción
          </Text>
          <TextArea {...policyHouse} variant="t2" />
        </section>
        <section>
          <Heading variant="h3" classname={styles['features-title']}>
            Salud y seguridad
          </Heading>
          <Text variant="t2" classname={styles.text}>
            Descripción
          </Text>
          <TextArea {...policySecurity} variant="t2" />
        </section>
        <section>
          <Heading variant="h3" classname={styles['features-heading']}>
            Política de cancelación
          </Heading>
          <Text variant="t2" classname={styles.text}>
            Descripción
          </Text>
          <TextArea {...policyCancel} variant="t2" />
        </section>
      </div>
    </div>
  );
};

Policies.propTypes = {
  policyCancel: PropTypes.shape({
    value: PropTypes.string,
    onChange: PropTypes.func,
    hasError: PropTypes.bool,
    errorMessage: PropTypes.string,
  }).isRequired,
  policyHouse: PropTypes.shape({
    value: PropTypes.string,
    onChange: PropTypes.func,
    hasError: PropTypes.bool,
    errorMessage: PropTypes.string,
  }).isRequired,
  policySecurity: PropTypes.shape({
    value: PropTypes.string,
    onChange: PropTypes.func,
    hasError: PropTypes.bool,
    errorMessage: PropTypes.string,
  }).isRequired,
};

export default Policies;
