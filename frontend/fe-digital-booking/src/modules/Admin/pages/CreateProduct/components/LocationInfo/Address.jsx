import PropTypes from 'prop-types';
import PlacesAutocomplete from './PlacesAutocomplete';
import usePlacesAutocomplete from 'use-places-autocomplete';
import { Input } from '../../../../../../atoms';
import { useEffect, useState } from 'react';

const Address = ({ setCoords, address }) => {
  const {
    ready,
    value,
    suggestions: { status, data },
    setValue,
    clearSuggestions,
  } = usePlacesAutocomplete({
    requestOptions: {
      componentRestrictions: { country: 'ar' },
      region: 'ar',
    },
    debounce: 300,
  });

  const [googleApiError, setGoogleApiError] = useState(null);

  useEffect(() => {
    setValue(' ');
  }, [setValue]);

  useEffect(() => {
    if (status === 'ZERO_RESULTS') {
      setGoogleApiError(false);
      setValue('');
    }
  }, [status, setGoogleApiError, setValue]);

  if (googleApiError === false) {
    return (
      <PlacesAutocomplete
        setCoords={setCoords}
        name="address"
        label="Dirección"
        placeholder={`${address.value}` || 'Av. Colón 1643'}
        clearSuggestions={clearSuggestions}
        setValue={setValue}
        address={address}
        data={data}
        value={value}
        ready={ready}
        status={status}
      />
    );
  }

  return (
    <Input
      {...address}
      name="address"
      label="Dirección"
      placeholder="Av. Colón 1643"
      type="text"
    />
  );
};

Address.propTypes = {
  address: PropTypes.shape({
    value: PropTypes.string,
    onChange: PropTypes.func,
    hasError: PropTypes.bool,
    errorMessage: PropTypes.string,
  }).isRequired,
  setCoords: PropTypes.func.isRequired,
};

export default Address;
