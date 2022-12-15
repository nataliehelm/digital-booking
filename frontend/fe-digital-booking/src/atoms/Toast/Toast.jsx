import PropTypes from 'prop-types';
import styles from './Toast.module.scss';
import cn from 'classnames';
import { Botton } from './../Botton';

const Toast = ({ variant, label, onClick }) => {
  const variantClass = {
    success: styles.success,
    error: styles.error,
  }[variant];

  const variantIcon = {
    success: <i className={cn('fa-solid fa-circle-check', styles.icon)}></i>,
    error: (
      <i className={cn('fa-solid fa-circle-exclamation', styles.icon)}></i>
    ),
  }[variant];

  return (
    <div className={cn(styles.toast, variantClass)} onClick={onClick}>
      {variantIcon}
      <Botton variant="b2">{label}</Botton>
    </div>
  );
};

Toast.propTypes = {
  variant: PropTypes.oneOf(['success', 'error']).isRequired,
  label: PropTypes.string.isRequired,
  onClick: PropTypes.func,
};

export default Toast;
