import { MapContainer, TileLayer, Marker, Tooltip } from 'react-leaflet';
import { Heading } from '../../../../atoms';
import PropTypes from 'prop-types';

import './leaflet.scss';
import styles from './Map.module.scss';

const Map = ({ location, coordinates, name, address = '' }) => {
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
        <MapContainer center={coordinates} zoom={20} scrollWheelZoom={false}>
          <TileLayer
            attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          />
          <Marker position={coordinates}>
            <Tooltip direction="right" offset={[0, 0]} opacity={1}>
              {`${address} - ${name}`}
            </Tooltip>
          </Marker>
        </MapContainer>
      </div>
    </section>
  );
};

Map.propTypes = {
  location: PropTypes.string.isRequired,
  coordinates: PropTypes.array.isRequired,
  name: PropTypes.string.isRequired,
  address: PropTypes.string,
};

export default Map;
