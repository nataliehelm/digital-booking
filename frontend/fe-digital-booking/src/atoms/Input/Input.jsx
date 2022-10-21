import styles from "./Input.module.scss";
import PropTypes from "prop-types";
import { Text } from "../Text";
import cn from "classnames";
import { useState, useEffect } from "react";

const Input = ({
  type,
  value,
  onChange,
  hasError,
  errorMessage,
  label,
  name,
  placeholder,
  placeholderIcon,
}) => {
  const [showPlaceholder, setShowPlaceholder] = useState(true);
  const [showPassword, setShowPassword] = useState(false);

  useEffect(() => {
    setShowPlaceholder(!value);
  }, [value]);

  return (
    <div>
      <label htmlFor={name}>
        <Text variant="t2" classname={styles.label}>
          {label}
        </Text>
      </label>
      <div className={styles["input-container"]}>
        <input
          type={showPassword ? "text" : type}
          name={name}
          value={value}
          onChange={onChange}
          onFocus={() => setShowPlaceholder(false)}
          onBlur={() => setShowPlaceholder(true)}
          className={cn("text-2", { [styles["input-error"]]: hasError })}
        />
        {type === "password" && showPassword && (
          <div
            className={styles["password-icon"]}
            onClick={() => setShowPassword(false)}
          >
            <i className="fa-solid fa-eye"></i>
          </div>
        )}
        {type === "password" && !showPassword && (
          <div
            className={styles["password-icon"]}
            onClick={() => setShowPassword(true)}
          >
            <i className="fa-solid fa-eye-slash"></i>
          </div>
        )}
        {showPlaceholder && (
          <div className={styles.placeholder}>
            {placeholderIcon}
            <Text variant="t1">{placeholder}</Text>
          </div>
        )}
      </div>
      {errorMessage && (
        <Text variant="t2" classname={styles["label-error"]}>
          {errorMessage}
        </Text>
      )}
    </div>
  );
};

Input.propTypes = {
  type: PropTypes.string,
  value: PropTypes.string,
  onChange: PropTypes.func,
  hasError: PropTypes.bool,
  errorMessage: PropTypes.string,
  label: PropTypes.string,
  name: PropTypes.string.isRequired,
  placeholderIcon: PropTypes.element,
  placeholder: PropTypes.string,
};

Input.defaultProps = {
  type: "text",
  hasError: false,
};

export default Input;
