import { useParams, useNavigate } from 'react-router-dom';
import useFetch from '../../hooks/useFetch/useFetch';
import Booking from './Booking';

const BookingContainer = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const onBackClick = () => {
    navigate(-1);
  };
  const minDate = new Date();

  const { isLoading, data } = useFetch(`products/${id}/bookings`);

  if (isLoading)
    return (
      <div>
        <figure>
          <img src="assets/loading-gif.gif" alt="Loading..."></img>
        </figure>
      </div>
    );

  return (
    <Booking
      title={data.product.category.name}
      subtitle={data.product.name}
      onBackClick={onBackClick}
      booking={data.bookings}
      policies={data.product.policies}
      image={data.product.images[0].url}
      ranking={data.product.ranking}
      address={data.product.address}
      location={`${data.product.location.city_name}, ${data.product.location.province_name}, ${data.product.location.country_name}`}
      minDate={minDate}
    />
  );
};

export default BookingContainer;
