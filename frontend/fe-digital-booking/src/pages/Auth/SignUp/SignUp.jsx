import { useEffect, useMemo } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { Button, Heading, Text, Input, useInput } from '../../../atoms';
import { Toast } from '../../../atoms';
import useFetchLazy from '../../../hooks/useFetch/useFetchLazy';
import {
  emailValidator,
  mandatoryValidator,
  passwordValidator,
} from '../../../utils/validators';
import styles from './SignUp.module.scss';

const SignUp = () => {
  const jwt = JSON.parse(localStorage.getItem('jwt'));
  const navigate = useNavigate();
  const { isLoading, data, error, callback: signUpFunction } = useFetchLazy();

  const name = useInput('', mandatoryValidator);
  const lastname = useInput('', mandatoryValidator);
  const email = useInput('', emailValidator);
  const password = useInput('', passwordValidator);
  let passwordConfirmation = useInput('');

  passwordConfirmation = {
    ...passwordConfirmation,
    hasError:
      !!passwordConfirmation.value &&
      password.value !== passwordConfirmation.value,
    errorMessage:
      passwordConfirmation.value &&
      password.value !== passwordConfirmation.value
        ? 'Las contraseñas no coinciden'
        : '',
  };

  const handleOnSubmit = (e) => {
    e.preventDefault();

    const newUser = {
      name: name.value,
      lastname: lastname.value,
      email: email.value,
      password: password.value,
    };

    const options = {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(newUser),
    };

    signUpFunction('auth/signup', options);
  };

  useEffect(() => {
    if (jwt && jwt.isLogged) navigate('/');
  }, [navigate, jwt]);

  useEffect(() => {
    if (data) {
      navigate(`/signup/${data.id}/activate`, { state: { email: data.email } });
    }
    if (error) {
      console.error(error);
    }
  }, [data, error, navigate]);

  const disabled = useMemo(() => {
    return [name, lastname, email, password, passwordConfirmation].some(
      (item) => item.value === '' || item.hasError
    );
  }, [name, lastname, email, password, passwordConfirmation]);

  return (
    <main className={styles.main}>
      {error && (
        <div className={styles['sign-up-form']}>
          <Toast
            variant="error"
            label={
              error.error ||
              'Lamentablemente no ha podido registrarse. Por favor intente más tarde'
            }
          />
        </div>
      )}
      <Heading variant="h1" classname={styles.title}>
        Crear cuenta
      </Heading>
      <form className={styles['sign-up-form']} onSubmit={handleOnSubmit}>
        <section>
          <div className={styles.names}>
            <Input {...name} name="name" label="Nombre" />
            <Input {...lastname} name="lastname" label="Apellido" />
          </div>
          <Input
            {...email}
            name="email"
            label="Correo electrónico"
            type="email"
          />
          <Input
            {...password}
            name="password"
            label="Contraseña"
            type="password"
          />
          <Input
            {...passwordConfirmation}
            name="password-confirmation"
            label="Confirmar contraseña"
            type="password"
          />
        </section>
        <Button
          disabled={disabled}
          variant="b1"
          type="submit"
          classname={styles['submit-button']}
        >
          Crear cuenta
        </Button>
        <Text variant="t2" classname={styles['login-text']}>
          <>
            ¿Ya tienes una cuenta?{' '}
            <Link to="/login">
              <span>Iniciar sesión</span>
            </Link>
          </>
        </Text>
      </form>
      {isLoading && (
        <figure className={styles.spinner}>
          <img src="assets/loading-gif.gif" alt="Loading..."></img>
        </figure>
      )}
    </main>
  );
};

export default SignUp;
