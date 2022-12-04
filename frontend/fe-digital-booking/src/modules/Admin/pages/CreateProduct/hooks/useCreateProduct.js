import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useInput } from '../../../../../atoms';
import { useFetch } from '../../../../../hooks';
import useFetchLazy from '../../../../../hooks/useFetch/useFetchLazy';
import { parsedLocationsWithoutCity } from '../../../../../mappers/locations.mapper';
import useAuthContext from '../../../../../providers/AuthProvider/useAuthContext';
import { mandatoryValidator } from '../../../../../utils/validators';

const useCreateProduct = () => {
  const [locations, setLocations] = useState([]);
  const [locationSelected, setLocationSelected] = useState(null);
  const { isLoading: isLoadingLocations, data: _locations } =
    useFetch('locations');
  const { isLoading: isLoadingCategories, data: _categories } =
    useFetch('categories');
  const [categories, setCategories] = useState([]);
  const [categorySelected, setCategorySelected] = useState(null);
  const name = useInput('', mandatoryValidator);
  const slogan = useInput('', mandatoryValidator);
  const address = useInput('', mandatoryValidator);
  const distance = useInput('', mandatoryValidator);
  const description = useInput('', mandatoryValidator);
  const policy1 = useInput('', mandatoryValidator);
  //const images = useInput('', mandatoryValidator);
  const { state } = useAuthContext();
  const { data, error, callback } = useFetchLazy();
  const [coords, setCoords] = useState();
  const lat = useInput('', mandatoryValidator);
  const lng = useInput('', mandatoryValidator);
  const navigate = useNavigate();

  const [features, setFeatures] = useState([]);

  const [images, setImages] = useState([
    {
      id: 0,
      value: '',
    },
  ]);

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

  const onClick = () => {
    const finalCoords = [coords.lat, coords.lng];
    const selectedFeatures = [];
    features.map((f) => {
      if (f.isChecked) {
        selectedFeatures.push(f.id);
      }
    });
    const option = {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + state.jwt,
      },
      body: JSON.stringify({
        name: name.value,
        address: address.value,
        distance_to_nearest_tourist_site: distance.value,
        description_title: slogan.value,
        description: description.value,
        coordinates: finalCoords,
        categoryId: categorySelected.id,
        locationId: locationSelected.id,
        featureIds: selectedFeatures,
        policiyIds: [1, 2, 3],
        //userId: state.decodedJwt.userId,
      }),
    };
    callback('products', option);
  };
  useEffect(() => {
    if (data) {
      navigate('/success-booking');
    }
    if (error) {
      console.error(error);
    }
  }, [data, error, navigate]);

  useEffect(() => {
    if (!isLoadingLocations) {
      const finalLocations = parsedLocationsWithoutCity(_locations);
      setLocations(finalLocations);
      //setLocationSelected(location);
    }
  }, [_locations, isLoadingLocations]);

  useEffect(() => {
    if (!isLoadingCategories) {
      const finalCategories = _categories.map((c) => ({
        id: c.id,
        title: c.name,
      }));
      setCategories(finalCategories);
      //setLocationSelected(location);
    }
  }, [_categories, isLoadingCategories]);

  useEffect(() => {
    if (!isLoadingFeatures) {
      const finalFeatures = _features.map((f) => ({
        id: f.id,
        title: f.name,
        icon: f.icon,
        isChecked: false,
      }));
      setFeatures(finalFeatures);
      //setLocationSelected(location);
    }
  }, [_features, isLoadingFeatures]);

  useEffect(() => {
    if (coords) {
      lat.onChange({ target: { value: coords.lat } });
      lng.onChange({ target: { value: coords.lng } });
    }
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [coords]);

  console.log(name);

  return {
    name,
    slogan,
    categories,
    setCategorySelected,
    address,
    distance,
    isLoading: isLoadingLocations || isLoadingCategories || isLoadingFeatures,
    lat,
    lng,
    locations,
    setLocationSelected,
    locationSelected,
    setCoords,
    description,
    features,
    handleOnCheckboxChange,
    policy1,
    images,
    setImages,
    onClick,
  };
};

export default useCreateProduct;
