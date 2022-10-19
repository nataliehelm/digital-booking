import React from "react";
import styles from "./Avatar.module.scss";
import PropTypes from "prop-types";
import { Heading } from "../Heading";

const Avatar = ({ username }) => {
  const firstName = username.split(" ")[0][0].toUpperCase();
  const lastName = username.split(" ")[1]?.[0].toUpperCase() || "";

  return (
    <div className={styles["avatar-container"]}>
      <Heading variant="h2">{`${firstName}${lastName}`}</Heading>
    </div>
  );
};

Avatar.propTypes = {
  username: PropTypes.string.isRequired,
};

export default Avatar;
