import { createContext } from 'react';
import jwt_decode from 'jwt-decode';

const jwt = JSON.parse(localStorage.getItem('jwt'));
const decodedJwt = jwt ? jwt_decode(jwt) : undefined;

export const authContext = {
  state: {
    jwt,
    decodedJwt,
  },
  setState: (state) => {},
};

export const AuthContext = createContext(authContext);
