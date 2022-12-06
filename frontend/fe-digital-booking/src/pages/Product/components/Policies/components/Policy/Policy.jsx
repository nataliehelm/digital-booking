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
      <Text variant="t1" classname={styles['pre-line']}>
        {subPolicies}
      </Text>
    </article>
  );
};

Policy.propTypes = {
  title: PropTypes.string.isRequired,
  subPolicies: PropTypes.string.isRequired,
};

export default Policy;
