import { Dropdown, Input, Text } from '../../../../../../atoms';
import styles from './ProductInfo.module.scss';
import PropTypes from 'prop-types';

const ProductInfo = ({
  name,
  slogan,
  categories,
  setCategorySelected,
  placeholder,
}) => {
  return (
    <div className={styles['product-name']}>
      <Input
        {...name}
        name="name"
        label="Nombre de la propiedad"
        placeholder="Nombre"
        type="text"
      />
      <Input
        {...slogan}
        name="slogan"
        label="Slogan"
        placeholder="Todo Corrientes cerca a ti"
        type="text"
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
              placeholder={placeholder}
              hasDivider
            />
          </div>
        </div>
      </section>
    </div>
  );
};

ProductInfo.propTypes = {
  name: PropTypes.shape({
    value: PropTypes.string,
    onChange: PropTypes.func,
    hasError: PropTypes.bool,
    errorMessage: PropTypes.string,
  }).isRequired,
  slogan: PropTypes.shape({
    value: PropTypes.string,
    onChange: PropTypes.func,
    hasError: PropTypes.bool,
    errorMessage: PropTypes.string,
  }).isRequired,
  categories: PropTypes.array.isRequired,
  setCategorySelected: PropTypes.func.isRequired,
};

export default ProductInfo;
