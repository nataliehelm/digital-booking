import { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { useFetch } from '../../../../../hooks';
import useFetchLazy from '../../../../../hooks/useFetch/useFetchLazy';
import { parsedLocationsWithoutCity } from '../../../../../mappers/locations.mapper';
import useAuthContext from '../../../../../providers/AuthProvider/useAuthContext';

const useEditProduct = () => {
  const { id } = useParams();
  const { isLoading: isLoadingProduct, data: product } = useFetch(
    `products/${id}`
  );
  const { state } = useAuthContext();

  const navigate = useNavigate();
  const [coords, setCoords] = useState();
  const [features, setFeatures] = useState([]);
  const [locations, setLocations] = useState([]);
  const [categories, setCategories] = useState([]);
  const [images, setImages] = useState([{ id: 0, value: '' }]);
  const [locationSelected, setLocationSelected] = useState(null);
  const [categorySelected, setCategorySelected] = useState(null);

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

  useEffect(() => {
    if (_features) {
      const actualFeatures = product.features.map((i) => i.id);
      const finalFeatures = _features.map((f) => ({
        id: f.id,
        title: f.name,
        icon: f.icon,
        isChecked: actualFeatures.includes(f.id),
      }));
      setFeatures(finalFeatures);
    }
  }, [_features]);

  return {
    product,
    categories,
    setCategorySelected,
    isLoading:
      isLoadingLocations ||
      isLoadingCategories ||
      isLoadingFeatures ||
      isLoadingProduct,
    locations,
    setCoords,
    setLocationSelected,
    features,
    handleOnCheckboxChange,
    images,
    setImages,
    createProductError,
    coords,
  };
};
export default useEditProduct;
