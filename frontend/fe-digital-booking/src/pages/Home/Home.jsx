import { useMemo, useRef } from 'react';
import { ProductList, CategoryList, Searcher } from './components';
import { Toast } from '../../atoms';
import Loader from '../../components/Loader';
import styles from './Home.module.scss';

const Home = ({
  authState,
  categories,
  categoryIds,
  categoryNames,
  datesRange,
  handleOnSubmit,
  handleSelectIds,
  isLoading,
  isLoadingProducts,
  locations,
  locationSelected,
  products,
  setDatesRange,
  setLocationSelected,
}) => {
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

  if (isLoading)
    return (
      <div className={styles.loader}>
        <Loader />
      </div>
    );

  return (
    <div className={styles['home-container']}>
      {!authState?.decodedJwt?.isActive && (
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
          products={products}
        />
      </div>
    </div>
  );
};

export default Home;
