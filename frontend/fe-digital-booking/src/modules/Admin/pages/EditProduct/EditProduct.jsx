import { useMemo } from 'react';
import { useNavigate } from 'react-router-dom';
import { Button, Heading, Subheader, Toast, useInput } from '../../../../atoms';
import { mandatoryValidator } from '../../../../utils/validators';
import {
  Description,
  Features,
  Images,
  LocationInfo,
  Policies,
  ProductInfo,
} from '../CreateProduct/components';
import styles from './EditProduct.module.scss';

const EditProduct = ({
  product,
  categories,
  setCategorySelected,
  slogan,
  address,
  distance,
  locations,
  setCoords,
  setLocationSelected,
  lat,
  lng,
  description,
  features,
  handleOnCheckboxChange,
  policyCancel,
  policyHouse,
  policySecurity,
  images,
  setImages,
  createProductError,
  coords,
}) => {
  const name = useInput(product?.name || '', mandatoryValidator);
  const navigate = useNavigate();
  const onBackClick = () => {
    navigate(-1);
  };

  const IMAGES_MIN_LENGTH = 5;

  const handleOnSubmit = () => {
    const finalCoords = [coords.lat, coords.lng];
    const uploadedImages = images.filter((image) => image.value !== '');
    const finalImages = uploadedImages.map((i) => ({
      title: name.value,
      url: i.value,
    }));
  };

  const disabled = useMemo(() => {
    if (features.every((f) => !f.isChecked)) return true;
    if (images.length < 6) return true;
    return [
      name,
      slogan,
      address,
      distance,
      lat,
      lng,
      policyCancel,
      policyHouse,
      policySecurity,
      description,
    ].some((item) => item.value === '' || item.hasError);
  }, [
    address,
    description,
    distance,
    features,
    images.length,
    lat,
    lng,
    name,
    policyCancel,
    policyHouse,
    policySecurity,
    slogan,
  ]);

  return (
    <>
      <Subheader subtitle="Administración" onBackClick={onBackClick} />
      <div className={styles['create-product-container']}>
        <Heading variant="h2" classname={styles.title}>
          Editar propiedad
        </Heading>
        <div className={styles['form-container']}>
          <ProductInfo
            categories={categories}
            name={name}
            setCategorySelected={setCategorySelected}
            slogan={slogan}
          />
          <LocationInfo
            address={address}
            distance={distance}
            locations={locations}
            setCoords={setCoords}
            setLocationSelected={setLocationSelected}
            lat={lat}
            lng={lng}
          />
          <Description description={description} />
          <Features features={features} onChange={handleOnCheckboxChange} />
          <Policies
            policyCancel={policyCancel}
            policyHouse={policyHouse}
            policySecurity={policySecurity}
          />
          <Images
            images={images}
            setImages={setImages}
            hasError={
              images.length > 1 && images.length < IMAGES_MIN_LENGTH + 1
            }
            minLength={IMAGES_MIN_LENGTH}
          />
          <div className={styles.submit}>
            <Button
              type="submit"
              variant="b1"
              classname={styles.button}
              disabled={disabled}
              onClick={handleOnSubmit}
            >
              Crear
            </Button>
          </div>
          {createProductError && (
            <div className={styles['sign-up-form']}>
              <Toast
                variant="error"
                label={
                  createProductError.error ||
                  'Lamentablemente el producto no ha podido crearse. Por favor intente más tarde'
                }
              />
            </div>
          )}
        </div>
      </div>
    </>
  );
};

export default EditProduct;
