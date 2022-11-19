import { useEffect, useState, useMemo } from 'react';
import { useFetch } from '../../hooks';
import { ProductList, CategoryList, Searcher } from './components';
import styles from './Home.module.scss';
import { Toast } from '../../atoms';
import useAuthContext from '../../providers/AuthProvider/useAuthContext';

const Home = () => {
  const { state } = useAuthContext();
  const [requestOptions, setRequestOptions] = useState(null);
  const [categoryIds, setCategoryIds] = useState([]);
  const [categoryNames, setCategoryNames] = useState([]);
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
    setRequestOptions(null);
    if (state && state.jwt) {
      setRequestOptions({
        headers: {
          Authorization: state.jwt,
        },
      });
    }
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [state]);

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

  const handleSelectIds = (id, name) => {
    if (categoryIds.includes(id)) {
      setCategoryIds(categoryIds.filter((c) => c !== id));
      setCategoryNames(categoryNames.filter((c) => c !== name));
    } else {
      setCategoryIds([...categoryIds, id]);
      setCategoryNames([...categoryNames, name]);
    }
  };

  const handleOnSubmit = () => {
    if (locationSelected) {
      setEndpoint(`products/filters?locationId=${locationSelected.id}`);
      setCategoryIds([]);
      setCategoryNames([]);
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

  const recommendationsTitle = useMemo(
    () => categoryNames.join(', '),
    [categoryNames]
  );

  return (
    <div className={styles['home-container']}>
      {state && state.decodedJwt && !state.decodedJwt.isActive && (
        <Toast
          variant="error"
          label="No has activado tu cuenta, recuerda activarla y volver a loguearte para disfrutar nuestros servicios"
          isClosable
        />
      )}
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
      <ProductList
        recommendationsTitle={recommendationsTitle}
        isLoading={isLoadingProducts}
        products={products}
      />
    </div>
  );
};

export default Home;
