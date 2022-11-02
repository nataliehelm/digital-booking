import Heading from '../../atoms/Heading/Heading';
import Description from './components/Description/Description';
import Services from './components/Services';
import styles from './Product.module.scss';
import items from './lib/services.json';
import Map from './components/Map/Map';
import Features from './components/Features/Features';

const Product = () => {
  return (
    <div className={styles.container}>
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
  );
};

export default Product;
