import React from "react";
import styles from "./Layout.module.scss";
import useLayoutDimension from "./hook";
import PropTypes from "prop-types";
import cn from "classnames";

const Layout = ({ children, className }) => {
  const { headerHeight, fullHeight } = useLayoutDimension();
  return (
    <div
      className={cn(styles["layout-container"], className)}
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
