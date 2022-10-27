import React from 'react';
import styles from './ProductList.module.scss';
import { Heading } from '../../atoms';
import API from './lib/data.json';
import ProductCard from '../ProductCard';

const ProductList = () => {
  /*  const { isLoading, errorMessage, data } = useFetch(API);

   if (isLoading)
    return (
      <div className={styles['category-list-container']}>
        <figure>
          <img src="assets/loading-gif.gif" alt="Loading..."></img>
        </figure>
      </div>
    ); */

  return (
    <div className={styles['product-list-container']}>
      <div className={styles['list-header']}>
        <Heading variant="h1">Recomendaciones</Heading>
      </div>
      <div className={styles.list}>
        <ul>
          {API.slice(0, 8).map((producto) => {
            return (
              <li key={producto.id}>
                <ProductCard
                  img={producto.image_url}
                  category={producto.category.toUpperCase()}
                  title={producto.title}
                  score={producto.score}
                  location={producto.location}
                  description={producto.description}
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
