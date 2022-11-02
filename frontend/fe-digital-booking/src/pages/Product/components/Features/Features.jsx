import Heading from '../../../../atoms/Heading/Heading';
import styles from './Features.module.scss';
import Feature from './Feature';

const Features = () => {
  return (
    <section className={styles['features-container']}>
      <Heading variant="h1" classname={styles['title']}>
        Qué tenés que saber
      </Heading>
      <div className={styles.divider}></div>
      <div className={styles.features}>
        <Feature
          title="Normas de la casa"
          items={['Check-out: 10:00', 'No se permiten fiestas', 'No fumar']}
        />
        <Feature
          title="Salud y seguridad"
          items={[
            'Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus',
            'Detector de humo',
            'Depósito de seguridad',
          ]}
        />
        <Feature
          title="Política de cancelación"
          items={[
            'Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.',
          ]}
        />
      </div>
    </section>
  );
};
export default Features;
