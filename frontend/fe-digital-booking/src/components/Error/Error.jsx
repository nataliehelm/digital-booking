import { useNavigate } from 'react-router-dom';
import { Button, Heading } from '../../atoms';
import styles from './Error.module.scss';

const Error = () => {
  const navigate = useNavigate();

  return (
    <div className={styles.container}>
      <div className={styles['text-container']}>
        <Heading variant="h1">Servicio no disponible</Heading>
        <Heading variant="h3">
          Por favor vuelva a intentarlo en unos minutos
        </Heading>
        <div className={styles['button-container']}>
          <Button
            variant="b1"
            type={'button'}
            children={'Reintentar'}
            classname={styles.button}
            onClick={() => {
              navigate(0);
            }}
          ></Button>
          <Button
            variant="b2"
            type={'button'}
            children={'Volver a Inicio'}
            classname={styles.button}
            onClick={() => {
              window.location = '/';
            }}
          ></Button>
        </div>
      </div>
    </div>
  );
};

export default Error;
