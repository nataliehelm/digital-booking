import { useContext } from 'react';
import { AuthContext } from './AuthContext';
import jwt_decode from 'jwt-decode';

const useAuthContext = () => {
  const { state, setState } = useContext(AuthContext);

  const setJwt = (jwt) => {
    setState({ jwt, decodedJwt: decodeJwt(jwt) });
  };

  const decodeJwt = (jwt) => jwt_decode(jwt);

  const cleanJwt = () => {
    setState({ jwt: undefined, decodedJwt: undefined });
  };

  return { state, setState, decodeJwt, setJwt, cleanJwt };
};

export default useAuthContext;
