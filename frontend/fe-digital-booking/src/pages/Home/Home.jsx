import { ProductList, CategoryList, Searcher } from './components';
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
