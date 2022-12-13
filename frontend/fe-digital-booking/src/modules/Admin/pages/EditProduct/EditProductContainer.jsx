import { Loader } from '../../../../components';
import EditProduct from './EditProduct';
import useEditProduct from './hooks/useEditProduct';
import styles from './EditProduct.module.scss';

const EditProductContainer = () => {
  const props = useEditProduct();

  return props.isLoading ? (
    <div className={styles.loader}>
      <Loader />
    </div>
  ) : (
    <EditProduct {...props} />
  );
};

export default EditProductContainer;
