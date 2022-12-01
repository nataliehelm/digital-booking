import { Dropdown, Heading, Subheader, Text, Toast } from '../../atoms';
import { Policies } from '../Product/components';
import { useBreakpoint } from '../../hooks';
import styles from './Booking.module.scss';
import BookingDetails from './components/BookingDetails';
import { BookingCalendar } from '../../components';
import { useEffect, useMemo, useState } from 'react';
import { addDays } from 'date-fns';
import times from '../Product/lib/time-list.json';
import useFetchLazy from '../../hooks/useFetch/useFetchLazy';
import useAuthContext from '../../providers/AuthProvider/useAuthContext';
import { useNavigate, useParams } from 'react-router-dom';
import UserInfoForm from './components/UserInfoForm/UserInfoForm';

const Booking = ({
  title,
  subtitle,
  onBackClick,
  policies,
  image,
  ranking,
  address,
  location,
  minDate,
  booking,
  locations,
  user,
  locationSelected,
  setLocationSelected,
}) => {
  const breakpoint = useBreakpoint();
  const { id } = useParams();
  const navigate = useNavigate();
  const [selectedTime, setSelectedTime] = useState();
  const { state } = useAuthContext();
  const { data, error, callback } = useFetchLazy();

  const handleOnChange = (e) => {
    const time = times.find((element) => element.id === e.id);
    setSelectedTime(time.isoTime);
  };

  const [range, setRange] = useState([
    {
      startDate: new Date(),
      endDate: addDays(new Date(), 0),
      key: 'selection',
    },
  ]);
  const disabledDates = useMemo(() => {
    if (booking)
      return booking
        .map((date) => date.booked_dates)
        .flat()
        .map((date) => new Date(date));
    return [addDays(new Date(), -1)];
  }, [booking]);

  const onClick = () => {
    if (!range) return;
    if (range.startDate > range.endDate) return;

    const option = {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + state.jwt,
      },
      body: JSON.stringify({
        starting_time: selectedTime,
        starting_date: range[0].startDate,
        ending_date: range[0].endDate,
        productId: Number(id),
        userId: state.decodedJwt.userId,
        locationId: locationSelected.id,
      }),
    };
    callback('bookings/create-with-user-update', option);
  };

  useEffect(() => {
    if (data) {
      navigate('/success-booking');
    }
    if (error) {
      console.error(error);
    }
  }, [data, error, navigate]);

  return (
    <>
      <Subheader title={title} subtitle={subtitle} onBackClick={onBackClick} />
      {error && (
        <div>
          <Toast
            variant="error"
            label="Lamentablemente la reserva no ha podido realizarse. Por favor intente más tarde"
          />
        </div>
      )}
      <div className={styles.container}>
        <div className={styles['left-container']}>
          <UserInfoForm
            email={user.sub}
            lastname={user.lastname}
            locations={locations}
            name={user.name}
            onChangeLocation={setLocationSelected}
            locationSelected={locationSelected}
          />
          <div className={styles['booking-calendar']}>
            <section className={styles['col-left']}>
              <Heading variant="h1" classname={styles['calendar-title']}>
                Seleccioná tu fecha de reserva
              </Heading>
              <BookingCalendar
                months={['sm', 'lg'].includes(breakpoint) ? 1 : 2}
                setRange={setRange}
                minDate={minDate}
                range={range}
                disabledDates={disabledDates}
              />
            </section>
          </div>
          <div className={styles['dropdown-container']}>
            <Heading variant="h1">Tu horario de llegada</Heading>
            <div className={styles.dropcard}>
              <section className={styles['dropcard-text']}>
                <i className="fa-regular fa-circle-check"></i>
                <Text variant="t1">
                  Tu habitación va a estar lista para el check-in entre las
                  10:00 AM y las 11:00 PM
                </Text>
              </section>
              <section className={styles.drop}>
                <Text variant="t2" classname={styles.text}>
                  Indicá tu horario estimado de llegada
                </Text>
                <Dropdown
                  classname={styles.dropdown}
                  options={times}
                  onChange={handleOnChange}
                  placeholder="Seleccionar hora de llegada"
                />
              </section>
            </div>
          </div>
        </div>
        <div className={styles['right-container']}>
          <BookingDetails
            image={image}
            title={title}
            subtitle={subtitle}
            ranking={ranking}
            address={address}
            location={location}
            range={range}
            disabled={!selectedTime || !locationSelected}
            onClick={onClick}
          />
        </div>
      </div>
      <div className={styles.policies}>
        <Policies policies={policies} />
      </div>
    </>
  );
};

export default Booking;
