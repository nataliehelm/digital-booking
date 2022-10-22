import React from "react";
import styles from "./Layout.module.scss";
import useLayoutDimension from "./hook";
import PropTypes from "prop-types";

const Layout = ({ children }) => {
  const { headerHeight } = useLayoutDimension();
  return (
    <div
      className={styles["layout-container"]}
      style={{ marginTop: headerHeight }}
    >
      {children}
    </div>
  );
};

Layout.propTypes = { children: PropTypes.element.isRequired };

export default Layout;
