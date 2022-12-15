import styles from './Features.module.scss';
import PropTypes from 'prop-types';
import { Checkbox, Heading } from '../../../../../../atoms';

const Features = ({ features, onChange }) => {
  return (
    <div className={styles.features}>
      <Heading variant="h2" classname={styles['features-title']}>
        Agregar atributos
      </Heading>
      <div className={styles.feature}>
        {features.length &&
          features.map((f) => (
            <Checkbox
              key={f.id}
              id={f.id}
              name={f.title}
              value={f.title}
              label={f.title}
              isChecked={f.isChecked}
              onChange={onChange}
              icon={f.icon}
            />
          ))}
      </div>
    </div>
  );
};

Features.propTypes = {
  features: PropTypes.array.isRequired,
  onChange: PropTypes.func.isRequired,
};

export default Features;
