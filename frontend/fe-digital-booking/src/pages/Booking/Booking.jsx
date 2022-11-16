import { Heading, Subheader } from '../../atoms';
import { BookingCalendar, Policies } from '../Product/components';
import { useBreakpoint } from '../../hooks';
import styles from './Booking.module.scss';
import 'react-date-range/dist/styles.css';
import BookingDetails from './components/BookingDetails/BookingDetails';

const Booking = ({ title, subtitle, onBackClick, booking, policies }) => {
  const breakpoint = useBreakpoint();

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
                booking={booking}
              />
            </section>
          </div>
        </div>
        <div className={styles['right-container']}>
          <BookingDetails />
        </div>
      </div>
      <div className={styles.policies}>
        <Policies policies={policies} />
      </div>
    </>
  );
};

export default Booking;
