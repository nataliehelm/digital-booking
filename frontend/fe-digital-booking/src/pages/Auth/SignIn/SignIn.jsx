import { useEffect, useMemo, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { Button, Heading, Text, Input, useInput } from '../../../atoms';
import {
  emailValidator,
  mandatoryValidator,
  passwordValidator,
} from '../../../utils/validators';
import styles from './SignIn.module.scss';

const SignIn = () => {
  const userData = JSON.parse(localStorage.getItem('userInfo'));
  const navigate = useNavigate();

  useEffect(() => {
    if (userData && userData.isLogged) navigate('/');
  }, [navigate, userData]);

  const name = useInput('', mandatoryValidator);
  const lastname = useInput('', mandatoryValidator);
  const email = useInput('', emailValidator);
  const password = useInput('', passwordValidator);
  let passwordConfirmation = useInput('');
  const [isLoading, setIsLoading] = useState(false);

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

  const disabled = useMemo(() => {
    return [name, lastname, email, password, passwordConfirmation].some(
      (item) => item.value === '' || item.hasError
    );
  }, [name, lastname, email, password, passwordConfirmation]);

  const handleOnSubmit = (e) => {
    e.preventDefault();

    const newUser = {
      name: name.value,
      lastname: lastname.value,
      email: email.value,
      password: password.value,
      isLogged: false,
    };

    localStorage.setItem('userInfo', JSON.stringify(newUser));
    setIsLoading(true);
    setTimeout(() => {
      navigate('/login');
    }, 1000);
  };

  return (
    <main className={styles.main}>
      <Heading variant="h1" classname={styles.title}>
        Crear cuenta
      </Heading>
      <form className={styles['sign-in-form']} onSubmit={handleOnSubmit}>
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

export default SignIn;
