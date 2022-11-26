import { Link } from 'react-router-dom';
import { Button, Heading, Input, Text, Toast, useInput } from '../../../atoms';
import { InfoBanner } from '../../../atoms/InfoBanner';
import styles from './ResendEmail.module.scss';
import useFetchLazy from '../../../hooks/useFetch/useFetchLazy';
import { useEffect, useState } from 'react';

const ResendEmail = () => {
  const { error, data, callback: signUpFunction } = useFetchLazy();
  const [disabled, setDisabled] = useState(false);
  const email = useInput('');

  const handleOnSubmit = (e) => {
    e.preventDefault();
    const options = {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ email: email.value }),
    };

    signUpFunction('auth/resend', options);
    setDisabled(true);
  };

  useEffect(() => {
    setDisabled(false);
  }, [error]);

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
      <form className={styles['sign-up-form']} onSubmit={handleOnSubmit}>
        <InfoBanner>
          <>
            <Heading variant="h2" classname="color-secondary">
              Por favor escriba su correo electrónico para hacer el reenvío
            </Heading>
            <Input
              name="email"
              value={email.value}
              onChange={email.onChange}
              label="Correo electrónico"
              type="email"
            />
            <div className={styles['buttons-container']}>
              <div>
                <Button
                  variant="b2"
                  onClick={handleOnSubmit}
                  disabled={disabled}
                  type="submit"
                >
                  Reenviar link
                </Button>
              </div>
            </div>
            <Text variant="t2" classname={styles['signup-text']}>
              <>
                <Link to="/login">
                  <span> Volver al login</span>
                </Link>
              </>
            </Text>
          </>
        </InfoBanner>
      </form>
    </main>
  );
};

export default ResendEmail;
