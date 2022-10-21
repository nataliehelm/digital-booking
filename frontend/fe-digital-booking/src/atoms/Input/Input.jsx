import styles from "./Input.module.scss";
import PropTypes from "prop-types";
import { Text } from "../Text";
import cn from "classnames";

const Input = ({
  type,
  value,
  onChange,
  hasError,
  errorMessage,
  label,
  name,
}) => {
  return (
    <div>
      <label htmlFor={name}>
        <Text variant="t2" classname={styles.label}>
          {label}
        </Text>
      </label>
      <input
        type={type}
        name={name}
        value={value}
        onChange={onChange}
        className={cn("text-2", { [styles["input-error"]]: hasError })}
      />
      <Text variant="t2" classname={styles["label-error"]}>
        {label}
      </Text>
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
};

Input.defaultProps = {
  type: "text",
  hasError: false,
};

export default Input;
