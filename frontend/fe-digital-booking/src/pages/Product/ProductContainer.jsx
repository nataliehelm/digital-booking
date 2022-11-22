import { useParams } from 'react-router-dom';
import useFetch from '../../hooks/useFetch/useFetch';
import Product from './Product';

const ProductContainer = () => {
  const { id } = useParams();
  const { isLoading, data } = useFetch(`products/${id}/bookings`);

  if (isLoading)
    return (
      <div>
        <figure>
          <img src="assets/loading-gif.gif" alt="Loading..."></img>
        </figure>
      </div>
    );
  const { product, bookings } = data;
  return (
    <Product
      {...product}
      booking={bookings}
      address={product.address}
      reference={product.distance_to_nearest_tourist_site}
      subtitle={product.description_title}
      category={product.category.name}
    />
  );
};

export default ProductContainer;
