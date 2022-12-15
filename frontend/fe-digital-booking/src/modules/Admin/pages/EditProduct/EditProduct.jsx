import { useEffect, useMemo, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Button, Heading, Subheader, Toast, useInput } from '../../../../atoms';
import { Loader } from '../../../../components';
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
  features,
  handleOnCheckboxChange,
  images,
  setImages,
  createProductError,
  coords,
  uploadFiles,
  handleOnRemove,
  categorySelected,
  userId,
  onSubmit,
  isLoading,
}) => {
  const [locationSelected, setLocationSelected] = useState(null);
  const [imageError, setImageError] = useState(false);
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
  useEffect(() => {
    if (coords) {
      lat.onChange({ target: { value: coords.lat.toString() } });
      lng.onChange({ target: { value: coords.lng.toString() } });
    }
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [coords]);
  const IMAGES_MIN_LENGTH = 5;
  useEffect(() => {
    if (!isLoading) {
      const location = locations.find((l) => l.id === product.location.id);
      if (location) {
        setLocationSelected(location);
      }
    }
  }, [isLoading, locations, product.location.id]);

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
      setImageError(true);
      console.error(error);
    }
    if (!imageError) {
      const finalCoords = [parseFloat(lat.value), parseFloat(lng.value)];

      const finalImages = urls.map((i) => ({
        title: name.value,
        url: i,
      }));
      const selectedFeatures = features
        .filter((f) => f.isChecked)
        .map((f) => f.id);

      const payload = {
        name: name.value,
        distance_to_nearest_tourist_site: distance.value,
        ranking: 0.0,
        score: 0.0,
        description_title: slogan.value,
        description: description.value,
        coordinates: finalCoords,
        address: address.value,
        categoryId: categorySelected.id,
        locationId: locationSelected?.id || product.location.id,
        featureIds: selectedFeatures,
        subPolicies: [
          {
            description: policyHouse.value,
            policy_id: 1,
          },
          {
            description: policySecurity.value,
            policy_id: 2,
          },
          {
            description: policyCancel.value,
            policy_id: 3,
          },
        ],
        images: finalImages,
        userId,
      };

      onSubmit(payload);
    }
  };

  const disabled = useMemo(() => {
    if (features.every((f) => !f.isChecked)) return true;
    if (images.length < 6) return true;
    if (!categorySelected) return true;
    //if (!locationSelected) return true;
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
    categorySelected,
    description,
    distance,
    features,
    images.length,
    lat,
    lng,
    //locationSelected,
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
            setCategorySelected={
              setCategorySelected(product.category) || setCategorySelected
            }
            slogan={slogan}
            placeholder={product.category.name}
          />
          {
            <LocationInfo
              address={address}
              distance={distance}
              locations={locations}
              setCoords={setCoords}
              locationSelected={locationSelected}
              setLocationSelected={setLocationSelected}
              placeholder={`${product.location.province_name}, ${product.location.country_name}`}
              lat={lat}
              lng={lng}
            />
          }
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
              Editar
            </Button>
          </div>
          {createProductError && (
            <div className={styles['sign-up-form']}>
              <Toast
                variant="error"
                label={
                  createProductError.error ||
                  'Lamentablemente el producto no ha podido modificarse. Por favor intente más tarde'
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
