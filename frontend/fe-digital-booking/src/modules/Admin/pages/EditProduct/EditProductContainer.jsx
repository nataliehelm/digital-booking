import EditProduct from './EditProduct';
import useEditProduct from './hooks/useEditProduct';

const EditProductContainer = () => {
  const props = useEditProduct();
  return <EditProduct {...props} />;
};

export default EditProductContainer;
