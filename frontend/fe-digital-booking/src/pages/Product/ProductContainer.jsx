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
      name={product.name}
      ranking={product.ranking}
      score={product.score}
      images={product.images}
      features={product.features}
      coordinates={product.coordinates}
      policies={product.policies}
      description={product.description}
      id={product.id}
      booking={bookings}
      address={`${product.location.city_name}, ${product.location.province_name}, ${product.location.country_name}`}
      reference={product.distance_to_nearest_tourist_site}
      subtitle={product.description_title}
      category={product.category.name}
    />
  );
};

export default ProductContainer;
