import { Loader } from '../../components';
import { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { parsedLocationsWithoutCity } from '../../mappers/locations.mapper';
import useFetch from '../../hooks/useFetch/useFetch';
import useAuthContext from '../../providers/AuthProvider/useAuthContext';
import Booking from './Booking';
import styles from './BookingContainer.module.scss';
import withAuthGuardian from '../../hocs/withAuthGuardian';

const BookingContainer = () => {
  const { state: jwtState } = useAuthContext();
  const { id } = useParams();
  const { isLoading, data } = useFetch(`products/${id}/bookings`);
  const { isLoading: isLoadingLocations, data: _locations } =
    useFetch('locations');
  const [locations, setLocations] = useState([]);
  const navigate = useNavigate();
  const onBackClick = () => {
    navigate(-1);
  };

  const [locationSelected, setLocationSelected] = useState(null);

  useEffect(() => {
    if (!isLoadingLocations) {
      const finalLocations = parsedLocationsWithoutCity(_locations);
      setLocations(finalLocations);
      const location = finalLocations.find(
        (l) => l.id === jwtState.decodedJwt.location?.id
      );
      setLocationSelected(location);
    }
  }, [_locations, isLoadingLocations, jwtState]);

  if (isLoading || isLoadingLocations)
    return (
      <div className={styles.loader}>
        <Loader />
      </div>
    );

  return (
    <Booking
      title={data.product.category.name}
      subtitle={data.product.name}
      onBackClick={onBackClick}
      booking={data.bookings}
      policies={data.product.subPolicies}
      image={data.product.images[0].url}
      ranking={data.product.ranking}
      address={data.product.address}
      location={`${data.product.location.city_name}, ${data.product.location.province_name}, ${data.product.location.country_name}`}
      minDate={new Date()}
      locations={locations}
      user={jwtState.decodedJwt}
      locationSelected={locationSelected}
      setLocationSelected={setLocationSelected}
    />
  );
};

export default withAuthGuardian(BookingContainer);
