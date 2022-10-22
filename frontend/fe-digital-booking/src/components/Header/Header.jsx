import React, { useState } from "react";
import AuthButtons from "../AuthButtons";
import { Drawer } from "../Drawer";
import styles from "./Header.module.scss";
import { Link } from "react-router-dom";

const Header = () => {
  const [showDrawer, setShowDrawer] = useState(false);
  const username = localStorage.getItem("username");

  return (
    <>
      {showDrawer && (
        <Drawer username={username} setShowDrawer={setShowDrawer} />
      )}
      {!showDrawer && (
        <main className={styles["header-container"]} id="header">
          <figure>
            <Link to="/">
              <img src="assets/logo.svg" alt="DB Logo" />
              <span className={styles["slogan"]}>Sentite como en tu hogar</span>
            </Link>
          </figure>
          <button
            className={styles["menu-icon"]}
            onClick={() => setShowDrawer(true)}
          >
            <span className="material-icons">
              <i className="fa-solid fa-bars"></i>
            </span>
          </button>
          <AuthButtons />
        </main>
      )}
    </>
  );
};

export default Header;
