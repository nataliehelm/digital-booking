import { useRef, useState } from 'react';
import { useInput, Input } from '../Input';
import { Option } from './components';
import { useOnClickOutside } from '../../hooks';
import PropTypes from 'prop-types';
import styles from './Dropdown.module.scss';
import cn from 'classnames';

const Dropdown = ({ options, onChange }) => {
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
        placeholder="Seleccionar hora de llegada"
        onFocus={() => setShowList(true)}
        classname={styles['input']}
      />
      <i
        className={cn('fa-solid fa-chevron-down', styles.chevron)}
        onClick={() => setShowList(true)}
      ></i>
      {showList && !!options.length && (
        <div className={styles['list-container']}>
          {options.map((p) => (
            <Option
              key={p.id}
              title={p.title}
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
