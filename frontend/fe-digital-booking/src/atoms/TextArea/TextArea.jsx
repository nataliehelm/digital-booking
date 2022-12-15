import PropTypes from 'prop-types';
import cn from 'classnames';
import styles from './TextArea.module.scss';
import Text from '../Text/Text';

const TextArea = ({
  value,
  placeholder,
  onChange,
  variant,
  hasError,
  errorMessage,
}) => {
  const variantClass = {
    t1: 'textarea-1',
    t2: 'textarea-2',
  }[variant];
  return (
    <>
      <textarea
        className={cn(
          styles['textarea-container'],
          styles[variantClass],
          'text-2',
          { [styles['textarea-error']]: hasError }
        )}
        placeholder={placeholder}
        onChange={onChange}
        value={value}
      ></textarea>
      {hasError && errorMessage && (
        <Text variant="t2" classname={styles['label-error']}>
          {errorMessage}
        </Text>
      )}
    </>
  );
};

TextArea.propTypes = {
  variant: PropTypes.oneOf(['t1', 't2']).isRequired,
  value: PropTypes.string.isRequired,
  placeholder: PropTypes.string,
  onChange: PropTypes.func,
  hasError: PropTypes.bool,
  errorMessage: PropTypes.string,
};

export default TextArea;
