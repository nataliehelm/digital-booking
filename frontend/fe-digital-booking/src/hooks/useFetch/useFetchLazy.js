import { useState } from 'react';
import { digitalBookingAPI } from '../../api/digital-booking.api';

const useFetchLazy = () => {
  const [isLoading, setIsLoading] = useState(false);
  const [data, setData] = useState(null);
  const [error, setError] = useState(null);

  const callback = async (endpoint, options) => {
    setIsLoading(true);
    try {
      const response = await digitalBookingAPI(endpoint, options);
      const res = await response.json();
      if (res.errors) {
        setData(null);
        setError(res.errors);
      } else if (res.status && res.status >= 400) {
        setData(null);
        setError('Error en la petición');
      } else {
        setData(res.data);
        setError(null);
      }
    } catch (error) {
      setData(null);
      setError(error);
    } finally {
      setIsLoading(false);
    }
  };

  return { isLoading, data, error, callback };
};

export default useFetchLazy;
