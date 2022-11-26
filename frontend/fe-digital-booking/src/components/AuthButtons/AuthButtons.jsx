import { Button } from '../../atoms';
import { Link, useLocation } from 'react-router-dom';
import styles from './AuthButtons.module.scss';

const AuthButtons = () => {
  const { pathname } = useLocation();
  return (
    <section className={styles.container}>
      {!pathname.includes('signup') && (
        <div className={styles.subcontainer}>
          <Link to="/signup" className={styles.button}>
            <Button variant="b2">Crear cuenta</Button>
          </Link>
        </div>
      )}
      {!pathname.includes('login') && (
        <div className={styles.subcontainer}>
          <Link to="/login" className={styles.button}>
            <Button variant="b2">Iniciar sesión</Button>
          </Link>
        </div>
      )}
    </section>
  );
};

export default AuthButtons;
