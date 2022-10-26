const parsedLocations = (data) => {
  return data.map((l) => ({
    id: l.id,
    icon: <i className="fa-solid fa-location-dot"></i>,
    title: l.name,
    description: l.country,
  }));
};

export default parsedLocations;
