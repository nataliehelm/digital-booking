import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useFetch } from '../../../../hooks';
import useAuthContext from '../../../../providers/AuthProvider/useAuthContext';

const useAdmin = () => {
  const navigate = useNavigate();
  const { state } = useAuthContext();
  const [products, setProducts] = useState([]);
  const [options, setOptions] = useState(null);
  const [currentPage, setCurrentPage] = useState(`page=0`);

  const {
    isLoading,
    data: _products,
    error,
  } = useFetch(`products/admin?${currentPage}`, options);

  useEffect(() => {
    if (_products) {
      const productList = _products;
      setProducts(productList);
    }
  }, [_products]);

  useEffect(() => {
    if (state.jwt) {
      const option = {
        method: 'GET',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
          Authorization: 'Bearer ' + state.jwt,
        },
      };
      setOptions(option);
    }
  }, [state]);

  return {
    products,
    isLoading,
    setCurrentPage,
  };
};

export default useAdmin;
