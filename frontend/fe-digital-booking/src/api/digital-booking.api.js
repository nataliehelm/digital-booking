export const digitalBookingAPI = (endpoint) => {
  return fetch(`${process.env.REACT_APP_API_URL}/${endpoint}`);
};
