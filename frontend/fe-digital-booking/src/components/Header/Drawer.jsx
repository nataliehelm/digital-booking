import React from "react";
import styles from "./Drawer.module.css";

const Drawer = () => {
  return (
    <section className={styles["drawer-container"]}>
      <header>
        <span class="material-icons md-40">close</span>
        <h2 className={styles.title}>MENÚ</h2>
      </header>
      <nav className={styles.navbar}>
        <ul>
          <li className={styles["navbar-item"]}>
            <h3>Crear cuenta</h3>
          </li>
          <div className={styles.divider} />
          <li className={styles["navbar-item"]}>
            <h3>Inciar sesión</h3>
          </li>
        </ul>
      </nav>
      <footer className={styles.footer}>
        <img src="assets/icons/facebook.svg" alt="Facebook Icon" />
        <img src="assets/icons/linkedin.svg" alt="LinkedIn Icon" />
        <img src="assets/icons/twitter.svg" alt="Twitter Icon" />
        <img src="assets/icons/instagram.svg" alt="Instagram Icon" />
      </footer>
    </section>
  );
};

export default Drawer;
