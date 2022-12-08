import { useState, useEffect } from 'react';
import { Text } from '../Text';
import PropTypes from 'prop-types';
import cn from 'classnames';
import styles from './Input.module.scss';

const Input = ({
  type,
  value,
  onChange,
  hasError,
  errorMessage,
  label,
  name,
  placeholder,
  placeholderIcon,
  onFocus,
  disabled,
  onClick,
  classname,
  noCaret,
}) => {
  const [showPlaceholder, setShowPlaceholder] = useState(true);
  const [showPassword, setShowPassword] = useState(false);

  useEffect(() => {
    setShowPlaceholder(!value);
  }, [value]);

  return (
    <div className={styles.container} onClick={onClick}>
      {label && (
        <label htmlFor={name}>
          <Text variant="t2" classname={styles.label}>
            {label}
          </Text>
        </label>
      )}
      <div className={styles['input-container']}>
        <div className={styles.placeholder}>{placeholderIcon}</div>
        <input
          disabled={disabled}
          id={name}
          type={showPassword ? 'text' : type}
          autoComplete="off"
          name={name}
          value={value}
          onChange={onChange}
          onFocus={() => {
            onFocus && onFocus();
            !noCaret && setShowPlaceholder(false);
          }}
          onBlur={() => {
            setShowPlaceholder(true);
          }}
          className={cn('text-2', styles.input, classname, {
            [styles['input-error']]: hasError,
            [styles['no-caret']]: noCaret,
            [styles['input-with-icon']]: !!placeholderIcon,
          })}
          onClick={onClick}
        />
        {type === 'password' && showPassword && (
          <span
            className={styles['password-icon']}
            onClick={() => setShowPassword(false)}
          >
            <i className="fa-solid fa-eye"></i>
          </span>
        )}
        {type === 'password' && !showPassword && (
          <span
            className={styles['password-icon']}
            onClick={() => setShowPassword(true)}
          >
            <i className="fa-solid fa-eye-slash"></i>
          </span>
        )}
        {showPlaceholder && !value && (
          <div className={styles.placeholder}>
            {placeholderIcon}
            {placeholder && <Text variant="t1">{placeholder}</Text>}
          </div>
        )}
      </div>
      {hasError && errorMessage && (
        <Text variant="t2" classname={styles['label-error']}>
          {errorMessage}
        </Text>
      )}
    </div>
  );
};

Input.propTypes = {
  type: PropTypes.string,
  value: PropTypes.string,
  onChange: PropTypes.func,
  onClick: PropTypes.func,
  onFocus: PropTypes.func,
  hasError: PropTypes.bool,
  errorMessage: PropTypes.string,
  label: PropTypes.string,
  name: PropTypes.string.isRequired,
  placeholderIcon: PropTypes.element,
  placeholder: PropTypes.string,
  disabled: PropTypes.bool,
  classname: PropTypes.string,
  noCaret: PropTypes.bool,
};

Input.defaultProps = {
  type: 'text',
  hasError: false,
  noCaret: false,
};

export default Input;
