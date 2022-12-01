import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { mandatoryValidator } from '../../../../utils/validators';
import {
  Dropdown,
  Heading,
  Input,
  Subheader,
  Text,
  useInput,
  WritableDropdown,
} from '../../../../atoms';
import { useFetch } from '../../../../hooks';
import { parsedLocationsWithoutCity } from '../../../../mappers/locations.mapper';
import styles from './CreateProduct.module.scss';

const CreateProduct = () => {
  const navigate = useNavigate();

  const [locations, setLocations] = useState([]);
  const [locationSelected, setLocationSelected] = useState(null);
  const { isLoading: isLoadingLocations, data: _locations } =
    useFetch('locations');
  const { isLoading: isLoadingCategories, data: _categories } =
    useFetch('categories');
  const [categories, setCategories] = useState([]);
  const [categorySelected, setCategorySelected] = useState(null);
  const name = useInput('', mandatoryValidator);
  const address = useInput('', mandatoryValidator);

  const onBackClick = () => {
    navigate(-1);
  };

  useEffect(() => {
    if (!isLoadingLocations) {
      const finalLocations = parsedLocationsWithoutCity(_locations);
      setLocations(finalLocations);
      //setLocationSelected(location);
    }
  }, [_locations, isLoadingLocations]);

  useEffect(() => {
    if (!isLoadingCategories) {
      const finalCategories = _categories.map((c) => ({
        id: c.id,
        title: c.name,
      }));
      setCategories(finalCategories);
      //setLocationSelected(location);
    }
  }, [_categories, isLoadingCategories]);
  return (
    <>
      <Subheader
        title={''}
        subtitle={'Administración'}
        onBackClick={onBackClick}
      />
      <div className={styles.container}>
        <Heading variant="h2" classname={styles.heading}>
          Crear propiedad
        </Heading>
        <div className={styles['create-container']}>
          <div className={styles['product-name']}>
            <Input
              name="nombre"
              label={'Nombre de la propiedad'}
              placeholder="Nombre"
              type="text"
              value={name.value}
              onChange={name.onChange}
            />
            <section className={styles.categories}>
              <Text variant="t2">Categoría</Text>
              <Dropdown
                options={categories}
                onChange={setCategorySelected}
                placeholder="Hotel"
                hasDivider
              />
            </section>
            <div className={styles['product-name']}>
              <Input
                name="address"
                label={'Dirección'}
                placeholder="Av. Colón 1643"
                type="text"
                value={address.value}
                onChange={address.onChange}
              />
              <section className={styles.categories}>
                <Text variant="t2">Ciudad</Text>
                <WritableDropdown
                  options={locations}
                  onChange={setLocationSelected}
                  placeholder="Ciudad"
                  location={locationSelected}
                />{' '}
              </section>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default CreateProduct;
