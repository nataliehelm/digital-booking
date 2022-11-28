import PropTypes from 'prop-types';
import styles from './PaginatorItem.module.scss';
import cn from 'classnames';

const PaginatorItem = ({ children, onClick, disabled, isCurrent }) => {
  return (
    <button
      onClick={() => onClick(Number(children))}
      className={cn(styles.item, {
        [styles['is-current']]: isCurrent,
        [styles.disabled]: disabled,
      })}
      disabled={disabled}
    >
      {children}
    </button>
  );
};

PaginatorItem.propTypes = {
  children: PropTypes.oneOfType([PropTypes.element, PropTypes.number])
    .isRequired,
  onClick: PropTypes.func.isRequired,
  disabled: PropTypes.bool,
  isCurrent: PropTypes.bool,
};

export default PaginatorItem;
