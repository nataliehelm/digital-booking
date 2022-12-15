import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import useAuthContext from '../providers/AuthProvider/useAuthContext';

const withAdminAuthGuardian = (Component) => {
  return (props) => {
    const { state } = useAuthContext();
    const { jwt, decodedJwt } = state;
    const navigate = useNavigate();

    useEffect(() => {
      if (
        !jwt ||
        !decodedJwt?.isActive ||
        !decodedJwt?.role ||
        decodedJwt?.role[0].authority !== 'ROLE_ADMIN'
      ) {
        navigate('/');
      }
    }, [decodedJwt, jwt, navigate]);

    if (jwt) return <Component {...props} />;

    return (
      <div>
        <figure>
          <img src="assets/loading-gif.gif" alt="Loading..."></img>
        </figure>
      </div>
    );
  };
};

export default withAdminAuthGuardian;
