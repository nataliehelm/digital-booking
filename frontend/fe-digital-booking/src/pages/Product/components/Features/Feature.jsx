import React from 'react';
import Heading from '../../../../atoms/Heading/Heading';
import styles from './Features.module.scss';
import PropTypes from 'prop-types';
import Text from '../../../../atoms/Text/Text';

const Feature = ({ items, title }) => {
  return (
    <article className={styles.feature}>
      <Heading variant="h2" classname={styles['subtitle']}>
        {title}
      </Heading>
      {items.map((item, index) => (
        <Text variant="t1" key={index}>
          {item}
        </Text>
      ))}
    </article>
  );
};

Feature.propTypes = {
  title: PropTypes.string.isRequired,
  items: PropTypes.array.isRequired,
};

export default Feature;
