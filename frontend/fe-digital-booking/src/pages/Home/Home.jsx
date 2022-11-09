import { useMemo, useState } from 'react';
import { useFetch } from '../../hooks';
import { ProductList, CategoryList, Searcher } from './components';
import styles from './Home.module.scss';

const Home = () => {
  const [categoryId, setCategoryId] = useState('');
  const { isLoading: isLoadingProducts, data: _products } =
    useFetch('products');
  const { isLoading: isLoadingProductsByFilters, data: _productsWithFilters } =
    useFetch(`products/filters?categoryId=${categoryId}`);
  const { isLoading: isLoadingCategories, data: categories } =
    useFetch('categories');

  const products = useMemo(
    () => _productsWithFilters || _products,
    [_products, _productsWithFilters]
  );

  return (
    <div className={styles['home-container']}>
      <Searcher />
      <CategoryList
        isLoading={isLoadingCategories}
        categories={categories}
        onClick={setCategoryId}
      />
      <ProductList
        isLoading={isLoadingProducts || isLoadingProductsByFilters}
        products={products}
      />
    </div>
  );
};

export default Home;
