import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { Avatar, Botton } from '../../atoms';
import { Drawer } from '../Drawer';
import AuthButtons from '../AuthButtons';
import styles from './Header.module.scss';

const Header = () => {
  const userData = JSON.parse(localStorage.getItem('userInfo'));
  const [showDrawer, setShowDrawer] = useState(false);
  const navigate = useNavigate();
  const username = userData?.isLogged
    ? `${userData.name} ${userData.lastname}`
    : undefined;

  const handleLogout = () => {
    const loggedUser = { ...userData, isLogged: false };
    localStorage.setItem('userInfo', JSON.stringify(loggedUser));
    setShowDrawer(false);
    navigate(0);
  };

  return (
    <>
      {showDrawer && (
        <>
          <main className={styles['header-container']} id="header">
            <figure style={{ marginTop: '4px' }}>
              <img src="/assets/logo.svg" alt="DB Logo" />
            </figure>
          </main>
          <div className={styles['drawer-container']}>
            <div className={styles['bg-opacity']} />
            <Drawer username={username} setShowDrawer={setShowDrawer} />
          </div>
        </>
      )}
      {!showDrawer && (
        <main className={styles['header-container']} id="header">
          <Link to="/">
            <figure>
              <img src="/assets/logo.svg" alt="DB Logo" />
              <span className={styles['slogan']}>Sentite como en tu hogar</span>
            </figure>
          </Link>
          <button
            className={styles['menu-icon']}
            onClick={() => setShowDrawer(true)}
          >
            <span className="material-icons">
              <i className="fa-solid fa-bars"></i>
            </span>
          </button>

          {username ? (
            <div className={styles['user-info-container']}>
              <aside className={styles['user-info']}>
                <div className={styles['close-icon']} onClick={handleLogout}>
                  <i className="fa-solid fa-x"></i>
                </div>
                <Avatar username={username} classname={styles.avatar} />
                <Botton variant="b2" classname={styles.label}>
                  <>
                    <span>Hola,</span>
                    <span className={styles['user-name']}>{username}</span>
                  </>
                </Botton>
              </aside>
            </div>
          ) : (
            <AuthButtons />
          )}
        </main>
      )}
    </>
  );
};

export default Header;
