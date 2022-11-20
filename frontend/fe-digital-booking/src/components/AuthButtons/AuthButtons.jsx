import { Button } from '../../atoms';
import { Link, useLocation } from 'react-router-dom';
import styles from './AuthButtons.module.scss';

const AuthButtons = () => {
  const { pathname } = useLocation();
  return (
    <section className={styles.container}>
      {!pathname.includes('signup') && (
        <>
          <Link to="/signup" className={styles.button}>
            <Button variant="b2" onClick={console.log}>
              Crear cuenta
            </Button>
          </Link>
        </>
      )}
      {!pathname.includes('login') && (
        <>
          <Link to="/login" className={styles.button}>
            <Button variant="b2" onClick={console.log}>
              Iniciar sesión
            </Button>
          </Link>
        </>
      )}
    </section>
  );
};

export default AuthButtons;
