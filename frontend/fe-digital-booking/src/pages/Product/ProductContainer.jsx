import { useParams } from 'react-router-dom';
import useFetch from '../../hooks/useFetch/useFetch';
import Product from './Product';
//import productData from './lib/booking';

const ProductContainer = () => {
  const { id } = useParams();
  //const product = productData;

  const { isLoading, data } = useFetch(`products/${id}/bookings`);

  if (isLoading)
    return (
      <div>
        <figure>
          <img src="assets/loading-gif.gif" alt="Loading..."></img>
        </figure>
      </div>
    );
  return (
    <Product
      category={data.product.category.name}
      name={data.product.name}
      address={`${data.product.location.city_name}, ${data.product.location.province_name}, ${data.product.location.country_name}`}
      reference={data.product.distance_to_nearest_tourist_site}
      ranking={data.product.ranking}
      score={data.product.score}
      images={data.product.images}
      features={data.product.features}
      coordinates={data.product.coordinates}
      policies={data.product.policies}
      subtitle={data.product.description_title}
      description={data.product.description}
      booking={data.bookings}
      id={data.product.id}
    />
  );
};

export default ProductContainer;
