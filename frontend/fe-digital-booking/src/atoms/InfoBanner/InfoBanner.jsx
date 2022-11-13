import PropTypes from 'prop-types';
import styles from './InfoBanner.module.scss';

const InfoBanner = ({ children }) => {
  return <div className={styles['info-banner']}>{children}</div>;
};

InfoBanner.propTypes = {
  children: PropTypes.element.isRequired,
};

export default InfoBanner;
