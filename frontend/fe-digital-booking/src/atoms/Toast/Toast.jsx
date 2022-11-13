import PropTypes from 'prop-types';
import styles from './Toast.module.scss';
import cn from 'classnames';
import { Botton } from './../Botton';
import { useState } from 'react';

const Toast = ({ variant, label, isClosable }) => {
  const [showToast, setShowToast] = useState(true);
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

  if (!showToast) return null;

  return (
    <div className={cn(styles.toast, variantClass)}>
      <div onClick={() => setShowToast(false)} className={styles['close-icon']}>
        <i className="fa-solid fa-x fa-xl"></i>
      </div>
      {variantIcon}
      <Botton variant="b2">{label}</Botton>
    </div>
  );
};

Toast.propTypes = {
  variant: PropTypes.oneOf(['success', 'error']).isRequired,
  label: PropTypes.string.isRequired,
  isClosable: PropTypes.bool,
};

export default Toast;
