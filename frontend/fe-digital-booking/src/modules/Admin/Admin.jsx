import { useNavigate } from 'react-router-dom';
import { Subheader } from '../../atoms';
import styles from './Admin.module.scss';

const Admin = () => {
  const navigate = useNavigate();
  const onBackClick = () => {
    navigate(-1);
  };
  return (
    <>
      <Subheader
        title={' '}
        subtitle={'Administración'}
        onBackClick={onBackClick}
      />
      <div className={styles.container}>
        <div></div>
      </div>
    </>
  );
};

export default Admin;
