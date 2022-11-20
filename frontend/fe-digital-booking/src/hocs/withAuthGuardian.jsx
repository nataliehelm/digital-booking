import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import useAuthContext from '../providers/AuthProvider/useAuthContext';

const withAuthGuardian = (Component) => {
  return (props) => {
    const { state } = useAuthContext();
    const { jwt } = state;
    const navigate = useNavigate();

    useEffect(() => {
      if (!jwt) {
        navigate('/login');
      }
    }, [jwt, navigate]);

    return <Component {...props} />;
  };
};

export default withAuthGuardian;
