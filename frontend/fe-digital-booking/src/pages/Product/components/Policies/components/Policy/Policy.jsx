import { Heading, Text } from '../../../../../../atoms';
import React from 'react';
import PropTypes from 'prop-types';
import styles from './../../Policies.module.scss';

const Policy = ({ subPolicies, title }) => {
  return (
    <article className={styles.policy}>
      <Heading variant="h2" classname={styles['subtitle']}>
        {title}
      </Heading>
      {subPolicies.map(({ id, description }) => (
        <Text variant="t1" key={id}>
          {description}
        </Text>
      ))}
    </article>
  );
};

Policy.propTypes = {
  title: PropTypes.string.isRequired,
  subPolicies: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      description: PropTypes.string.isRequired,
    })
  ),
};

export default Policy;
