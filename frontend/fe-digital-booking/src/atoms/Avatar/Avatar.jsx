import { Heading } from '../Heading';
import styles from './Avatar.module.scss';
import PropTypes from 'prop-types';
import cn from 'classnames';

const Avatar = ({ username, classname }) => {
  const firstName = username.split(' ')[0][0].toUpperCase();
  const lastName = username.split(' ')[1]?.[0].toUpperCase() || '';

  return (
    <div className={cn(styles['avatar-container'], classname)}>
      <Heading variant="h2">{`${firstName}${lastName}`}</Heading>
    </div>
  );
};

Avatar.propTypes = {
  username: PropTypes.string.isRequired,
  classname: PropTypes.string,
};

export default Avatar;
