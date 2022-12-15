import { useState, useEffect } from 'react';
import useDragAndDrop from './hooks/useDragAndDrop';
import styles from './DragAndDrop.module.scss';

const DragAndDrop = ({ id, value, onUpload, onRemove, disabled }) => {
  const [image, setImage] = useState(null);
  const { dragOver, setDragOver, onDragOver, onDragLeave, setFileDropError } =
    useDragAndDrop();

  const onDrop = (e) => {
    e.preventDefault();

    setDragOver(false);

    const selectedFile = e?.dataTransfer?.files[0];

    if (selectedFile.type.split('/')[0] !== 'image') {
      return setFileDropError('Please provide an image file to upload!');
    }

    onUpload(selectedFile, id);
  };

  const fileSelect = (e) => {
    const selectedFile = e?.target?.files[0];

    if (selectedFile.type.split('/')[0] !== 'image') {
      return setFileDropError('Please provide an image file to upload!');
    }

    setFileDropError('');
    onUpload(selectedFile, id);
  };

  useEffect(() => {
    if (value) setImage(URL.createObjectURL(value));
  }, [value]);

  return (
    <div className={styles.container}>
      <label
        className={styles.label}
        htmlFor="file"
        onDragOver={onDragOver}
        onDragLeave={onDragLeave}
        onDrop={onDrop}
      >
        {!value && <h1>{!dragOver ? '+' : 'Drop here...'}</h1>}
      </label>
      {!image && (
        <input
          className={styles.input}
          type="file"
          name="file"
          id="file"
          onChange={fileSelect}
        />
      )}
      {image && (
        <div className={styles['layout-container']}>
          <img className={styles.image} src={image} alt={value.name} />
          <section
            className={styles.layout}
            onClick={() => {
              setImage(null);
              onRemove(value, id);
            }}
          >
            <i className="fa-solid fa-x"></i>
          </section>
        </div>
      )}
    </div>
  );
};

export default DragAndDrop;
