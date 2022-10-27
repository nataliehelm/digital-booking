import { useEffect, useState } from 'react';
import { digitalBookingAPI } from './../../api/digital-booking.api';

const useFetch = (url) => {
  const [isLoading, setIsLoading] = useState(true);
  const [data, setData] = useState(null);
  const [isError, setIsError] = useState(null);

  useEffect(() => {
    digitalBookingAPI(url)
      .then((response) => response.json())
      .then((res) => setData(res.data))
      .catch(() => {
        setIsError(true);
        setData(undefined);
      })
      .finally(() => {
        setIsLoading(false);
      });
  }, [url]);
  return { isLoading, data, isError };
};

export default useFetch;
