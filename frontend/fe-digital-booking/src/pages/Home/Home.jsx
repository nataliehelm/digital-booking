import { Toast } from '../../atoms';
import { Loader } from '../../components';
import { useBreakpoint } from '../../hooks';
import { useMemo, useRef } from 'react';
import { ProductList, CategoryList, Searcher } from './components';
import styles from './Home.module.scss';

const Home = ({
  authState,
  categories,
  categoryIds,
  categoryNames,
  datesRange,
  handleOnSubmit,
  handleOnPageChange,
  handleSelectIds,
  isLoading,
  isLoadingProducts,
  locations,
  locationSelected,
  products,
  setDatesRange,
  setLocationSelected,
}) => {
  const breakpoint = useBreakpoint();
  const scrollRef = useRef(null);

  const scrollBottom = (element) => {
    element.current.scrollIntoView({
      behavior: 'smooth',
    });
  };

  const recommendationsTitle = useMemo(
    () => categoryNames.join(', '),
    [categoryNames]
  );

  if (isLoading || !products)
    return (
      <div className={styles.loader}>
        <Loader />
      </div>
    );

  const displayPages =
    products.totalPages < 5
      ? products.totalPages
      : breakpoint === 'sm'
      ? 3
      : breakpoint === 'md'
      ? 5
      : 10;

  return (
    <div className={styles['home-container']}>
      {authState?.decodedJwt?.isActive === false && (
        <Toast
          variant="error"
          label="No has activado tu cuenta, recuerda activarla y volver a loguearte para disfrutar nuestros servicios"
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
        locations={locations}
      />
      <CategoryList
        categories={categories}
        onClick={handleSelectIds}
        selectedIds={categoryIds}
      />
      <div ref={scrollRef}>
        <ProductList
          recommendationsTitle={recommendationsTitle}
          isLoading={isLoadingProducts}
          products={products.content}
          currentPage={products.number + 1}
          onPageChange={handleOnPageChange}
          isFirstPage={products.first}
          isLastPage={products.last}
          displayPages={displayPages}
        />
      </div>
    </div>
  );
};

export default Home;
