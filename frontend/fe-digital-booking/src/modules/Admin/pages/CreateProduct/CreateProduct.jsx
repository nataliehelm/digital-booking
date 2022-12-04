import styles from './CreateProduct.module.scss';
import { Loader } from '../../../../components';
import {
  Images,
  ProductInfo,
  LocationInfo,
  Description,
  Features,
  Policies,
} from './components';
import { useNavigate } from 'react-router-dom';
import { Button, Heading, Subheader, Toast } from '../../../../atoms';

const IMAGES_MIN_LENGTH = 5;

const CreateProduct = ({
  address,
  categories,
  categorySelected,
  coords,
  createProductError,
  description,
  disabled,
  distance,
  features,
  handleOnCheckboxChange,
  images,
  isLoading,
  lat,
  lng,
  locations,
  locationSelected,
  name,
  onSubmit,
  policy1,
  setCategorySelected,
  setCoords,
  setImages,
  setLocationSelected,
  slogan,
}) => {
  const navigate = useNavigate();

  const onBackClick = () => {
    navigate(-1);
  };

  const handleOnSubmit = () => {
    const finalCoords = [coords.lat, coords.lng];
    const uploadedImages = images.filter((image) => image.value !== '');
    const finalImages = uploadedImages.map((i) => ({
      title: name.value,
      url: i.value,
    }));

    const selectedFeatures = features
      .filter((f) => f.isChecked)
      .map((f) => f.id);

    const payload = {
      name: name.value,
      address: address.value,
      distance_to_nearest_tourist_site: distance.value,
      description_title: slogan.value,
      description: description.value,
      coordinates: finalCoords,
      categoryId: categorySelected.id,
      locationId: locationSelected.id,
      featureIds: selectedFeatures,
      policiyIds: [1, 2, 3],
      images: finalImages,
      //userId: state.decodedJwt.userId,
    };

    onSubmit(payload);
  };

  if (isLoading)
    return (
      <div className={styles.loader}>
        <Loader />
      </div>
    );

  return (
    <>
      <Subheader subtitle="Administración" onBackClick={onBackClick} />
      <div className={styles['create-product-container']}>
        <Heading variant="h2" classname={styles.title}>
          Crear propiedad
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
          <Policies policy={policy1} />
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

export default CreateProduct;
