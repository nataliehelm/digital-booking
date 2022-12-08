import { useNavigate } from 'react-router-dom';
import { Subheader } from '../../atoms';
import IconCard from '../../atoms/IconCard';
import { Loader } from '../../components';
import styles from './Admin.module.scss';
import AdminCard from './components/AdminCard';

const Admin = ({ products, isLoading }) => {
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

  if (isLoading)
    return (
      <div className={styles.loader}>
        <Loader />
      </div>
    );

  return (
    <div className={styles['main-container']}>
      <Subheader subtitle={'Administración'} onBackClick={onBackClick} />
      <div className={styles.container}>
        <div className={styles.cards}>
          <IconCard
            icon="fa-solid fa-plus"
            text="Crear producto"
            onClick={onCreate}
            buttonVariant="b2"
            buttonType="button"
          />
          {products.map((product) => {
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
  );
};

export default Admin;
