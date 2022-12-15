import styles from './CategoryList.module.scss';
import { CategoryCard } from '../CategoryCard';
import { Heading } from '../../../../atoms';
import cn from 'classnames';

const CategoryList = ({ categories, onClick, selectedIds }) => {
  return (
    <div className={styles['category-list-container']}>
      <div className={styles['list-header']}>
        <Heading variant="h1">Buscar por tipo de alojamiento</Heading>
      </div>
      <div className={styles.list}>
        <ul>
          {categories.slice(0, 4).map((categoria) => {
            return (
              <li
                key={categoria.id}
                className={cn({
                  [styles.selected]: selectedIds.includes(categoria.id),
                })}
                onClick={() => onClick(categoria.id, categoria.name)}
              >
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
