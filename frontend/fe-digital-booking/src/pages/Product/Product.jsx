import { useNavigate } from 'react-router-dom';
import { Heading, Subheader, Score, Button, Text, Rank } from '../../atoms';
import { useBreakpoint } from '../../hooks';

import { Description, Features, Map, Policies, Carousel } from './components';
import styles from './Product.module.scss';
import { useMemo } from 'react';
import BookingCalendar from '../../components/BookingCalendar/BookingCalendar';

const Product = ({
  category,
  name,
  address,
  reference,
  ranking,
  score,
  images,
  features,
  policies,
  coordinates,
  subtitle,
  description,
  booking,
}) => {
  const navigate = useNavigate();
  const onBackClick = () => {
    navigate(-1);
  };

  const breakpoint = useBreakpoint();

  const minDate = new Date();

  /*   const bookingDates = getDatesInRange(
    booking[0].starting_date,
    booking[0].ending_date
  ); */

  const disabledDates = useMemo(() => {
    return booking
      .map((date) => date.booked_dates)
      .flat()
      .map((date) => new Date(date));
  }, [booking]);

  return (
    <>
      <Subheader title={category} subtitle={name} onBackClick={onBackClick} />
      <div className={styles.location}>
        <section className={styles.loc}>
          <aside>
            <i className="fa-solid fa-location-dot"></i>
          </aside>
          <aside>
            <Text variant="t1">{address}</Text>
            <Text variant="t1">{reference}</Text>
          </aside>
        </section>
        <section className={styles.ranking}>
          <div>
            <Text variant="t1">Muy bueno</Text>
            <Rank ranking={ranking} />
          </div>
          <Score score={score} />
        </section>
      </div>
      <div className={styles.container}>
        <Carousel images={images} />
        <Description title={subtitle} description={description} />
        <section>
          <Heading variant="h1" classname={styles['services-title']}>
            ¿Qué ofrece este lugar?
          </Heading>
          <div className={styles.divider}></div>
          <Features items={features} />
        </section>
      </div>
      <div className={styles['booking-calendar']}>
        <section className={styles['col-left']}>
          <Heading variant="h1" classname={styles['booking-title']}>
            Fechas disponibles
          </Heading>
          <BookingCalendar
            months={['sm', 'lg'].includes(breakpoint) ? 1 : 2}
            minDate={minDate}
            disabledDates={disabledDates}
          />
        </section>
        <section className={styles['col-right']}>
          <Heading variant="h3" classname={styles['booking-subtitle']}>
            Agregá tus fechas de viaje para obtener precios exactos
          </Heading>
          <Button
            onClick={() => {}}
            type="submit"
            variant="b1"
            classname={styles['booking-button']}
          >
            Iniciar reserva
          </Button>
        </section>
      </div>
      <div className={styles.container}>
        <Map location={address} coordinates={coordinates} name={name} />
        <Policies policies={policies} />
      </div>
    </>
  );
};

export default Product;
