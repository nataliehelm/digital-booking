import { useState } from 'react';
import Input from '../Input/Input';
import styles from './Uploader.module.scss';
import cn from 'classnames';

const Uploader = ({
  id,
  placeholder,
  value,
  onChange,
  onUpload,
  onRemove,
  disabled,
}) => {
  const [showUpload, setShowUpload] = useState(true);
  return (
    <div className={styles['uploader-container']}>
      <Input
        value={value}
        name={value}
        placeholder={placeholder}
        onChange={onChange}
      />
      {showUpload && (
        <button
          className={cn(styles.button, styles['upload-button'], {
            [styles.disabled]: disabled,
          })}
          onClick={() => {
            onUpload(value, id);
            setShowUpload(false);
          }}
          disabled={disabled}
        >
          <i className="fa-solid fa-plus"></i>
        </button>
      )}
      {!showUpload && (
        <button
          className={cn(styles.button, styles['remove-button'])}
          onClick={() => {
            onRemove(value, id);
            setShowUpload(true);
            onChange({ target: { value: '' } });
          }}
        >
          <i className="fa-solid fa-x"></i>
        </button>
      )}
    </div>
  );
};

export default Uploader;
