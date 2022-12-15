import { useNavigate } from 'react-router-dom';
import useAuthContext from '../../providers/AuthProvider/useAuthContext';
import {
  Heading,
  Subheader,
  Score,
  Button,
  Text,
  Rank,
  SocialMedia,
} from '../../atoms';
import { useBreakpoint, useOnClickOutside } from '../../hooks';
import { Description, Features, Map, Policies, Carousel } from './components';
import cn from 'classnames';
import styles from './Product.module.scss';
import { useRef, useState, useMemo } from 'react';
import { BookingCalendar } from '../../components';
import { addDays } from 'date-fns';

const Product = ({
  category,
  name,
  address,
  location,
  reference,
  ranking,
  score,
  images,
  features,
  subPolicies,
  coordinates,
  subtitle,
  description,
  booking,
  id,
}) => {
  const { state } = useAuthContext();
  const navigate = useNavigate();
  const onBackClick = () => {
    navigate(-1);
  };

  const [showSocialMediaModal, setShowSocialMediaModal] = useState(false);
  const breakpoint = useBreakpoint();
  const minDate = new Date();

  const handleOnClick = () => {
    const path = `/product/${id}/booking`;
    if (state?.jwt) {
      navigate(path);
    } else {
      navigate('/login', {
        state: {
          message:
            'Para realizar una reserva debes iniciar sesión. Registrate si aún no tienes una cuenta',
          type: 'error',
          path,
        },
      });
    }
  };

  const disabledDates = useMemo(() => {
    if (booking)
      return booking
        .map((date) => date.booked_dates)
        .flat()
        .map((date) => new Date(date));
    return [addDays(new Date(), -1)];
  }, [booking]);

  const ref = useRef(null);
  useOnClickOutside(ref, () => setShowSocialMediaModal(false));

  const fullAddress = `${location.city_name}, ${location.province_name}, ${location.country_name}`;

  return (
    <>
      <Subheader title={category} subtitle={name} onBackClick={onBackClick} />
      <div className={styles.location}>
        <section className={styles.loc}>
          <aside>
            <i className="fa-solid fa-location-dot"></i>
          </aside>
          <aside>
            <Text variant="t1">{fullAddress}</Text>
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
        <section className={styles['social-media']}>
          <div onClick={() => setShowSocialMediaModal(true)}>
            <i className={cn('fa-solid fa-share-nodes')} />
          </div>
        </section>
        {showSocialMediaModal && (
          <div ref={ref}>
            <SocialMedia
              onClose={() => setShowSocialMediaModal(false)}
              url={`/product/${id}`}
              socialTypes={['whatsapp', 'facebook', 'mail', 'twitter']}
            />
          </div>
        )}
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
            onClick={handleOnClick}
            type="submit"
            variant="b1"
            classname={styles['booking-button']}
          >
            Iniciar reserva
          </Button>
        </section>
      </div>
      <div className={styles.container}>
        <Map
          location={fullAddress}
          coordinates={coordinates}
          name={name}
          address={address}
        />
        <Policies policies={subPolicies} />
      </div>
    </>
  );
};

export default Product;
