import CreateProduct from './CreateProduct';
import useCreateProduct from './hooks/useCreateProduct';

const CreateProductContainer = () => {
  const props = useCreateProduct();
  return <CreateProduct {...props} />;
};

export default CreateProductContainer;
