import { useNavigate } from 'react-router-dom';
import {
  Heading,
  Subheader,
  Score,
  Button,
  Text,
  Rank,
  Modal,
  SocialMedia,
} from '../../atoms';
import { useBreakpoint } from '../../hooks';
import {
  Description,
  Features,
  Map,
  Policies,
  Carousel,
  BookingCalendar,
} from './components';
import cn from 'classnames';
import styles from './Product.module.scss';
import { useState } from 'react';

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
  id,
}) => {
  const navigate = useNavigate();
  const onBackClick = () => {
    navigate(-1);
  };

  const [showSocialMediaModal, setShowSocialMediaModal] = useState(false);

  const breakpoint = useBreakpoint();

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
        <section className={styles['social-media']}>
          <div onClick={() => setShowSocialMediaModal(true)}>
            <i className={cn('fa-solid fa-share-nodes')} />
          </div>
        </section>
        {showSocialMediaModal && (
          <Modal onCloseModal={() => setShowSocialMediaModal(false)}>
            <SocialMedia
              url={`/product/${id}`}
              socialTypes={['whatsapp', 'facebook', 'mail', 'twitter']}
            />
          </Modal>
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
          <BookingCalendar months={['sm', 'lg'].includes(breakpoint) ? 1 : 2} />
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
