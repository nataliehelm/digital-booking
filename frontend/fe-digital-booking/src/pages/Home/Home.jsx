import { useEffect, useState, useMemo, useRef } from 'react';
import { useFetch } from '../../hooks';
import { ProductList, CategoryList, Searcher } from './components';
import styles from './Home.module.scss';
import { Toast } from '../../atoms';
import useAuthContext from '../../providers/AuthProvider/useAuthContext';
import { addDays } from 'date-fns/esm';
import { isSameOrBefore } from '../../utils/dates';
import { format, parseISO } from 'date-fns';

const Home = () => {
  const { state } = useAuthContext();
  const scrollRef = useRef(null);
  const [requestOptions, setRequestOptions] = useState(null);
  const [categoryIds, setCategoryIds] = useState([]);
  const [categoryNames, setCategoryNames] = useState([]);
  const [datesRange, setDatesRange] = useState([
    {
      startDate: addDays(new Date(), -1),
      endDate: addDays(new Date(), -1),
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
      setDatesRange([
        {
          startDate: addDays(new Date(), -1),
          endDate: addDays(new Date(), -1),
          key: 'selection',
        },
      ]);
    }
  }, [categoryIds]);

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
    setCategoryIds([]);
    setCategoryNames([]);
    const hasDateFilter = isSameOrBefore(new Date(), datesRange[0].startDate);
    let finalEndpoint = 'products';
    if (locationSelected || hasDateFilter) {
      finalEndpoint += '/filters/?';
      if (locationSelected) {
        finalEndpoint += `locationId=${locationSelected.id}&`;
      }
      if (hasDateFilter) {
        const { startDate, endDate } = datesRange[0];
        const startingDate = format(
          parseISO(startDate.toISOString()),
          'yyyy-MM-dd'
        );
        const endingDate = format(
          parseISO(endDate.toISOString()),
          'yyyy-MM-dd'
        );
        finalEndpoint += `startingDate=${startingDate}&endingDate=${endingDate}&`;
      }
    }
    setEndpoint(finalEndpoint);
  };

  const scrollBottom = (e) => {
    e.current.scrollIntoView({
      behavior: 'smooth',
    });
  };

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
        onClick={() => scrollBottom(scrollRef)}
      />
      <CategoryList
        isLoading={isLoadingCategories}
        categories={categories}
        onClick={handleSelectIds}
        selectedIds={categoryIds}
      />
      <div ref={scrollRef}>
        <ProductList
          recommendationsTitle={recommendationsTitle}
          isLoading={isLoadingProducts}
          products={products}
        />
      </div>
    </div>
  );
};

export default Home;
