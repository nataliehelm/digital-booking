import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Paginator, Subheader } from '../../atoms';
import IconCard from '../../atoms/IconCard';
import { Loader } from '../../components';
import { useBreakpoint } from '../../hooks';
import styles from './Admin.module.scss';
import AdminCard from './components/AdminCard';

const Admin = ({ products, isLoading, setCurrentPage }) => {
  const navigate = useNavigate();
  const onBackClick = () => {
    navigate(-1);
  };
  const onCreate = () => {
    navigate('/admin/product/create');
  };
  const onEdit = (id) => {
    navigate(`/admin/product/${id}/edit`);
  };
  const breakpoint = useBreakpoint();

  if (isLoading || !products?.content)
    return (
      <div className={styles.loader}>
        <Loader />
      </div>
    );
  const handleOnPageChange = (page) => {
    setCurrentPage(`page=${page - 1}`);
  };
  const displayPages =
    products.totalPages < 5
      ? products.totalPages
      : breakpoint === 'sm'
      ? 3
      : breakpoint === 'md'
      ? 5
      : 10;

  return (
    <>
      <div className={styles['main-container']}>
        <Subheader subtitle={'Administración'} onBackClick={onBackClick} />
        <div className={styles['paginator-container']}>
          <Paginator
            onClick={handleOnPageChange}
            isFirstPage={products.first}
            isLastPage={products.last}
            displayPages={displayPages}
            currentPage={products.number + 1}
          />
        </div>
        <div className={styles.container}>
          <div className={styles.cards}>
            <IconCard
              icon="fa-solid fa-plus"
              text="Crear producto"
              onClick={onCreate}
              buttonVariant="b2"
              buttonType="button"
            />
            {products.content.map((product) => {
              return (
                <AdminCard
                  name={product.name}
                  image={product.images[0].url}
                  category={product.category.name}
                  address={`${product.address}, ${product.location.province_name}, ${product.location.country_name}`}
                  onClick={() => onEdit(product.id)}
                />
              );
            })}
          </div>
        </div>
      </div>
    </>
  );
};

export default Admin;
