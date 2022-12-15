import React from 'react';
import PropTypes from 'prop-types';
import { useMemo } from 'react';
import {
  Facebook,
  Mail,
  SocialIconLayout,
  Twitter,
  Whatsapp,
} from './components';
import styles from './SocialMedia.module.scss';

const socialComponents = {
  facebook: Facebook,
  whatsapp: Whatsapp,
  twitter: Twitter,
  mail: Mail,
};

const SocialMedia = ({ socialTypes, url, onClose }) => {
  const components = useMemo(
    () =>
      socialTypes.map((s) => ({
        Component: socialComponents[s],
        socialType: s,
      })),
    [socialTypes]
  );

  return (
    <div className={styles.container}>
      <div onClick={onClose} className={styles.close}>
        <i className="fa-solid fa-x" />
      </div>
      {components.map(({ Component, socialType }) => (
        <SocialIconLayout socialType={socialType} url={url}>
          <Component />
        </SocialIconLayout>
      ))}
    </div>
  );
};

SocialMedia.propTypes = {
  socialTypes: PropTypes.arrayOf(
    PropTypes.oneOf(['facebook', 'whatsapp', 'twitter', 'mail'])
  ),
  url: PropTypes.string.isRequired,
};

export default SocialMedia;
