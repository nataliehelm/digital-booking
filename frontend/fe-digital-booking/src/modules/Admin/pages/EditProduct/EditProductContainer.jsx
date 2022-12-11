import { Loader } from '../../../../components';
import EditProduct from './EditProduct';
import useEditProduct from './hooks/useEditProduct';
import styles from './EditProduct.module.scss';

const EditProductContainer = () => {
  const props = useEditProduct();

  if (props.isLoading)
    return (
      <div className={styles.loader}>
        <Loader />
      </div>
    );

  return <EditProduct {...props} />;
};

export default EditProductContainer;
