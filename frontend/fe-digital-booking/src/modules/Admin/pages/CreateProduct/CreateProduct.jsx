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
import TextArea from '../../../../atoms/TextArea/TextArea';
import Checkbox from '../../../../atoms/Checkbox';
import useFetchLazy from '../../../../hooks/useFetch/useFetchLazy';
import PlacesAutocomplete from '../components/PlacesAutocomplete';

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
  const slogan = useInput('', mandatoryValidator);
  const address = useInput('', mandatoryValidator);
  const distance = useInput('', mandatoryValidator);
  const description = useInput('', mandatoryValidator);
  const policy1 = useInput('', mandatoryValidator);

  const [features, setFeatures] = useState([]);

  const onBackClick = () => {
    navigate(-1);
  };

  const { isLoading: isLoadingFeatures, data: _features } =
    useFetch('features');

  const handleOnCheckboxChange = (id) => {
    const options = features.map((f) => {
      if (f.id === id) {
        f.isChecked = !f.isChecked;
      }
      return f;
    });
    setFeatures(options);
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

  useEffect(() => {
    if (!isLoadingFeatures) {
      const finalFeatures = _features.map((f) => ({
        id: f.id,
        title: f.name,
        icon: f.icon,
        isChecked: false,
      }));
      setFeatures(finalFeatures);
      //setLocationSelected(location);
    }
  }, [_features, isLoadingFeatures]);

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
              name="name"
              label={'Nombre de la propiedad'}
              placeholder="Nombre"
              type="text"
              value={name.value}
              onChange={name.onChange}
            />
            <Input
              name="slogan"
              label={'Slogan'}
              placeholder="Todo Corrientes cerca a ti"
              type="text"
              value={slogan.value}
              onChange={slogan.onChange}
            />
            <section className={styles.categories}>
              <Text variant="t2" classname={styles.text}>
                Categoría
              </Text>
              <Dropdown
                options={categories}
                onChange={setCategorySelected}
                placeholder="Hotel"
                hasDivider
              />
            </section>
          </div>
          <div className={styles['product-address']}>
            <Input
              name="address"
              label={'Dirección'}
              placeholder="Av. Colón 1643"
              type="text"
              value={address.value}
              onChange={address.onChange}
            />
            <Input
              name="distance"
              label={'Distancia a punto turístico'}
              placeholder="A 940 m del centro"
              type="text"
              value={distance.value}
              onChange={distance.onChange}
            />
            <section className={styles.categories}>
              <Text variant="t2" classname={styles.text}>
                Ciudad
              </Text>
              <WritableDropdown
                options={locations}
                onChange={setLocationSelected}
                placeholder="Ciudad"
                location={locationSelected}
              />
            </section>
          </div>
          <div className={styles.places}>
            <Text variant="t2" classname={styles.text}>
              Coordenadas
            </Text>
            <PlacesAutocomplete placeholder="Ingresa un lugar o dirección" />
          </div>
          <div className={styles.description}>
            <Text variant="t2" classname={styles.text}>
              Descripción
            </Text>
            <TextArea
              variant="t1"
              value={description.value}
              onChange={description.onChange}
            />
          </div>
          <div className={styles.features}>
            <Heading variant="h2" classname={styles['features-heading']}>
              Agregar atributos
            </Heading>
            <div className={styles.checkbox}>
              {features.length &&
                features.map((f) => (
                  <Checkbox
                    key={f.id}
                    id={f.id}
                    name={f.title}
                    value={f.title}
                    label={f.title}
                    isChecked={f.isChecked}
                    onChange={handleOnCheckboxChange}
                    icon={f.icon}
                  />
                ))}
            </div>
          </div>
          <div className={styles.policies}>
            <Heading variant="h2" classname={styles['features-heading']}>
              Políticas del producto
            </Heading>
            <div className={styles['policies-container']}>
              <section>
                <Heading variant="h3" classname={styles['features-heading']}>
                  Normas de la casa
                </Heading>
                <Text variant="t2" classname={styles.text}>
                  Descripción
                </Text>
                <TextArea
                  variant="t2"
                  value={policy1.value}
                  onChange={policy1.onChange}
                />
              </section>
              <section>
                <Heading variant="h3" classname={styles['features-heading']}>
                  Salud y seguridad
                </Heading>
                <Text variant="t2" classname={styles.text}>
                  Descripción
                </Text>
                <TextArea
                  variant="t2"
                  value={policy1.value}
                  onChange={policy1.onChange}
                />
              </section>
              <section>
                <Heading variant="h3" classname={styles['features-heading']}>
                  Política de cancelación
                </Heading>
                <Text variant="t2" classname={styles.text}>
                  Descripción
                </Text>
                <TextArea
                  variant="t2"
                  value={policy1.value}
                  onChange={policy1.onChange}
                />
              </section>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default CreateProduct;
