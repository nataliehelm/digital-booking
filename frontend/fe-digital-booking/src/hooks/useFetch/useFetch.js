import { useEffect, useState } from 'react';

const useFetch = (url) => {
  const [isLoading, setIsLoading] = useState(true);
  const [data, setData] = useState(null);
  const [isError, setIsError] = useState(null);

  useEffect(() => {
    fetch(url)
      .then((response) => response.json())
      .then((res) => setData(res.data))
      .catch((e) => {
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
