import { useEffect, useState } from 'react';
import { digitalBookingAPI } from './../../api/digital-booking.api';

const useFetch = (endpoint) => {
  const [isLoading, setIsLoading] = useState(true);
  const [data, setData] = useState(null);
  const [isError, setIsError] = useState(null);

  useEffect(() => {
    digitalBookingAPI(endpoint)
      .then((response) => response.json())
      .then((res) => setData(res.data))
      .catch(() => {
        setIsError(true);
        setData(undefined);
      })
      .finally(() => {
        setIsLoading(false);
      });
  }, [endpoint]);
  return { isLoading, data, isError };
};

export default useFetch;
