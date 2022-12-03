import { useNavigate } from 'react-router-dom';
import {
  Button,
  Dropdown,
  Heading,
  Input,
  Subheader,
  Text,
  Uploader,
  WritableDropdown,
} from '../../../../atoms';
import styles from './CreateProduct.module.scss';
import TextArea from '../../../../atoms/TextArea/TextArea';
import Checkbox from '../../../../atoms/Checkbox';
import PlacesAutocomplete from '../components/PlacesAutocomplete';
import Loader from '../../../../components/Loader';

const CreateProduct = ({
  name,
  slogan,
  categories,
  setCategorySelected,
  address,
  distance,
  isLoading,
  locations,
  setLocationSelected,
  locationSelected,
  setCoords,
  description,
  features,
  handleOnCheckboxChange,
  policy1,
  images,
  onClick,
}) => {
  const navigate = useNavigate();
  const onBackClick = () => {
    navigate(-1);
  };

  if (isLoading)
    return (
      <div className={styles.loader}>
        <Loader />
      </div>
    );

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
            <PlacesAutocomplete
              setCoords={setCoords}
              placeholder="Ingresa un lugar o dirección"
            />
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
          <div className={styles.images}>
            <Heading variant="h3" classname={styles['features-heading']}>
              Cargar imágenes
            </Heading>
            <Uploader value={images.value} placeholder={'Insertar https://'} />
          </div>
          <div className={styles.submit}>
            <Button
              type="submit"
              variant="b1"
              classname={styles.button}
              //disabled={disabled}
              onClick={onClick}
            >
              Crear
            </Button>
          </div>
        </div>
      </div>
    </>
  );
};

export default CreateProduct;
