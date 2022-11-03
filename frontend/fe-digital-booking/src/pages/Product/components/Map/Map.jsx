import { MapContainer, TileLayer, Marker, Tooltip } from 'react-leaflet';
import Heading from '../../../../atoms/Heading/Heading';
import './leaflet.scss';
import styles from './Map.module.scss';
import PropTypes from 'prop-types';

const Map = ({ location }) => {
  return (
    <section className={styles['map-container']}>
      <Heading variant="h1" classname={styles['map-title']}>
        ¿Dónde vas a estar?
      </Heading>
      <div className={styles.divider}></div>
      <Heading variant="h3" classname={styles['location']}>
        {location}
      </Heading>

      <div className={styles['map-container']}>
        <MapContainer
          center={[-34.5828949, -58.4240502]}
          zoom={20}
          scrollWheelZoom={false}
        >
          <TileLayer
            attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          />
          <Marker position={[-34.5828949, -58.4240502]}>
            <Tooltip direction="right" offset={[0, 0]} opacity={1} permanent>
              Hola 🧐
            </Tooltip>
          </Marker>
        </MapContainer>
      </div>
    </section>
  );
};

Map.propTypes = {
  location: PropTypes.string.isRequired,
};

export default Map;
