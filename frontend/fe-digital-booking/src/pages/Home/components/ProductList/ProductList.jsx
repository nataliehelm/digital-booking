import { Heading } from '../../../../atoms';
import { ProductCard } from '../ProductCard';
import styles from './ProductList.module.scss';

const ProductList = ({ products, isLoading }) => {
  if (isLoading)
    return (
      <div className={styles['product-list-container']}>
        <figure>
          <img src="assets/loading-gif.gif" alt="Loading..."></img>
        </figure>
      </div>
    );

  return (
    <div className={styles['product-list-container']}>
      <div className={styles['list-header']}>
        <Heading variant="h1">Recomendaciones</Heading>
      </div>
      <div className={styles.list}>
        <ul>
          {products.map((product) => {
            return (
              <li key={product.id}>
                <ProductCard
                  id={product.id}
                  img={product.images[0].url}
                  category={product.category.name.toUpperCase()}
                  title={product.name}
                  score={product.score}
                  location={product.location.name}
                  description={product.description}
                  ranking={product.ranking}
                  features={product.features}
                />
              </li>
            );
          })}
        </ul>
      </div>
    </div>
  );
};

export default ProductList;
