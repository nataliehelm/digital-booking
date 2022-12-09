import { useEffect, useMemo, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { useInput } from '../../../../../atoms';
import { useFetch } from '../../../../../hooks';
import useFetchLazy from '../../../../../hooks/useFetch/useFetchLazy';
import { parsedLocationsWithoutCity } from '../../../../../mappers/locations.mapper';
import useAuthContext from '../../../../../providers/AuthProvider/useAuthContext';
import { mandatoryValidator } from '../../../../../utils/validators';

const useEditProduct = () => {
  const { id } = useParams();
  const { isLoading: isLoadingProduct, data: product } = useFetch(
    `products/${id}`
  );
  console.log(product);
  const { state } = useAuthContext();

  const navigate = useNavigate();
  const [coords, setCoords] = useState();
  const [features, setFeatures] = useState([]);
  const [locations, setLocations] = useState([]);
  const [categories, setCategories] = useState([]);
  const [images, setImages] = useState([{ id: 0, value: '' }]);
  const [locationSelected, setLocationSelected] = useState(null);
  const [categorySelected, setCategorySelected] = useState(null);
  //const [productToEdit, setProductToEdit] = useState(null);

  const lat = useInput('', mandatoryValidator);
  const lng = useInput('', mandatoryValidator);
  const name = useInput(`${product?.name}`, mandatoryValidator);
  const slogan = useInput('', mandatoryValidator);
  const policyHouse = useInput('', mandatoryValidator);
  const policySecurity = useInput('', mandatoryValidator);
  const policyCancel = useInput('', mandatoryValidator);
  const address = useInput('', mandatoryValidator);
  const distance = useInput('', mandatoryValidator);
  const description = useInput('', mandatoryValidator);

  const {
    data: createProductData,
    error: createProductError,
    callback: createProduct,
  } = useFetchLazy();

  const { isLoading: isLoadingLocations, data: _locations } =
    useFetch('locations');
  const { isLoading: isLoadingCategories, data: _categories } =
    useFetch('categories');
  const { isLoading: isLoadingFeatures, data: _features } =
    useFetch('features');

  const handleOnCheckboxChange = (id) => {
    const options = features.map((f) => {
      if (f.id === id) {
        f.isChecked = !f.isChecked;
      }
      return f;
    });
    setFeatures(options);
  };

  const onSubmit = (payload) => {
    const option = {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + state.jwt,
      },
      body: JSON.stringify(payload),
    };
    createProduct('products', option);
  };

  const disabled = useMemo(() => {
    if (features.every((f) => !f.isChecked)) return true;
    if (images.length < 6) return true;
    return [
      name,
      slogan,
      categorySelected,
      address,
      distance,
      locationSelected,
      lat,
      lng,
      policyCancel,
      policyHouse,
      policySecurity,
      description,
    ].some((item) => item.value === '' || item.hasError);
  }, [
    features,
    images,
    name,
    slogan,
    categorySelected,
    address,
    distance,
    locationSelected,
    lat,
    lng,
    policyHouse,
    policyCancel,
    policySecurity,
    description,
  ]);
  /* useEffect(() => {
    if (product) {
      setProductToEdit(product);
    }
  }, [product]);
  console.log(productToEdit); */

  useEffect(() => {
    if (createProductData) {
      navigate('/create-product-success');
    }
    if (createProductError) {
      console.error(createProductError);
    }
  }, [createProductData, createProductError, navigate]);

  useEffect(() => {
    if (_locations) {
      const finalLocations = parsedLocationsWithoutCity(_locations);
      setLocations(finalLocations);
    }
  }, [_locations]);

  useEffect(() => {
    if (_categories) {
      const finalCategories = _categories.map((c) => ({
        id: c.id,
        title: c.name,
      }));
      setCategories(finalCategories);
    }
  }, [_categories]);

  return {
    product,
    categories,
    name,
    setCategorySelected,
    slogan,
    isLoading:
      isLoadingLocations ||
      isLoadingCategories ||
      isLoadingFeatures ||
      isLoadingProduct,
    address,
    distance,
    locations,
    setCoords,
    setLocationSelected,
    lat,
    lng,
    description,
    features,
    handleOnCheckboxChange,
    policyCancel,
    policyHouse,
    policySecurity,
    images,
    setImages,
    disabled,
    createProductError,
    coords,
  };
};
export default useEditProduct;
