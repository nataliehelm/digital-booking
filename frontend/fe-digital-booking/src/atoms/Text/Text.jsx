import PropTypes from 'prop-types';
import cn from 'classnames';

const Text = ({ variant, children, classname }) => {
  const variantClass = {
    t1: 'text-1',
    t2: 'text-2',
  }[variant];

  return <p className={cn(variantClass, classname)}>{children}</p>;
};

Text.propTypes = {
  variant: PropTypes.oneOf(['t1', 't2']).isRequired,
  children: PropTypes.oneOfType([PropTypes.element, PropTypes.string])
    .isRequired,
  classname: PropTypes.string,
};

export default Text;
