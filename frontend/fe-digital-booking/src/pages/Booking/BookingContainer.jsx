import { useParams, useNavigate } from 'react-router-dom';
//import useFetch from '../../hooks/useFetch/useFetch';
import Booking from './Booking';
import productData from '../Product/lib/booking.json';

const BookingContainer = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const onBackClick = () => {
    navigate(-1);
  };

  const product = productData;
  /* 
  const { isLoading, data: product } = useFetch(`products/${id}`);

  if (isLoading)
    return (
      <div>
        <figure>
          <img src="assets/loading-gif.gif" alt="Loading..."></img>
        </figure>
      </div>
    ); */

  return (
    <Booking
      title={product.category.name}
      subtitle={product.name}
      onBackClick={onBackClick}
      booking={product.booking}
      policies={product.policies}
    />
  );
};

export default BookingContainer;
