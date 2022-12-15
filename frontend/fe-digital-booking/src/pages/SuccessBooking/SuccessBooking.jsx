import { Link, useNavigate } from 'react-router-dom';
import { Button, Heading, InfoBanner } from '../../atoms';
import cn from 'classnames';
import styles from './Success.module.scss';

const SuccessBooking = () => {
  const navigate = useNavigate();

  const handleOnClick = () => {
    navigate('/');
  };
  return (
    <div className={styles.container}>
      <div className={styles.infobanner}>
        <InfoBanner>
          <div className={styles.banner}>
            <i
              className={cn(
                'fa-regular fa-circle-check color-primary',
                styles.icon
              )}
            ></i>
            <Heading variant="h2" classname="color-primary">
              ¡Muchas gracias!
            </Heading>
            <Heading variant="h3" classname="color-secondary">
              Su reserva se ha realizado con éxito
            </Heading>
            <div className={styles['button-container']}>
              <div>
                <Link to="/">
                  <Button
                    variant="b1"
                    classname={styles.button}
                    onClick={handleOnClick}
                  >
                    ok
                  </Button>
                </Link>
              </div>
            </div>
          </div>
        </InfoBanner>
      </div>
    </div>
  );
};

export default SuccessBooking;
