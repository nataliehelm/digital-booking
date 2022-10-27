export const digitalBookingAPI = (endpoint) => {
  return fetch(`http://localhost:8081/${endpoint}`);
};
