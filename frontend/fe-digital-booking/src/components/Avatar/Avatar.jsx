import React from "react";
import styles from "./Avatar.module.css";
import PropTypes from "prop-types";

const Avatar = ({ username }) => {
  const firstName = username.split(" ")[0][0].toUpperCase();
  const lastName = username.split(" ")[1]?.[0].toUpperCase() || "";

  return (
    <div className={styles["avatar-container"]}>
      <h2>{`${firstName}${lastName}`}</h2>
    </div>
  );
};

Avatar.propTypes = {
  username: PropTypes.string.isRequired,
};

export default Avatar;
