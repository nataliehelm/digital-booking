import React from "react";
import styles from "./Drawer.module.scss";
import PropTypes from "prop-types";
import { Avatar, Botton, Heading, Text } from "../../atoms";
import SocialNetwork from "../SocialNetwork";
import { Link } from "react-router-dom";

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
          <i className="fa-solid fa-x fa-xl"></i>
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
              <Link to="/signin">
                <Heading variant="h3">Crear cuenta</Heading>
              </Link>
            </li>
            <div className={styles.divider} />
            <li className={styles["navbar-item"]} onClick={handleLoginSignin}>
              <Link to="/login">
                <Heading variant="h3">Inciar sesión</Heading>
              </Link>
            </li>
          </ul>
        )}
      </nav>
      {username && (
        <div className={styles["logout-container"]}>
          <button onClick={handleLogout}>
            <Text variant="t2" classname={styles["p-logout"]}>
              <>
                ¿Deseas{" "}
                <span className={styles["span-logout"]}>cerrar sesión?</span>
              </>
            </Text>
          </button>
          <div className={styles["divider-logout"]} />
        </div>
      )}
      <SocialNetwork classname={styles["social-network"]} />
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
