import { Button, Heading, Text } from '../../../atoms';
import useInput from '../../../atoms/Input/hooks/useInput';
import Input from '../../../atoms/Input/Input';
import styles from './LogIn.module.scss';
import { Link, useNavigate } from 'react-router-dom';
import { mandatoryValidator } from '../../../utils/validators';
import { useMemo, useState } from 'react';

const LogIn = () => {
  const email = useInput('', mandatoryValidator);
  const password = useInput('', mandatoryValidator);
  const [isLoading, setIsLoading] = useState(false);
  const [errors, setErrors] = useState({ email: null, password: null });
  const navigate = useNavigate();

  const disabled = useMemo(() => {
    return [email, password].some((item) => item.value === '' || item.hasError);
  }, [email, password]);

  const handleOnSubmit = (e) => {
    e.preventDefault();
    const userData = JSON.parse(localStorage.getItem('userInfo'));
    if (!userData) {
      setErrors({ email: 'No existen usuarios registrados' });
      return;
    }
    setIsLoading(true);
    const savedEmail = userData.email;
    const savedPassword = userData.password;

    setErrors({ email: null, password: null });

    setTimeout(() => {
      if (savedEmail !== email.value) {
        setErrors({ email: 'Email erroneo' });
      } else if (savedPassword !== password.value) {
        setErrors({ password: 'Password erroneo' });
      } else {
        const loggedUser = { ...userData, isLogged: true };
        localStorage.setItem('userInfo', JSON.stringify(loggedUser));
        navigate('/');
      }
      setIsLoading(false);
    }, 1000);
  };

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
          {errors.email && (
            <Text variant="t2" classname={styles['error']}>
              {errors.email}
            </Text>
          )}
          <Input
            name="password"
            value={password.value}
            onChange={password.onChange}
            label="Contraseña"
            type="password"
          />
          {errors.password && (
            <Text variant="t2" classname={styles['error']}>
              {errors.password}
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
