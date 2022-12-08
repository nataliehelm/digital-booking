import styles from './Checkbox.module.scss';
import cn from 'classnames';

const Checkbox = ({ id, name, value, label, isChecked, onChange, icon }) => {
  return (
    <div>
      <input
        type="checkbox"
        id={id}
        name={name}
        value={value}
        checked={isChecked}
        onChange={() => onChange(id)}
        className={styles.input}
      />
      <label htmlFor={id}>{label}</label>
      {icon && <i className={cn(icon, styles.icon)}></i>}
    </div>
  );
};

export default Checkbox;
