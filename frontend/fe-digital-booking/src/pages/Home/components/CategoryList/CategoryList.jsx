import styles from './CategoryList.module.scss';
import { CategoryCard } from '../CategoryCard';
import { Heading } from '../../../../atoms';
import { useFetch } from '../../../../hooks';

const CategoryList = () => {
  const endpoint = 'categories';

  const { isLoading, data } = useFetch(endpoint);

  if (isLoading)
    return (
      <div className={styles['category-list-container']}>
        <figure>
          <img src="assets/loading-gif.gif" alt="Loading..."></img>
        </figure>
      </div>
    );

  return (
    <div className={styles['category-list-container']}>
      <div className={styles['list-header']}>
        <Heading variant="h1">Buscar por tipo de alojamiento</Heading>
      </div>
      <div className={styles.list}>
        <ul>
          {data.slice(0, 4).map((categoria) => {
            return (
              <li key={categoria.id}>
                <CategoryCard
                  img={categoria.image_url}
                  title={categoria.name}
                  description={categoria.description}
                />
              </li>
            );
          })}
        </ul>
      </div>
    </div>
  );
};

export default CategoryList;
