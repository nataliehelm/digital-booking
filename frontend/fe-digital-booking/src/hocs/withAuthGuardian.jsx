import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import useAuthContext from '../providers/AuthProvider/useAuthContext';

const withAuthGuardian = (Component) => {
  return (props) => {
    const { state } = useAuthContext();
    const { jwt, decodedJwt } = state;
    const navigate = useNavigate();

    useEffect(() => {
      if (!jwt || !decodedJwt?.isActive) {
        navigate('/login');
      }
    }, [decodedJwt, jwt, navigate]);

    return <Component {...props} />;
  };
};

export default withAuthGuardian;
