import React from "react";
import styles from "./SocialNetwork.module.scss";

const SocialNetwork = () => {
  return (
    <div className={styles.social}>
      <a href="https:/facebook.com" target="_blank" rel="noreferrer">
        <i className="fa-brands fa-facebook"></i>
      </a>
      <a href="https:/linkedin.com" target="_blank" rel="noreferrer">
        <i className="fa-brands fa-linkedin-in"></i>
      </a>
      <a href="https:/twitter.com" target="_blank" rel="noreferrer">
        <i className="fa-brands fa-twitter"></i>
      </a>
      <a href="https:/instagram.com" target="_blank" rel="noreferrer">
        <i className="fa-brands fa-instagram"></i>
      </a>
    </div>
  );
};

export default SocialNetwork;
