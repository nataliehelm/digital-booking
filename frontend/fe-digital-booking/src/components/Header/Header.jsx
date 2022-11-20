import { useState } from 'react';
import { Link } from 'react-router-dom';
import { Avatar, Botton } from '../../atoms';
import { Drawer } from '../Drawer';
import AuthButtons from '../AuthButtons';
import styles from './Header.module.scss';
import PropTypes from 'prop-types';

const Header = ({ name, lastname, onLogout }) => {
  const [showDrawer, setShowDrawer] = useState(false);
  const username = name ? `${name} ${lastname}` : undefined;

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
            <Drawer
              username={username}
              setShowDrawer={setShowDrawer}
              onLogout={onLogout}
            />
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
                <div className={styles['close-icon']} onClick={onLogout}>
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

Header.propTypes = {
  name: PropTypes.string,
  lastname: PropTypes.string,
  onLogout: PropTypes.func,
};

export default Header;
