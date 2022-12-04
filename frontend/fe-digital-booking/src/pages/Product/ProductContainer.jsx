import { Loader } from '../../components';
import useProduct from './hooks/useProduct';
import Product from './Product';
import styles from './ProductContainer.module.scss';

const ProductContainer = () => {
  const { isLoading, data } = useProduct();

  if (isLoading)
    return (
      <div className={styles.loader}>
        <Loader />
      </div>
    );

  return (
    <Product
      {...data.product}
      booking={data.bookings}
      address={data.product.address}
      reference={data.product.distance_to_nearest_tourist_site}
      subtitle={data.product.description_title}
      category={data.product.category.name}
    />
  );
};

export default ProductContainer;
