import { Button, Heading, Rank, Text } from '../../../../atoms';
import styles from './BookingDetails.module.scss';
import { format } from 'date-fns';

const BookingDetails = ({
  image,
  title,
  subtitle,
  ranking,
  address,
  location,
  range,
  disabled,
  onClick,
}) => {
  const { startDate, endDate } = range[0];
  const startDateFormatted = format(startDate, 'dd/MM/yyyy');
  const endDateFormatted = format(endDate, 'dd/MM/yyyy');

  return (
    <div className={styles.container}>
      <Heading variant="h2" classname={styles.title}>
        Detalle de la reserva
      </Heading>
      <div className={styles.wrapper}>
        <div className={styles.image}>
          <img src={image} alt={subtitle}></img>
        </div>
        <div className={styles.details}>
          <Heading variant="h4">{title.toUpperCase()}</Heading>
          <Heading variant="h2">{subtitle}</Heading>
          <Rank ranking={ranking} />
          <div className={styles.location}>
            <i className="fa-solid fa-location-dot"></i>
            <Text variant="t1">
              <span>
                {address} - {location}
              </span>
            </Text>
          </div>
          <div className={styles.divider}></div>
          <div className={styles.dates}>
            <Heading variant="h3">Check In</Heading>
            <span>{startDateFormatted}</span>
          </div>
          <div className={styles.divider}></div>
          <div className={styles.dates}>
            <Heading variant="h3">Check Out</Heading>
            <span>{endDateFormatted}</span>
          </div>
          <div className={styles.divider}></div>
          <Button
            type="submit"
            variant="b1"
            classname={styles.button}
            disabled={disabled}
            onClick={onClick}
          >
            Confirmar reserva
          </Button>
        </div>
      </div>
    </div>
  );
};

export default BookingDetails;
