import React from "react";
import { Botton, Text } from "../../atoms";
import SocialNetwork from "../SocialNetwork";
import styles from "./Footer.module.scss";

const Footer = () => {
  return (
    <footer id="footer" className={styles["footer-container"]}>
      <div className={styles.trademark}>
        <Botton variant="b1">&copy;2023 Digital Booking</Botton>
      </div>
      <section>
        <SocialNetwork />
      </section>
    </footer>
  );
};

export default Footer;
