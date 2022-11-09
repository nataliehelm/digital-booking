export const digitalBookingAPI = (endpoint, options) => {
  return fetch(`${process.env.REACT_APP_API_URL}/${endpoint}`, options);
};
