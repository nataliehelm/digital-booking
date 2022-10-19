import React, { useState } from "react";
import Drawer from "../Drawer/Drawer";
import styles from "./Header.module.css";

const Header = () => {
  const [showDrawer, setShowDrawer] = useState(false);
  const username = localStorage.getItem("username");

  return (
    <>
      {showDrawer && (
        <Drawer username={username} setShowDrawer={setShowDrawer} />
      )}
      {!showDrawer && (
        <main className={styles["header-container"]}>
          <img src="assets/logo.svg" alt="DB Logo" />
          <button onClick={() => setShowDrawer(true)}>
            <span className="material-icons">menu</span>
          </button>
        </main>
      )}
    </>
  );
};

export default Header;
