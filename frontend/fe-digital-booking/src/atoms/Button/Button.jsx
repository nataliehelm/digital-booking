import React from "react";
import PropTypes from "prop-types";
import cn from "classnames";
import styles from "./Button.module.scss";
import { Botton } from "../Botton";

const Button = ({ variant, children, classname, onClick }) => {
  const variantClass = {
    b1: "button-1",
    b2: "button-2",
    b3: "button-3",
    b4: "button-4",
    b5: "button-5",
    b6: "button-6",
  }[variant];

  return (
    <button onClick={onClick} className={cn(styles[variantClass], classname)}>
      <Botton variant="b2">{children}</Botton>
    </button>
  );
};

Button.propTypes = {
  variant: PropTypes.oneOf(["b1", "b2", "b3", "b4", "b5", "b6"]).isRequired,
  children: PropTypes.string.isRequired,
  classname: PropTypes.string,
  onClick: PropTypes.func.isRequired,
};

export default Button;
