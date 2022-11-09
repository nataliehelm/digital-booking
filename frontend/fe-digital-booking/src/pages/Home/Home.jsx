import { useState } from 'react';
import { useFetch } from '../../hooks';
import { ProductList, CategoryList, Searcher } from './components';
import styles from './Home.module.scss';

const Home = () => {
  const [categoryId, setCategoryId] = useState('');
  const { isLoading, data: products } = useFetch(
    categoryId ? `products/filters?categoryId=${categoryId}` : 'products'
  );

  const { isLoading: isLoadingCategories, data: categories } =
    useFetch('categories');

  return (
    <div className={styles['home-container']}>
      <Searcher />
      <CategoryList
        isLoading={isLoadingCategories}
        categories={categories}
        onClick={setCategoryId}
      />
      <ProductList isLoading={isLoading} products={products} />
    </div>
  );
};

export default Home;
