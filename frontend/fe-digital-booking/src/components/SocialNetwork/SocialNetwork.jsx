import PropTypes from 'prop-types';
import cn from 'classnames';
import styles from './SocialNetwork.module.scss';

const SocialNetwork = ({ classname }) => {
  return (
    <div className={cn(styles.social, classname)}>
      <a href="https:/facebook.com" target="_blank" rel="noreferrer">
        <i className="fa-brands fa-facebook"></i>
      </a>
      <a href="https:/linkedin.com" target="_blank" rel="noreferrer">
        <i className="fa-brands fa-linkedin-in"></i>
      </a>
      <a href="https:/twitter.com" target="_blank" rel="noreferrer">
        <i className="fa-brands fa-twitter"></i>
      </a>
      <a href="https:/instagram.com" target="_blank" rel="noreferrer">
        <i className="fa-brands fa-instagram"></i>
      </a>
    </div>
  );
};

SocialNetwork.propTypes = {
  classname: PropTypes.string,
};

export default SocialNetwork;
