import Footer from './components/Footer';
import Layout from './components/Layout';
import useAuthContext from './providers/AuthProvider/useAuthContext';
import withAuthGuardian from './hocs/withAuthGuardian';
import styles from './App.module.scss';
import { Header } from './components/Header';
import { useState } from 'react';
import { useTheme } from './hooks';
import { Routes, Route } from 'react-router-dom';
import { THEME, THEMES, THEME_A } from './utils/constants';
import {
  Booking,
  Home,
  Product,
  ResendEmail,
  ActivateUserInfo,
  SuccessBooking,
  LogIn,
  SignUp,
  UserActivation,
  NotFound,
} from './pages';

function App() {
  const [theme, setTheme] = useState(localStorage.getItem(THEME) || THEME_A);
  useTheme(THEMES[theme]);
  const { state, cleanJwt } = useAuthContext();

  const handleOnLogout = () => {
    localStorage.removeItem('jwt');
    cleanJwt();
  };

  const handleTheme = (theme) => {
    setTheme(theme);
    localStorage.setItem(THEME, theme);
  };

  const BookingContainer = withAuthGuardian(() => <Booking />);

  return (
    <>
      <div className="App">
        <Header
          name={state.decodedJwt?.name || ''}
          lastname={state.decodedJwt?.lastname || ''}
          onLogout={handleOnLogout}
        />
        <div>
          <Routes>
            <Route path="/" element={<Layout children={<Home />} />} />
            <Route
              path="/signup"
              element={
                <Layout
                  className={styles['auth-background']}
                  children={<SignUp />}
                />
              }
            />
            <Route
              path="/login"
              element={
                <Layout
                  className={styles['auth-background']}
                  children={<LogIn />}
                />
              }
            />
            <Route
              path="/product/:id"
              element={<Layout children={<Product />} />}
            />
            <Route path="/user/:id/activate" element={<UserActivation />} />
            <Route
              path="/signup/:id/activate"
              element={
                <Layout
                  className={styles['auth-background']}
                  children={<ActivateUserInfo />}
                />
              }
            />
            <Route
              path="/product/:id/booking"
              element={<Layout children={<BookingContainer />} />}
            />
            <Route
              path="/success-booking"
              element={<Layout children={<SuccessBooking />} />}
            />
            <Route
              path="/resend-email"
              element={
                <Layout
                  className={styles['auth-background']}
                  children={<ResendEmail />}
                />
              }
            />
            <Route path="*" element={<Layout children={<NotFound />} />} />
          </Routes>
        </div>
        <Footer handleTheme={handleTheme} />
      </div>
    </>
  );
}

export default App;
