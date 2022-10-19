import React from "react";
import styles from "./Header.module.css";

const Header = () => {
  return (
    <main className={styles["header-container"]}>
      <img src="assets/logo.svg" alt="DB Logo" />
      <span class="material-icons">menu</span>
    </main>
  );
};

export default Header;
