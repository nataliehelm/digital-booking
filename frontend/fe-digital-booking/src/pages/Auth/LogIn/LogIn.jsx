import { Button, Heading, Text } from '../../../atoms';
import useInput from '../../../atoms/Input/hooks/useInput';
import Input from '../../../atoms/Input/Input';
import styles from './LogIn.module.scss';
import { Link, useNavigate } from 'react-router-dom';
import { mandatoryValidator } from '../../../utils/validators';
import { useMemo, useState, useEffect } from 'react';

const LogIn = () => {
  const userData = JSON.parse(localStorage.getItem('userInfo'));
  const navigate = useNavigate();

  useEffect(() => {
    if (userData && userData.isLogged) navigate('/');
  }, [navigate, userData]);

  const email = useInput('', mandatoryValidator);
  const password = useInput('', mandatoryValidator);
  const [isLoading, setIsLoading] = useState(false);
  const [errors, setErrors] = useState({ error: null });

  const disabled = useMemo(() => {
    return [email, password].some((item) => item.value === '' || item.hasError);
  }, [email, password]);

  const handleOnSubmit = (e) => {
    e.preventDefault();
    if (!userData) {
      setErrors({
        error: 'Por favor vuelva a intentarlo, sus credenciales son inválidas',
      });
      return;
    }
    setIsLoading(true);
    const savedEmail = userData.email;
    const savedPassword = userData.password;

    setErrors({ error: null });

    setTimeout(() => {
      if (savedEmail !== email.value || savedPassword !== password.value) {
        setErrors({
          error:
            'Por favor vuelva a intentarlo, sus credenciales son inválidas',
        });
      } else {
        const loggedUser = { ...userData, isLogged: true };
        localStorage.setItem('userInfo', JSON.stringify(loggedUser));
        navigate(0);
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
          <Input
            name="password"
            value={password.value}
            onChange={password.onChange}
            label="Contraseña"
            type="password"
          />
          {errors.error && (
            <Text variant="t2" classname={styles['error']}>
              {errors.error}
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
