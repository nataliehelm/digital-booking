import React, { useState } from "react";
import AuthButtons from "../AuthButtons/AuthButtons";
import { Drawer } from "../Drawer";
import styles from "./Header.module.scss";

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
          <button
            className={styles["menu-icon"]}
            onClick={() => setShowDrawer(true)}
          >
            <i className="fa-solid fa-bars fa-2xl"></i>
          </button>
        </main>
      )}
    </>
  );
};

export default Header;
