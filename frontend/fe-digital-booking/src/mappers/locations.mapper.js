const parsedLocations = (data) => {
  return data.map((l) => ({
    id: l.id,
    icon: <i className="fa-solid fa-location-dot"></i>,
    title: l.city_name + ', ' + l.province_name,
    description: l.country_name,
  }));
};

export const parsedLocationsWithoutCity = (data) => {
  return data.map((l) => ({
    id: l.id,
    icon: <i className="fa-solid fa-location-dot"></i>,
    title: l.province_name,
    description: l.country_name,
  }));
};

export default parsedLocations;
