import { useEffect, useState } from 'react';
import { useFetch } from '../../hooks';
import { ProductList, CategoryList, Searcher } from './components';
import styles from './Home.module.scss';

const Home = () => {
  const [requestOptions, setRequestOptions] = useState(null);
  const [categoryIds, setCategoryIds] = useState([]);
  const [datesRange, setDatesRange] = useState([
    {
      startDate: new Date(),
      endDate: null,
      key: 'selection',
    },
  ]);
  const [locationSelected, setLocationSelected] = useState(null);
  const [endpoint, setEndpoint] = useState('products');

  const { isLoading: isLoadingProducts, data: products } = useFetch(
    endpoint,
    requestOptions
  );

  const { isLoading: isLoadingCategories, data: categories } =
    useFetch('categories');

  useEffect(() => {
    const token = localStorage.getItem('userInfo');
    const parsedToken = JSON.parse(token);

    setRequestOptions(null);
    if (parsedToken?.isLogged) {
      setRequestOptions({
        headers: {
          token,
        },
      });
    }
  }, []);

  useEffect(() => {
    if (categoryIds.length > 0) {
      setEndpoint(`products/filters?categoryId=${categoryIds.join(',')}`);
      setLocationSelected(null);
    }
  }, [categoryIds]);

  useEffect(() => {
    if (!locationSelected && !categoryIds.length) {
      setEndpoint('products');
    }
  }, [locationSelected, categoryIds]);

  const handleSelectIds = (id) => {
    if (categoryIds.includes(id)) {
      setCategoryIds(categoryIds.filter((c) => c !== id));
    } else {
      setCategoryIds([...categoryIds, id]);
    }
  };

  const handleOnSubmit = () => {
    if (locationSelected) {
      setEndpoint(`products/filters?locationId=${locationSelected.id}`);
      setCategoryIds([]);
    }
  };

  // useEffect(() => {
  //   let categoryFilter = '';
  //   let locationFilter = '';
  //   if (categoryIds.length > 0) {
  //     categoryFilter = `categoryId=${categoryIds.join(',')}&`;
  //   }
  //   if (locationSelected) {
  //     locationFilter = `locationId=${locationSelected.id}&`;
  //   }
  //   const hasFilter = categoryIds.length > 0 || locationSelected;
  //   if (hasFilter) {
  //     setEndpoint(`products/filters?${categoryFilter}${locationFilter}`);
  //   } else {
  //     setEndpoint(`products/`);
  //   }
  // }, [categoryIds, locationSelected]);

  return (
    <div className={styles['home-container']}>
      <Searcher
        datesRange={datesRange}
        setLocationSelected={setLocationSelected}
        setDatesRange={setDatesRange}
        locationSelected={locationSelected}
        onSubmit={handleOnSubmit}
        reset={!!categoryIds.length}
      />
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
