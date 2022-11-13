import { useMemo, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { mandatoryValidator } from '../../../utils/validators';
import { Button, Heading, Text, Input, useInput } from '../../../atoms';
import styles from './LogIn.module.scss';
import useFetchLazy from '../../../hooks/useFetch/useFetchLazy';

const LogIn = () => {
  const navigate = useNavigate();
  const email = useInput('', mandatoryValidator);
  const password = useInput('', mandatoryValidator);
  const { isLoading, data = {}, error = {}, callback } = useFetchLazy();
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
    callback('auth/login', options);
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
      navigate(0);
    }
    if (error) {
      console.error(error.full_error);
    }
  }, [data, error, navigate]);

  return (
    <main className={styles.main}>
      <form className={styles['login-in-form']} onSubmit={handleOnSubmit}>
        <Heading variant="h1" classname={styles.title}>
          Iniciar sesión
        </Heading>
        <section className={styles['form-container']}>
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
          {error && (
            <Text variant="t2" classname={styles['error']}>
              {error.error}
            </Text>
          )}
          <Button
            variant="b1"
            type="submit"
            classname={styles['submit-button']}
            disabled={disabled}
          >
            Ingresar
          </Button>
          <Text variant="t2" classname={styles['signin-text']}>
            <>
              ¿Aún no tenes cuenta?{' '}
              <Link to="/signin">
                <span> Registrate</span>
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
