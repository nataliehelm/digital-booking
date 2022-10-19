import React from "react";
import styles from "./Drawer.module.css";
import PropTypes from "prop-types";
import { Avatar } from "../Avatar";
import cn from "classnames";

const Drawer = ({ setShowDrawer, username }) => {
  const handleLoginSignin = () => {
    localStorage.setItem("username", "Felipe Monterrosa");
    setShowDrawer(false);
  };

  const handleLogout = () => {
    localStorage.removeItem("username");
    setShowDrawer(false);
  };

  return (
    <section className={styles["drawer-container"]}>
      <header>
        <button onClick={() => setShowDrawer(false)}>
          <span className="material-icons md-40">close</span>
        </button>
        {username && (
          <aside className={styles["user-info"]}>
            <Avatar username={username} />
            <p className="botton-2">
              <span>Hola,</span>
              <span className={styles["user-name"]}>{username}</span>
            </p>
          </aside>
        )}
        {!username && <h2 className={styles.title}>MENÚ</h2>}
      </header>
      <nav className={styles.navbar}>
        {!username && (
          <ul>
            <li className={styles["navbar-item"]} onClick={handleLoginSignin}>
              <h3>Crear cuenta</h3>
            </li>
            <div className={styles.divider} />
            <li className={styles["navbar-item"]} onClick={handleLoginSignin}>
              <h3>Inciar sesión</h3>
            </li>
          </ul>
        )}
      </nav>
      {username && (
        <>
          <button onClick={handleLogout}>
            <p className={cn("text-2", styles["p-logout"])}>
              ¿Deseas{" "}
              <span className={styles["span-logout"]}>cerrar sesión?</span>
            </p>
          </button>
          <div className={styles["divider-logout"]} />
        </>
      )}
      <footer className={styles.footer}>
        <img src="assets/icons/facebook.svg" alt="Facebook Icon" />
        <img src="assets/icons/linkedin.svg" alt="LinkedIn Icon" />
        <img src="assets/icons/twitter.svg" alt="Twitter Icon" />
        <img src="assets/icons/instagram.svg" alt="Instagram Icon" />
      </footer>
    </section>
  );
};

Drawer.propTypes = {
  setShowDrawer: PropTypes.func.isRequired,
  username: PropTypes.string,
};

Drawer.defaultProps = {
  username: "",
};

export default Drawer;
