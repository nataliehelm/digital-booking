import React from 'react';
import { Button } from '../../atoms';
import styles from './AuthButtons.module.scss';
import { Link, useLocation } from 'react-router-dom';

const AuthButtons = () => {
  const { pathname } = useLocation();
  return (
    <section className={styles.container}>
      {pathname.includes('login') ? (
        <>
          <div></div>
          <Link to="/signin">
            <Button variant="b2" onClick={console.log}>
              Crear cuenta
            </Button>
          </Link>
        </>
      ) : (
        <div></div>
      )}
      {pathname.includes('signin') && (
        <>
          <Link to="/login">
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
