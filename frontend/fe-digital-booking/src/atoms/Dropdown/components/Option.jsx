import { Botton } from '../../Botton';
import PropTypes from 'prop-types';
import styles from './Option.module.scss';

const Option = ({ title, onClick, hasBottomBorder }) => {
  return (
    <div className={styles['option-container']}>
      <div onClick={onClick}>
        <div>
          <Botton variant="b1">{title}</Botton>
        </div>
      </div>
      {hasBottomBorder && <div className={styles.divider} />}
    </div>
  );
};

Option.propTypes = {
  title: PropTypes.string.isRequired,
  onClick: PropTypes.func.isRequired,
  hasBottomBorder: PropTypes.bool,
};

export default Option;
