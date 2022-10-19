import React from "react";
import styles from "./Drawer.module.scss";
import PropTypes from "prop-types";
import { Avatar, Botton, Heading, Text } from "../../atoms";

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
            <Botton variant="b2">
              <>
                <span>Hola,</span>
                <span className={styles["user-name"]}>{username}</span>
              </>
            </Botton>
          </aside>
        )}
        {!username && (
          <Heading variant="h2" classname={styles.title}>
            MENÚ
          </Heading>
        )}
      </header>
      <nav className={styles.navbar}>
        {!username && (
          <ul>
            <li className={styles["navbar-item"]} onClick={handleLoginSignin}>
              <Heading variant="h3">Crear cuenta</Heading>
            </li>
            <div className={styles.divider} />
            <li className={styles["navbar-item"]} onClick={handleLoginSignin}>
              <Heading variant="h3">Inciar sesión</Heading>
            </li>
          </ul>
        )}
      </nav>
      {username && (
        <>
          <button onClick={handleLogout}>
            <Text variant="t2" classname={styles["p-logout"]}>
              <>
                ¿Deseas{" "}
                <span className={styles["span-logout"]}>cerrar sesión?</span>
              </>
            </Text>
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
