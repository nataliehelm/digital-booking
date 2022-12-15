import { useEffect, useState } from 'react';
import { authContext, AuthContext } from './AuthContext';

import { useNavigate } from 'react-router-dom';

export const AuthProvider = ({ children }) => {
  const [state, setState] = useState(authContext.state);
  const navigate = useNavigate();

  useEffect(() => {
    if (state.decodedJwt) {
      if (state.decodedJwt.exp * 1000 < new Date().getTime()) {
        localStorage.removeItem('jwt');
        setState({ jwt: undefined, decodedJwt: undefined });
        navigate('/login', {
          state: {
            message: 'Tu sesión se venció, inicia sesión de nuevo.',
            type: 'error',
          },
        });
      }
    }
  }, [navigate, state.decodedJwt]);

  return (
    <AuthContext.Provider value={{ state, setState }}>
      {children}
    </AuthContext.Provider>
  );
};
