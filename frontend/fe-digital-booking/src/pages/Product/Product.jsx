import { useNavigate } from 'react-router-dom';
import { Heading, Subheader, Score, Button, Text, Rank } from '../../atoms';
import { useBreakpoint } from '../../hooks';
import {
  Description,
  Features,
  Map,
  Policies,
  Carousel,
  BookingCalendar,
} from './components';
import styles from './Product.module.scss';

const Product = ({
  category,
  name,
  address,
  ranking,
  score,
  images,
  features,
  policies,
  coordinates,
}) => {
  const navigate = useNavigate();
  const onBackClick = () => {
    navigate(-1);
  };

  const breakpoint = useBreakpoint();

  return (
    <>
      <Subheader title={category} subtitle={name} onBackClick={onBackClick} />
      <div className={styles.location}>
        <section className={styles.loc}>
          <i className="fa-solid fa-location-dot"></i>
          <Text variant="t1">{address}</Text>
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
        <Description
          title="Alójate en el corazón de Buenos Aires"
          description={`Está situado a solo unas calles de la avenida Alvear, de la avenida Quintana, del parque San Martín y del distrito de Recoleta. En las inmediaciones también hay varios lugares de interés, como la calle Florida, el centro comercial Galerías Pacífico, la zona de Puerto Madero, la plaza de Mayo y el palacio Municipal.\n\nNuestros clientes dicen que esta parte de Buenos Aires es su favorita, según los comentarios independientes.\n\nEl Hotel es un hotel sofisticado de 4 estrellas que goza de una ubicación tranquila, a poca distancia de prestigiosas galerías de arte, teatros, museos y zonas comerciales. Además, hay WiFi gratuita.\nEl establecimiento sirve un desayuno variado de 07:00 a 10:30.`}
        />
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
