import { useMemo } from 'react';
import { useNavigate } from 'react-router-dom';
import { Button, Heading, Subheader, Toast, useInput } from '../../../../atoms';
import { mandatoryValidator } from '../../../../utils/validators';
import {
  Description,
  Features,
  LocationInfo,
  Policies,
  ProductInfo,
} from '../CreateProduct/components';
import Images from './components/Images/Images';
import styles from './EditProduct.module.scss';

const EditProduct = ({
  product,
  categories,
  setCategorySelected,
  locations,
  setCoords,
  setLocationSelected,
  features,
  handleOnCheckboxChange,
  images,
  setImages,
  createProductError,
  coords,
  uploadFiles,
  handleOnRemove,
}) => {
  const name = useInput(product?.name || '', mandatoryValidator);
  const slogan = useInput(product?.description_title || '', mandatoryValidator);
  const lat = useInput(product?.coordinates[0] || '', mandatoryValidator);
  const lng = useInput(product?.coordinates[1] || '', mandatoryValidator);

  const policyHouse = useInput(
    product?.subPolicies[0].description || '',
    mandatoryValidator
  );
  const policySecurity = useInput(
    product?.subPolicies[1].description || '',
    mandatoryValidator
  );
  const policyCancel = useInput(
    product?.subPolicies[2].description || '',
    mandatoryValidator
  );
  const address = useInput(product?.address || '', mandatoryValidator);
  const distance = useInput(
    product?.distance_to_nearest_tourist_site || '',
    mandatoryValidator
  );
  const description = useInput(product?.description || '', mandatoryValidator);
  const navigate = useNavigate();
  const onBackClick = () => {
    navigate(-1);
  };
  const actualImages = product.images.map((img) => ({
    id: img.id,
    value: img.url,
  }));

  const IMAGES_MIN_LENGTH = 5;
  console.log(product);

  const handleOnSubmit = async () => {
    const urls = [];
    const files = images.filter((image) => image.value);
    try {
      for (const image of files) {
        if (image.isNew) {
          const file = new FormData();
          file.append('file', image.value);
          const response = await uploadFiles(file);
          urls.push(response);
        }
      }
    } catch (error) {
      console.error(error);
    }

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
            placeholder={product.category.name}
          />
          <LocationInfo
            address={address}
            distance={distance}
            locations={locations}
            setCoords={setCoords}
            setLocationSelected={setLocationSelected}
            placeholder={`${product.location.province_name}, ${product.location.country_name}`}
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
            actualImages={actualImages}
            images={images}
            setImages={setImages}
            hasError={
              images.length > 1 && images.length < IMAGES_MIN_LENGTH + 1
            }
            minLength={IMAGES_MIN_LENGTH}
            onRemove={handleOnRemove}
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
