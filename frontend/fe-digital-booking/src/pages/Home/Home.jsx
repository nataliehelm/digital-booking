import React from 'react';
import CategoryList from './components/CategoryList';
import ProductList from './components/ProductList';
import Searcher from './components/Searcher';
import styles from './Home.module.scss';

const Home = () => {
  return (
    <div className={styles['home-container']}>
      <Searcher />
      <CategoryList />
      <ProductList />
    </div>
  );
};

export default Home;
