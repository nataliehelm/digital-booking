import { useRef, useState } from 'react';
import { useInput, Input } from '../Input';
import { Option } from './components';
import { useOnClickOutside } from '../../hooks';
import PropTypes from 'prop-types';
import styles from './Dropdown.module.scss';
import cn from 'classnames';

const Dropdown = ({ options, onChange, placeholder, hasDivider }) => {
  const [showList, setShowList] = useState(false);
  const ref = useRef();
  useOnClickOutside(ref, () => setShowList(false));
  const search = useInput('');

  return (
    <div className={styles['dropdown-container']} ref={ref}>
      <Input
        value={search.value}
        onChange={() => undefined}
        name="basic-input"
        placeholder={placeholder}
        onFocus={() => setShowList(true)}
        classname={styles['input']}
      />
      {!showList && (
        <div onClick={() => setShowList(true)}>
          <i className={cn('fa-solid fa-chevron-down', styles.chevron)}></i>
        </div>
      )}
      {showList && (
        <div onClick={() => setShowList(false)}>
          <i className={cn('fa-solid fa-chevron-up', styles.chevron)}></i>
        </div>
      )}
      {showList && !!options.length && (
        <div className={styles['list-container']}>
          <div className={styles.list}>
            {options.map((p, index) => (
              <Option
                key={p.id}
                title={p.title}
                hasBottomBorder={hasDivider && index !== options.length - 1}
                onClick={() => {
                  onChange({
                    id: p.id,
                    title: p.title,
                  });
                  search.onChange({
                    target: { value: p.title },
                  });
                  setShowList(false);
                }}
              />
            ))}
          </div>
        </div>
      )}
    </div>
  );
};

Dropdown.propTypes = {
  options: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      title: PropTypes.string.isRequired,
    })
  ).isRequired,
  onChange: PropTypes.func,
};

export default Dropdown;
