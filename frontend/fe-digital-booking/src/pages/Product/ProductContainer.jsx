import { useParams } from 'react-router-dom';
import useFetch from '../../hooks/useFetch/useFetch';
import Product from './Product';

const ProductContainer = () => {
  const { id } = useParams();

  const { isLoading, data: product } = useFetch(`products/${id}`);

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
      category={product.category.name}
      name={product.name}
      address={`${product.location.name}, ${product.location.country}`}
      ranking={product.ranking}
      score={product.score}
      images={product.images}
      features={product.features}
      coordinates={product.coordinates}
      policies={product.policies}
      subtitle={product.description_title}
      description={product.description}
    />
  );
};

export default ProductContainer;
