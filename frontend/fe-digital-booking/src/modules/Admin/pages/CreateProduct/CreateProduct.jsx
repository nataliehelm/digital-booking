import { useNavigate } from 'react-router-dom';
import {
  Button,
  Dropdown,
  Heading,
  Input,
  Subheader,
  Text,
  WritableDropdown,
} from '../../../../atoms';
import styles from './CreateProduct.module.scss';
import TextArea from '../../../../atoms/TextArea/TextArea';
import Checkbox from '../../../../atoms/Checkbox';
import Loader from '../../../../components/Loader';
import Images from './components/Images';
import Address from './components/Address/Address';

const IMAGES_MIN_LENGTH = 5;

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
  lat,
  lng,
  locationSelected,
  setCoords,
  description,
  features,
  handleOnCheckboxChange,
  policy1,
  images,
  setImages,
  onClick,
  disabled,
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
              {...name}
              name="name"
              label={'Nombre de la propiedad'}
              placeholder="Nombre"
              type="text"
              value={name.value}
              onChange={name.onChange}
            />
            <Input
              {...slogan}
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
              <div className={styles['dropdown-container']}>
                <div className={styles.dropdown}>
                  <Dropdown
                    options={categories}
                    onChange={setCategorySelected}
                    placeholder="Hotel"
                    hasDivider
                  />
                </div>
              </div>
            </section>
          </div>
          <div className={styles['product-address']}>
            <Address setCoords={setCoords} address={address} />
            <Input
              {...distance}
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
              <div className={styles['dropdown-container']}>
                <div className={styles.dropdown}>
                  <WritableDropdown
                    options={locations}
                    onChange={setLocationSelected}
                    placeholder="Ciudad"
                    location={locationSelected}
                  />
                </div>
              </div>
            </section>
          </div>
          <div className={styles.places}>
            <Text variant="t2" classname={styles.text}>
              Coordenadas
            </Text>
            <div className={styles.coords}>
              <Input
                name="Latitud"
                label="Latitud"
                placeholder="Latitud:"
                type="text"
                value={lat.value}
                onChange={lat.onChange}
              />
              <Input
                name="Longitud"
                label="Longitud"
                placeholder="Longitud"
                type="text"
                value={lng.value}
                onChange={lng.onChange}
              />
            </div>
          </div>
          <div className={styles.description}>
            <Text variant="t2" classname={styles.text}>
              Descripción
            </Text>
            <TextArea
              {...description}
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
