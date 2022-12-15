import { Heading, Paginator } from '../../../../atoms';
import { ProductCard } from '../ProductCard';
import styles from './ProductList.module.scss';

const ProductList = ({
  products,
  isLoading,
  recommendationsTitle,
  currentPage,
  onPageChange,
  isFirstPage,
  isLastPage,
  displayPages,
}) => {
  if (isLoading)
    return (
      <div className={styles.loader}>
        <Heading variant="h3">Cargando productos</Heading>
        <div className={styles['lds-ellipsis']}>
          <div></div>
          <div></div>
          <div></div>
          <div></div>
        </div>
      </div>
    );

  return (
    <div className={styles['product-list-container']}>
      <div className={styles['list-header']}>
        <Heading variant="h1">
          <>
            Recomendaciones{' '}
            {recommendationsTitle && `de: ${recommendationsTitle}`}
          </>
        </Heading>
      </div>
      <div className={styles.list}>
        <ul>
          {products.map((product) => {
            return (
              <li key={product.id}>
                <ProductCard
                  id={product.id}
                  img={product.images[0]?.url || []}
                  category={product.category.name.toUpperCase()}
                  title={product.name}
                  score={product.score}
                  location={product.location.province_name}
                  description={product.description}
                  ranking={product.ranking}
                  features={product.features}
                />
              </li>
            );
          })}
        </ul>
      </div>
      <div className={styles['paginator-container']}>
        <Paginator
          currentPage={currentPage}
          onClick={onPageChange}
          isFirstPage={isFirstPage}
          isLastPage={isLastPage}
          displayPages={displayPages}
        />
      </div>
    </div>
  );
};

export default ProductList;
