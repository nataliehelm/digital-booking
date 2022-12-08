import { Botton } from '../../atoms';
import styles from './ModulesButton.module.scss';

const ModulesButton = ({ label, onClick }) => {
  return (
    <button onClick={onClick}>
      <Botton variant="b2" classname={styles.label}>
        {label}
      </Botton>
    </button>
  );
};

export default ModulesButton;
