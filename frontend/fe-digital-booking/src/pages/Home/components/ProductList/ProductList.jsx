import React from 'react';
import styles from './ProductList.module.scss';
import { Heading } from '../../../../atoms';
import ProductCard from '../ProductCard';
import useFetch from '../../../../hooks/useFetch/useFetch';
import { useMemo } from 'react';

const ProductList = () => {
  const { isLoading, data } = useFetch('products');

  // TODO: crear nuevos productos y eliminar la siguiente logica
  const products = useMemo(() => {
    if (data)
      return [
        data[0],
        data[0],
        data[0],
        data[0],
        data[0],
        data[0],
        data[0],
        data[0],
      ];
  }, [data]);

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
          {products.slice(0, 8).map((product) => {
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
