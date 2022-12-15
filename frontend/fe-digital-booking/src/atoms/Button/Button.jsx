import { Botton } from '../Botton';
import PropTypes from 'prop-types';
import cn from 'classnames';
import styles from './Button.module.scss';

const Button = ({ variant, children, classname, onClick, type, disabled }) => {
  const variantClass = {
    b1: 'button-1',
    b2: 'button-2',
  }[variant];

  return (
    <button
      disabled={disabled}
      type={type}
      onClick={onClick}
      className={cn(styles[variantClass], classname, {
        [styles.disabled]: disabled,
      })}
    >
      <Botton variant="b2">{children}</Botton>
    </button>
  );
};

Button.propTypes = {
  variant: PropTypes.oneOf(['b1', 'b2']).isRequired,
  children: PropTypes.string.isRequired,
  classname: PropTypes.string,
  onClick: PropTypes.func,
  type: PropTypes.oneOf(['submit', 'button']),
  disabled: PropTypes.bool,
};

Button.defaultProps = {
  type: 'button',
};

export default Button;
