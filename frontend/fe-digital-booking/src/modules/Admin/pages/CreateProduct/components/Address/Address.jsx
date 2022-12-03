import { useEffect, useState } from 'react';
import usePlacesAutocomplete from 'use-places-autocomplete';
import { Input } from '../../../../../../atoms';
import PlacesAutocomplete from '../PlacesAutocomplete/PlacesAutocomplete';

const Address = ({ setCoords, address }) => {
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

  const [googleApiError, setGoogleApiError] = useState(null);

  useEffect(() => {
    setValue(' ');
  }, [setValue]);

  useEffect(() => {
    if (status === 'ZERO_RESULTS') setGoogleApiError(false);
  }, [status, setGoogleApiError]);

  if (googleApiError === false) {
    return (
      <PlacesAutocomplete
        setCoords={setCoords}
        name="address"
        label="Dirección"
        placeholder="Av. Colón 1643"
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
      name="address"
      label="Dirección"
      placeholder="Av. Colón 1643"
      type="text"
      value={address.value}
      onChange={address.onChange}
    />
  );
};

export default Address;
