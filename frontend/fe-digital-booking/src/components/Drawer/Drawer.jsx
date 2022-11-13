import { useLocation, useNavigate } from 'react-router-dom';
import { Avatar, Botton, Heading, Text } from '../../atoms';
import SocialNetwork from '../SocialNetwork';
import PropTypes from 'prop-types';
import styles from './Drawer.module.scss';

const Drawer = ({ setShowDrawer, username }) => {
  const userData = JSON.parse(localStorage.getItem('userInfo'));
  const navigate = useNavigate();

  const { pathname } = useLocation();

  const handleLogout = () => {
    const loggedUser = { ...userData, isLogged: false };
    localStorage.setItem('userInfo', JSON.stringify(loggedUser));
    setShowDrawer(false);
    navigate(0);
  };

  return (
    <section className={styles['drawer-container']}>
      <header>
        <button onClick={() => setShowDrawer(false)}>
          <i className="fa-solid fa-x fa-xl"></i>
        </button>
        {username && (
          <aside className={styles['user-info']}>
            <Avatar username={username} />
            <Botton variant="b2">
              <>
                <span>Hola,</span>
                <span className={styles['user-name']}>{username}</span>
              </>
            </Botton>
          </aside>
        )}
        {!username && (
          <Heading variant="h2" classname={styles.title}>
            MENÚ
          </Heading>
        )}
      </header>
      <nav className={styles.navbar}>
        {!username && (
          <ul>
            {!pathname.includes('signup') && (
              <li
                className={styles['navbar-item']}
                onClick={() => {
                  setShowDrawer(false);
                  navigate('/signup');
                }}
              >
                <Heading variant="h3">Crear cuenta</Heading>
              </li>
            )}
            {!pathname.includes('signup') && !pathname.includes('login') && (
              <div className={styles.divider} />
            )}
            {!pathname.includes('login') && (
              <li
                className={styles['navbar-item']}
                onClick={() => {
                  setShowDrawer(false);
                  navigate('/login');
                }}
              >
                <Heading variant="h3">Iniciar sesión</Heading>
              </li>
            )}
          </ul>
        )}
      </nav>
      {username && (
        <div className={styles['logout-container']}>
          <button onClick={handleLogout}>
            <Text variant="t2" classname={styles['p-logout']}>
              <>
                ¿Deseas{' '}
                <span className={styles['span-logout']}>cerrar sesión?</span>
              </>
            </Text>
          </button>
          <div className={styles['divider-logout']} />
        </div>
      )}
      <div className={styles['social-network-container']}>
        <SocialNetwork />
      </div>
    </section>
  );
};

Drawer.propTypes = {
  setShowDrawer: PropTypes.func.isRequired,
  username: PropTypes.string,
};

Drawer.defaultProps = {
  username: '',
};

export default Drawer;
