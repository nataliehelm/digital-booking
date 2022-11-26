import useAuthContext from '../../../providers/AuthProvider/useAuthContext';
import parsedLocations from '../../../mappers/locations.mapper';
import { useEffect, useState } from 'react';
import { useFetch } from '../../../hooks';
import { addDays } from 'date-fns/esm';
import { isSameOrBefore } from '../../../utils/dates';
import { format, parseISO } from 'date-fns';

const useHome = () => {
  const { state } = useAuthContext();

  const [endpoint, setEndpoint] = useState('products');
  const [requestOptions, setRequestOptions] = useState(null);
  const [categoryIds, setCategoryIds] = useState([]);
  const [categoryNames, setCategoryNames] = useState([]);
  const [locations, setLocations] = useState([]);
  const [locationSelected, setLocationSelected] = useState(null);
  const [datesRange, setDatesRange] = useState([
    {
      startDate: addDays(new Date(), -1),
      endDate: addDays(new Date(), -1),
      key: 'selection',
    },
  ]);

  const { isLoading: isLoadingProducts, data: products } = useFetch(
    endpoint,
    requestOptions
  );

  const { isLoading: isLoadingCategories, data: categories } =
    useFetch('categories');

  const { isLoading: isLoadingLocations, data: _locations } =
    useFetch('locations');

  useEffect(() => {
    if (!isLoadingLocations) {
      const finalLocations = parsedLocations(_locations);
      setLocations(finalLocations);
    }
  }, [_locations, isLoadingLocations]);

  useEffect(() => {
    setRequestOptions(null);
    if (state && state.jwt) {
      setRequestOptions({
        headers: {
          Authorization: state.jwt,
        },
      });
    }
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [state]);

  useEffect(() => {
    if (categoryIds.length > 0) {
      setEndpoint(`products/filters?categoryId=${categoryIds.join(',')}`);
      setLocationSelected(null);
    }
    const hasDateFilter = isSameOrBefore(new Date(), datesRange[0].startDate);
    if (!categoryIds.length && !locationSelected && !hasDateFilter) {
      setEndpoint('products');
    }
  }, [categoryIds, datesRange, locationSelected]);

  const handleSelectIds = (id, name) => {
    if (categoryIds.includes(id)) {
      setCategoryIds(categoryIds.filter((c) => c !== id));
      setCategoryNames(categoryNames.filter((c) => c !== name));
    } else {
      setCategoryIds([...categoryIds, id]);
      setCategoryNames([...categoryNames, name]);
    }
    setDatesRange([
      {
        startDate: addDays(new Date(), -1),
        endDate: addDays(new Date(), -1),
        key: 'selection',
      },
    ]);
  };

  const handleOnSubmit = () => {
    setCategoryIds([]);
    setCategoryNames([]);
    const hasDateFilter = isSameOrBefore(new Date(), datesRange[0].startDate);
    let finalEndpoint = 'products';
    if (locationSelected || hasDateFilter) {
      finalEndpoint += '/filters/?';
      if (locationSelected) {
        finalEndpoint += `locationId=${locationSelected.id}&`;
      }
      if (hasDateFilter) {
        const { startDate, endDate } = datesRange[0];
        const startingDate = format(
          parseISO(startDate.toISOString()),
          'yyyy-MM-dd'
        );
        const endingDate = format(
          parseISO(endDate.toISOString()),
          'yyyy-MM-dd'
        );
        finalEndpoint += `startingDate=${startingDate}&endingDate=${endingDate}&`;
      }
    }
    setEndpoint(finalEndpoint);
  };

  return {
    authState: state,
    categories,
    categoryIds,
    categoryNames,
    datesRange,
    handleOnSubmit,
    handleSelectIds,
    isLoading: isLoadingLocations || isLoadingCategories,
    isLoadingProducts,
    locations,
    locationSelected,
    products,
    setDatesRange,
    setLocationSelected,
  };
};

export default useHome;
