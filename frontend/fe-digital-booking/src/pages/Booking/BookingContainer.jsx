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
  const minDate = new Date();
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
      image={product.images[0].url}
      ranking={product.ranking}
      address={product.address}
      location={`${product.location.city_name}, ${product.location.province_name}, ${product.location.country_name}`}
      minDate={minDate}
    />
  );
};

export default BookingContainer;
