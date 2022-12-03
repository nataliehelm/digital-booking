import React from 'react';
import styles from './Images.module.scss';
import cn from 'classnames';
import { Heading, Text, Uploader, useInput } from '../../../../../../atoms';
import { mandatoryValidator } from '../../../../../../utils/validators';

const Images = ({ images, setImages, hasError, minLength }) => {
  const currentImage = useInput('', mandatoryValidator);
  return (
    <div className={cn(styles['images-container'])}>
      <Heading variant="h3" classname={styles.title}>
        Cargar imágenes
      </Heading>
      <div
        className={cn(styles['images-list'], {
          [styles['container-error']]: hasError,
        })}
      >
        {images.map((image) => (
          <Uploader
            id={image.id}
            key={image.id}
            value={image.value || currentImage.value}
            onChange={currentImage.onChange}
            onUpload={(value) => {
              image.value = value;
              setImages([...images, { id: image.id + 1, value: '' }]);
              currentImage.onChange({ target: { value: '' } });
            }}
            onRemove={(_, id) => {
              setImages(images.filter((image) => image.id !== id));
              currentImage.onChange({ target: { value: '' } });
            }}
            placeholder={'Insertar https://'}
            disabled={!image.value && !currentImage.value}
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
          Se deben cargar minimo {minLength} imágenes
        </Text>
      )}
    </div>
  );
};

export default Images;
