import { useMemo, useRef, useState, useEffect } from 'react';
import { useInput, Input } from '../Input';
import { Option } from './components';
import { useOnClickOutside } from '../../hooks';
import PropTypes from 'prop-types';
import styles from './Dropdown.module.scss';

const Dropdown = ({ options, onChange, reset }) => {
  const [showList, setShowList] = useState(false);
  const ref = useRef();
  useOnClickOutside(ref, () => setShowList(false));
  const search = useInput('');

  useEffect(() => {
    if (reset) {
      onChange(null);
      search.onChange({
        target: { value: '' },
      });
    }
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [reset, onChange]);

  const _options = useMemo(
    () =>
      options.filter(
        (o) =>
          o.title
            .toLowerCase()
            .normalize('NFD')
            .replace(/\p{Diacritic}/gu, '')
            .includes(search.value.toLowerCase()) ||
          o.description
            .toLowerCase()
            .normalize('NFD')
            .replace(/\p{Diacritic}/gu, '')
            .includes(search.value.toLowerCase())
      ),
    [search.value, options]
  );

  return (
    <div className={styles['dropdown-container']} ref={ref}>
      <Input
        {...search}
        name="basic-input"
        placeholder="¿A dónde vamos?"
        placeholderIcon={<i className="fa-solid fa-location-dot"></i>}
        onFocus={() => setShowList(true)}
        classname={styles['input-with-icon']}
      />
      {showList && !!_options.length && (
        <div className={styles['list-container']}>
          {_options.map((p, index) => (
            <Option
              icon={p.icon}
              key={p.id}
              title={p.title}
              description={p.description}
              hasBottomBorder={index !== _options.length - 1}
              onClick={() => {
                onChange({
                  id: p.id,
                  description: p.description,
                  title: p.title,
                });
                search.onChange({
                  target: { value: p.title || p.description },
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
      icon: PropTypes.element,
      title: PropTypes.string.isRequired,
      description: PropTypes.string,
    })
  ).isRequired,
  onChange: PropTypes.func,
};

export default Dropdown;
