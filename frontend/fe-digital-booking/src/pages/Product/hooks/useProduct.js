import { useParams } from 'react-router-dom';
import { useFetch } from '../../../hooks';

const useProduct = () => {
  const { id } = useParams();
  const { isLoading, data } = useFetch(`products/${id}/bookings`);
  return { isLoading, data };
};

export default useProduct;
