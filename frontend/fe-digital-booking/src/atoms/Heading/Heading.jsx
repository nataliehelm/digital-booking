/* eslint-disable jsx-a11y/heading-has-content */
import PropTypes from 'prop-types';

const Heading = ({ variant, children, classname }) => {
  const props = { children, className: classname };

  const variants = {
    h1: () => <h1 {...props} />,
    h2: () => <h2 {...props} />,
    h3: () => <h3 {...props} />,
    h4: () => <h4 {...props} />,
  };

  const Element = variants[variant];
  return <Element />;
};

Heading.propTypes = {
  variant: PropTypes.oneOf(['h1', 'h2', 'h3', 'h4']).isRequired,
  children: PropTypes.oneOfType([PropTypes.string, PropTypes.element])
    .isRequired,
  classname: PropTypes.string,
};

export default Heading;
