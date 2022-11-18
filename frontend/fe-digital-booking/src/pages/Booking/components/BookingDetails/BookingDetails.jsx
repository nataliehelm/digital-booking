import { Heading } from '../../../../atoms';
import styles from './BookingDetails.module.scss';

const BookingDetails = () => {
  return (
    <div className={styles.container}>
      <Heading variant="h2" classname={styles.title}>
        Detalle de la reserva
      </Heading>
    </div>
  );
};

export default BookingDetails;
