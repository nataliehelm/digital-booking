import { Dropdown, Heading, Subheader, Text } from '../../atoms';
import { Policies } from '../Product/components';
import { useBreakpoint } from '../../hooks';
import styles from './Booking.module.scss';
import 'react-date-range/dist/styles.css';
import BookingDetails from './components/BookingDetails';
import BookingCalendar from '../../components/BookingCalendar';
import { useState } from 'react';
import { addDays } from 'date-fns';
import times from '../Product/lib/time-list.json';
import { useEffect } from 'react';

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
}) => {
  const breakpoint = useBreakpoint();
  const [selectedTime, setSelectedTime] = useState();
  console.log(selectedTime);

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

  return (
    <>
      <Subheader title={title} subtitle={subtitle} onBackClick={onBackClick} />
      <div className={styles.container}>
        <div className={styles['left-container']}>
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
              <section>
                <Text variant="t2" classname={styles.text}>
                  Indicá tu horario estimado de llegada
                </Text>
                <Dropdown
                  classname={styles.dropdown}
                  options={times}
                  onChange={handleOnChange}
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
