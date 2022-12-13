export const getFileFromUrl = async (url, name) => {
  const response = await fetch(url, {
    method: 'GET',
  });
  const blob = await response.blob();
  const file = new File([blob], name, { type: blob.type });
  return file;
};
