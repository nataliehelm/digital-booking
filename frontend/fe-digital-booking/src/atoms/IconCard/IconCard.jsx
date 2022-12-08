import styles from './IconCard.module.scss';
import cn from 'classnames';
import PropTypes from 'prop-types';
import { Button } from '../Button';

const IconCard = ({ icon, onClick, text, buttonVariant, buttonType }) => {
  return (
    <div className={styles.container}>
      <i className={cn(`${icon}`, styles.icons)}></i>
      <Button
        variant={`${buttonVariant}`}
        classname={styles.button}
        onClick={onClick}
        type={`${buttonType}`}
      >
        {text}
      </Button>
    </div>
  );
};

IconCard.propTypes = {
  icon: PropTypes.string.isRequired,
  onClick: PropTypes.func.isRequired,
  text: PropTypes.string.isRequired,
  buttonVariant: PropTypes.string.isRequired,
  buttonType: PropTypes.string.isRequired,
};

export default IconCard;
