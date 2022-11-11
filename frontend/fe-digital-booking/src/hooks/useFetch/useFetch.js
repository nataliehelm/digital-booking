import { useEffect, useState } from 'react';
import { digitalBookingAPI } from './../../api/digital-booking.api';

const useFetch = (endpoint, options) => {
  const [isLoading, setIsLoading] = useState(true);
  const [data, setData] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    setIsLoading(true);
    digitalBookingAPI(endpoint, options)
      .then((response) => response.json())
      .then((res) => {
        if (res.errors) {
          setError(res.errors);
        } else if (res.status && res.status >= 400) {
          setError('Error en la petición');
        } else {
          setData(res.data);
        }
      })
      .catch((e) => {
        setError(e);
        setData(undefined);
      })
      .finally(() => {
        setIsLoading(false);
      });
  }, [endpoint, options]);
  return { isLoading, data, error };
};

export default useFetch;
