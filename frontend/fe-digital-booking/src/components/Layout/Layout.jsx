import PropTypes from 'prop-types';
import useLayoutDimension from './hook';
import cn from 'classnames';
import styles from './Layout.module.scss';

const Layout = ({ children, className }) => {
  const { headerHeight, fullHeight } = useLayoutDimension();

  return (
    <div
      className={cn(styles['layout-container'], className)}
      style={{ marginTop: headerHeight, height: fullHeight }}
    >
      {children}
    </div>
  );
};

Layout.propTypes = {
  children: PropTypes.element.isRequired,
  classname: PropTypes.string,
};

export default Layout;
