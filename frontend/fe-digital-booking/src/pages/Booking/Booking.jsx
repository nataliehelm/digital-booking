import { Heading, Subheader } from '../../atoms';
import { Policies } from '../Product/components';
import { useBreakpoint } from '../../hooks';
import styles from './Booking.module.scss';
import 'react-date-range/dist/styles.css';
import BookingDetails from './components/BookingDetails';
import BookingCalendar from '../../components/BookingCalendar';
import { useState } from 'react';
import { addDays } from 'date-fns';

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
        </div>
        <div className={styles['right-container']}>
          <BookingDetails
            image={image}
            title={title}
            subtitle={subtitle}
            ranking={ranking}
            address={address}
            location={location}
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
