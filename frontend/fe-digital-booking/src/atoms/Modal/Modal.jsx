import PropTypes from 'prop-types';
import { useRef } from 'react';
import { useOnClickOutside } from '../../hooks';
import styles from './Modal.module.scss';
import cn from 'classnames';

const Modal = ({ children, onCloseModal }) => {
  const ref = useRef(null);
  useOnClickOutside(ref, () => onCloseModal());
  return (
    <div className={styles.modal}>
      <div ref={ref} className={styles.children}>
        <i
          className={cn('fa-solid fa-x fa-xl', styles['close-icon'])}
          onClick={onCloseModal}
        />
        {children}
      </div>
    </div>
  );
};

Modal.propTypes = {
  children: PropTypes.element.isRequired,
  onCloseModal: PropTypes.func.isRequired,
};

export default Modal;
