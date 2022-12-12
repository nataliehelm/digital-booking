import React from 'react';
import styles from './Images.module.scss';
import cn from 'classnames';
import PropTypes from 'prop-types';
import { DragAndDrop, Heading, Text, useInput } from '../../../../../../atoms';
import { mandatoryValidator } from '../../../../../../utils/validators';

const Images = ({ actualImages, images, setImages, hasError, minLength }) => {
  const currentImage = useInput('', mandatoryValidator);

  console.log(actualImages);
  console.log(images);
  return (
    <div className={cn(styles['images-container'])}>
      <Heading variant="h3" classname={styles.title}>
        Cargar imágenes
      </Heading>
      <div
        className={cn(styles['images-drag-n-drop'], {
          [styles['container-error']]: hasError,
        })}
      >
        {/* {actualImages &&
          actualImages.map((img) => (
            <DragAndDrop
              id={img.id}
              key={img.id}
              value={img.value}
              onUpload={(value) => {
                img.value = value;
                setImages([...images, { id: img.id + 1, value: '' }]);
                currentImage.onChange({ target: { value: '' } });
              }}
              onRemove={(_, id) => {
                setImages(actualImages.filter((image) => image.id !== id));
                currentImage.onChange({ target: { value: '' } });
              }}
            />
          ))} */}

        {images.map((image) => (
          // TODO: Implementar si hace falta
          // <Uploader
          //   id={image.id}
          //   key={image.id}
          //   value={image.value || currentImage.value}
          //   onChange={currentImage.onChange}
          //   onUpload={(value) => {
          //     image.value = value;
          //     setImages([...images, { id: image.id + 1, value: '' }]);
          //     currentImage.onChange({ target: { value: '' } });
          //   }}
          //   onRemove={(_, id) => {
          //     setImages(images.filter((image) => image.id !== id));
          //     currentImage.onChange({ target: { value: '' } });
          //   }}
          //   placeholder={'Insertar https://'}
          //   disabled={!image.value && !currentImage.value}
          // />
          <DragAndDrop
            id={image.id}
            key={image.id}
            value={image.value || currentImage.value}
            onUpload={(value) => {
              image.value = value;
              image.isNew = true;
              setImages([...images, { id: image.id + 1, value: '' }]);
              currentImage.onChange({ target: { value: '' } });
            }}
            onRemove={(_, id) => {
              setImages(images.filter((image) => image.id !== id));
              currentImage.onChange({ target: { value: '' } });
            }}
          />
        ))}
      </div>
      {!hasError && (
        <Text variant="t2" classname={styles['label']}>
          *Obligatorio
        </Text>
      )}
      {hasError && (
        <Text variant="t2" classname={cn(styles.label, styles['label-error'])}>
          <span>Se deben cargar minimo {minLength} imágenes</span>
        </Text>
      )}
    </div>
  );
};

Images.propTypes = {
  images: PropTypes.array.isRequired,
  setImages: PropTypes.func.isRequired,
  hasError: PropTypes.bool.isRequired,
  minLength: PropTypes.number.isRequired,
};

export default Images;
