import Address from './Address';
import PropTypes from 'prop-types';
import styles from './LocationInfo.module.scss';
import { Input, Text, WritableDropdown } from '../../../../../../atoms';

const LocationInfo = ({
  address,
  distance,
  lat,
  lng,
  locations,
  placeholder,
  setCoords,
  locationSelected,
  setLocationSelected,
}) => {
  return (
    <>
      <div className={styles['product-address']}>
        <Address setCoords={setCoords} address={address} />
        <Input
          {...distance}
          name="distance"
          label="Distancia a punto turístico"
          placeholder="A 940 m del centro"
          type="text"
        />
        <section className={styles.categories}>
          <Text variant="t2" classname={styles.text}>
            Ciudad
          </Text>
          <div className={styles['dropdown-container']}>
            <div className={styles.dropdown}>
              <WritableDropdown
                options={locations}
                onChange={setLocationSelected}
                placeholder={placeholder}
                location={locationSelected}
              />
            </div>
          </div>
        </section>
      </div>
      <div className={styles.places}>
        <Text variant="t2" classname={styles.text}>
          Coordenadas
        </Text>
        <div className={styles.coords}>
          <Input
            {...lat}
            name="Latitud"
            label="Latitud"
            placeholder="Latitud:"
            type="text"
          />
          <Input
            {...lng}
            name="Longitud"
            label="Longitud"
            placeholder="Longitud"
            type="text"
          />
        </div>
      </div>
    </>
  );
};

LocationInfo.propTypes = {
  address: PropTypes.shape({
    value: PropTypes.string,
    onChange: PropTypes.func,
    hasError: PropTypes.bool,
    errorMessage: PropTypes.string,
  }).isRequired,
  distance: PropTypes.shape({
    value: PropTypes.string,
    onChange: PropTypes.func,
    hasError: PropTypes.bool,
    errorMessage: PropTypes.string,
  }).isRequired,
  lat: PropTypes.shape({
    value: PropTypes.string,
    onChange: PropTypes.func,
    hasError: PropTypes.bool,
    errorMessage: PropTypes.string,
  }).isRequired,
  lng: PropTypes.shape({
    value: PropTypes.string,
    onChange: PropTypes.func,
    hasError: PropTypes.bool,
    errorMessage: PropTypes.string,
  }).isRequired,
  locations: PropTypes.array.isRequired,
  setCoords: PropTypes.func.isRequired,
  setLocationSelected: PropTypes.func.isRequired,
};

export default LocationInfo;
