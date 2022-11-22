import { useMemo, useEffect, useState } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { mandatoryValidator } from '../../../utils/validators';
import { Button, Heading, Text, Input, useInput, Toast } from '../../../atoms';
import styles from './LogIn.module.scss';
import useFetchLazy from '../../../hooks/useFetch/useFetchLazy';
import useAuthContext from '../../../providers/AuthProvider/useAuthContext';

const LogIn = () => {
  const [errorMsg, setErrorMsg] = useState(null);
  const [showToast, setShowToast] = useState(false);
  const { setJwt } = useAuthContext();
  const { state } = useLocation();
  const navigate = useNavigate();
  const email = useInput('', mandatoryValidator);
  const password = useInput('', mandatoryValidator);
  const { isLoading, data, error, callback: loginFunction } = useFetchLazy();
  const jwt = JSON.parse(localStorage.getItem('jwt'));

  const handleOnSubmit = (e) => {
    e.preventDefault();

    const options = {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        email: email.value,
        password: password.value,
      }),
    };
    loginFunction('auth/login', options);
  };

  useEffect(() => {
    if (jwt) navigate('/');
  }, [navigate, jwt]);

  const disabled = useMemo(() => {
    return [email, password].some((item) => item.value === '' || item.hasError);
  }, [email, password]);

  useEffect(() => {
    if (data) {
      localStorage.setItem('jwt', JSON.stringify(data.token));
      setJwt(data.token);
      if (state?.path) {
        navigate(state.path);
      } else {
        navigate('/');
      }
    }
    if (error) {
      setErrorMsg(error.error);
      console.error(error.full_error);
    }
  }, [data, error, navigate, setJwt, state]);

  useEffect(() => {
    if (!error) {
      if (state?.type) setShowToast(true);
      if (state && state.type === 'error') setErrorMsg(state.message);
    }
  }, [error, state]);

  useEffect(() => {
    if (errorMsg) setShowToast(true);
  }, [errorMsg, error]);

  useEffect(() => {
    const timer = setTimeout(() => {
      setShowToast(false);
    }, 3500);

    return () => {
      clearTimeout(timer);
    };
  }, [errorMsg, error]);

  return (
    <main className={styles.main}>
      <form className={styles['login-in-form']} onSubmit={handleOnSubmit}>
        <Heading variant="h1" classname={styles.title}>
          Iniciar sesión
        </Heading>
        <section className={styles['form-container']}>
          {showToast && (
            <>
              {(error || (state && state.type === 'error')) && (
                <div className={styles['toast']}>
                  <Toast
                    onClick={() => setShowToast(false)}
                    variant="error"
                    label={
                      errorMsg ||
                      'Lamentablemente no ha podido iniciar sesión. Por favor intente más tarde'
                    }
                  />
                </div>
              )}
              {state && state.type === 'success' && (
                <div className={styles['toast']}>
                  <Toast
                    variant="success"
                    onClick={() => setShowToast(false)}
                    label={state.message}
                  />
                </div>
              )}
            </>
          )}
          <Heading variant="h1" classname={styles['title-tablet-desktop']}>
            Iniciar sesión
          </Heading>
          <Input
            name="email"
            value={email.value}
            onChange={email.onChange}
            label="Correo electrónico"
            type="email"
          />
          <Input
            name="password"
            value={password.value}
            onChange={password.onChange}
            label="Contraseña"
            type="password"
          />
          <Button
            variant="b1"
            type="submit"
            classname={styles['submit-button']}
            disabled={disabled}
          >
            Ingresar
          </Button>
          <Text variant="t2" classname={styles['signup-text']}>
            <>
              ¿Aún no tenes cuenta?{' '}
              <Link to="/signup">
                <span> Registrate</span>
              </Link>
            </>
          </Text>
          <Text variant="t2" classname={styles['signup-text']}>
            <>
              <Link to="/resend-email">
                <span> Reenvío de correo de activación de cuenta</span>
              </Link>
            </>
          </Text>
        </section>
      </form>
      {isLoading && (
        <figure className={styles.spinner}>
          <img src="assets/loading-gif.gif" alt="Loading..."></img>
        </figure>
      )}
    </main>
  );
};

export default LogIn;
