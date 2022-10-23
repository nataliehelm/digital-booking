import PropTypes from "prop-types";
import Option from "./components/Option";
import styles from "./Dropdown.module.scss";

const Dropdown = ({ options, onChange }) => {
  return (
    <div className={styles["dropdown-container"]}>
      {options.map((p, index) => (
        <Option
          icon={p.icon}
          key={p.id}
          title={p.title}
          description={p.description}
          hasBottomBorder={index !== options.length - 1}
          onClick={() =>
            onChange({ id: p.id, description: p.description, title: p.title })
          }
        />
      ))}
    </div>
  );
};

Dropdown.propTypes = {
  options: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      icon: PropTypes.element,
      title: PropTypes.string.isRequired,
      description: PropTypes.string,
    })
  ).isRequired,
  onChange: PropTypes.func,
};

export default Dropdown;
