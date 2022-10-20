import "./Input.module.scss";
import PropTypes from "prop-types";

const Input = ({ type, value, onChange }) => {
  return (
    <div>
      <input type={type} value={value} onChange={onChange} className="text-2" />
    </div>
  );
};

Input.propTypes = {
  type: PropTypes.string,
  value: PropTypes.string,
  onChange: PropTypes.func,
};

Input.defaultProps = {
  type: "text",
};

export default Input;
