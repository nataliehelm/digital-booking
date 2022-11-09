import { useEffect, useState } from 'react';
import { useFetch } from '../../hooks';
import { ProductList, CategoryList, Searcher } from './components';
import styles from './Home.module.scss';

const Home = () => {
  const [options, setOptions] = useState(null);
  const [categoryIds, setCategoryIds] = useState([]);
  const { isLoading: isLoadingProducts, data: products } = useFetch(
    categoryIds.length > 0
      ? `products/filters?categoryId=${categoryIds.join(',')}`
      : 'products',
    options
  );

  const { isLoading: isLoadingCategories, data: categories } =
    useFetch('categories');

  useEffect(() => {
    const token = localStorage.getItem('userInfo');
    const parsedToken = JSON.parse(token);

    setOptions(null);
    if (parsedToken.isLogged) {
      setOptions({
        headers: {
          token,
        },
      });
    }
  }, []);

  const handleSelectIds = (id) => {
    if (categoryIds.includes(id)) {
      setCategoryIds(categoryIds.filter((c) => c !== id));
    } else {
      setCategoryIds([...categoryIds, id]);
    }
  };

  return (
    <div className={styles['home-container']}>
      <Searcher />
      <CategoryList
        isLoading={isLoadingCategories}
        categories={categories}
        onClick={handleSelectIds}
        selectedIds={categoryIds}
      />
      <ProductList isLoading={isLoadingProducts} products={products} />
    </div>
  );
};

export default Home;
