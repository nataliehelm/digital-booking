import { Link, useLocation } from 'react-router-dom';
import { Button, Heading, Toast } from '../../../atoms';
import { InfoBanner } from '../../../atoms/InfoBanner';
import styles from './ActivateUserInfo.module.scss';
import cn from 'classnames';
import useFetchLazy from '../../../hooks/useFetch/useFetchLazy';
import { useState } from 'react';

const ActivateUserInfo = () => {
  const location = useLocation();
  const { error, data, callback: signUpFunction } = useFetchLazy();

  const [disabled, setDisabled] = useState(false);

  const handleOnSubmit = () => {
    const options = {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ email: location.state.email }),
    };

    signUpFunction('auth/resend', options);
    setDisabled(true);
  };

  return (
    <main className={styles.main}>
      {error && (
        <div className={styles['sign-up-form']}>
          <Toast
            variant="error"
            label={error.error || 'Por favor intente más tarde'}
          />
        </div>
      )}
      {data && (
        <div className={styles['sign-up-form']}>
          <Toast variant="success" label="Correo envíado satisfactoriamente" />
        </div>
      )}
      <form className={styles['sign-up-form']}>
        <InfoBanner>
          <>
            <i
              className={cn(
                'fa-regular fa-circle-check color-primary',
                styles.icon
              )}
            ></i>
            <Heading variant="h1" classname="color-primary">
              ¡Registro exitoso!
            </Heading>
            <Heading variant="h2" classname="color-secondary">
              En tu correo electrónico entrarás un link para activar tu cuenta
            </Heading>
            <div className={styles['buttons-container']}>
              <div>
                <Button
                  variant="b2"
                  onClick={handleOnSubmit}
                  disabled={disabled}
                >
                  Reenviar link
                </Button>
              </div>
              <div>
                <Link to="/login">
                  <Button variant="b1">Ir al login</Button>
                </Link>
              </div>
            </div>
          </>
        </InfoBanner>
      </form>
    </main>
  );
};

export default ActivateUserInfo;
