import { useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { useFetch } from '../../../hooks';

const UserActivation = () => {
  const { id } = useParams();
  const { data } = useFetch(`auth/activate/${id}`);
  const navigate = useNavigate();

  useEffect(() => {
    if (data && data.active) {
      navigate('/login', {
        state: {
          message: 'Cuenta activada satisfactoriamente',
          type: 'success',
        },
      });
    }
  }, [data, id, navigate]);

  return <></>;
};

export default UserActivation;
