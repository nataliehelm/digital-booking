import PropTypes from "prop-types";
import { Botton } from "../../Botton";
import styles from "./Option.module.scss";

const Option = ({ icon, title, description, hasBottomBorder, onClick }) => {
  return (
    <div className={styles["option-container"]}>
      <div onClick={onClick}>
        {icon}
        <div>
          <Botton variant="b1">{title}</Botton>
          <Botton variant="b1" classname={styles.description}>
            {description}
          </Botton>
        </div>
      </div>
      {hasBottomBorder && <div className={styles.divider} />}
    </div>
  );
};

Option.propTypes = {
  icon: PropTypes.element,
  title: PropTypes.string.isRequired,
  description: PropTypes.string,
  hasBottomBorder: PropTypes.bool,
  onClick: PropTypes.func.isRequired,
};

Option.defaultProps = {
  hasBottomBorder: true,
};

export default Option;
