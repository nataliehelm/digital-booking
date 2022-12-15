import PropTypes from 'prop-types';
import { getEndpoint } from '../../utils/getEndpoint';
import styles from './SocialIconLayout.module.scss';

const SocialIconLayout = ({ children, socialType, url }) => {
  const endpoint = getEndpoint(socialType, url);
  return (
    <div
      className={styles.icon}
      onClick={() => window.open(endpoint, '_blank')}
    >
      {children}
    </div>
  );
};

SocialIconLayout.propTypes = {
  children: PropTypes.element.isRequired,
  socialType: PropTypes.oneOf(['facebook', 'whatsapp', 'twitter', 'mail'])
    .isRequired,
  url: PropTypes.string.isRequired,
};

export default SocialIconLayout;
