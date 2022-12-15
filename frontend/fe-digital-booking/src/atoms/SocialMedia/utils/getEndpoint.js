export const getEndpoint = (socialType, url) => {
  const endpointUrl = process.env.REACT_APP_APP_URL + url;
  const endpoint = {
    facebook: `https://www.facebook.com/dialog/send?link=${endpointUrl}`,
    twitter: `https://twitter.com/intent/tweet?url=${endpointUrl}`,
    whatsapp: `https://web.whatsapp.com/send?text=${endpointUrl}`,
    mail: `mailto:?subject=${endpointUrl}`,
  }[socialType];

  return endpoint;
};
