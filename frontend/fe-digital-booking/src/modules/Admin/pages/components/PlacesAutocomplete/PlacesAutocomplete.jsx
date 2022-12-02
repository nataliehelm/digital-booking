import { useRef, useState } from 'react';
import usePlacesAutocomplete, {
  getGeocode,
  getLatLng,
} from 'use-places-autocomplete';
import { Input } from '../../../../../atoms';
import { Option } from '../../../../../atoms/WritableDropdown/components';
import { useOnClickOutside } from '../../../../../hooks';
import styles from './PlacesAutocomplete.module.scss';

const PlacesAutocomplete = ({ setCoords, placeholder }) => {
  const [showList, setShowList] = useState(false);
  const {
    ready,
    value,
    suggestions: { status, data },
    setValue,
    clearSuggestions,
  } = usePlacesAutocomplete({
    requestOptions: {},
    debounce: 300,
  });

  const ref = useRef();
  useOnClickOutside(ref, () => {
    clearSuggestions();
    setShowList(false);
  });

  const handleInput = (e) => {
    setValue(e.target.value);
    if (e.target.value) setShowList(true);
  };

  const handleSelect =
    ({ description }) =>
    () => {
      setValue(description, false);
      clearSuggestions();
      setShowList(false);

      getGeocode({ address: description }).then((results) => {
        const { lat, lng } = getLatLng(results[0]);
        setCoords({ lat, lng });
      });
    };

  const renderSuggestions = () =>
    data.map((suggestion) => {
      const {
        place_id,
        structured_formatting: { main_text, secondary_text },
      } = suggestion;

      return (
        <li key={place_id} onClick={handleSelect(suggestion)}>
          <Option title={main_text} description={secondary_text} />
        </li>
      );
    });

  return (
    <div ref={ref}>
      <Input
        value={value}
        onChange={handleInput}
        disabled={!ready}
        placeholder={placeholder}
        name={value}
      />
      {status === 'OK' && (
        <ul className={styles.list}>{renderSuggestions()}</ul>
      )}
      {status !== 'OK' && showList && (
        <ul className={styles.list}>
          <Option title="Cargando..." description="Cargando..." />
        </ul>
      )}
    </div>
  );
};

export default PlacesAutocomplete;
