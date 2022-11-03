import Heading from '../../atoms/Heading/Heading';
import Description from './components/Description/Description';
import Services from './components/Services';
import styles from './Product.module.scss';
import items from './lib/services.json';
import { useNavigate } from 'react-router-dom';
import Map from './components/Map/Map';
import Subheader from '../../atoms/Subheader';
import Score from '../../atoms/Score';
import { Text } from '../../atoms';
import Rank from '../../atoms/Rank';
import Features from './components/Features/Features';
import Carousel from './components/Carousel/Carousel';
import data from '../Home/components/ProductList/lib/data.json';

const Product = () => {
  const title = 'HOTEL';
  const subtitle = 'Hermitage Hotel';
  const address = 'Buenos Aires, Ciudad Autónoma de Buenos Aires, Argentina ';
  const navigate = useNavigate();
  const onBackClick = () => {
    navigate(-1);
  };

  const images = data[0].image_url;
  return (
    <>
      <Subheader title={title} subtitle={subtitle} onBackClick={onBackClick} />
      <div className={styles.location}>
        <section className={styles.loc}>
          <i className="fa-solid fa-location-dot"></i>
          <Text variant="t1">{address}</Text>
        </section>
        <section className={styles.ranking}>
          <div>
            <Text variant="t1">Muy bueno</Text>
            <Rank ranking={4} />
          </div>
          <Score score={8} />
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
          <Services items={items} />
        </section>
        <Map location="Buenos Aires, Argentina" />
        <Features partiesAllowed smokeAllowed checkout="10:00" />
      </div>
    </>
  );
};

export default Product;
