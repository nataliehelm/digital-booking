import PropTypes from 'prop-types';
import cn from 'classnames';

const Botton = ({ variant, children, classname }) => {
  const variantClass = {
    b1: 'botton-1',
    b2: 'botton-2',
  }[variant];

  return <p className={cn(variantClass, classname)}>{children}</p>;
};

Botton.propTypes = {
  variant: PropTypes.oneOf(['b1', 'b2']).isRequired,
  children: PropTypes.oneOfType([PropTypes.element, PropTypes.string])
    .isRequired,
  classname: PropTypes.string,
};

export default Botton;
