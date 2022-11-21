import { Routes, Route } from 'react-router-dom';
import Footer from './components/Footer';
import { Header } from './components/Header';
import { LogIn, SignUp, UserActivation } from './pages/Auth';
import Layout from './components/Layout';
import Home from './pages/Home';
import styles from './App.module.scss';
import Product from './pages/Product/ProductContainer';
import ActivateUserInfo from './pages/Auth/ActivateUserInfo/ActivateUserInfo';
import Booking from './pages/Booking/BookingContainer';
import useAuthContext from './providers/AuthProvider/useAuthContext';
import ResendEmail from './pages/Auth/ResendEmail';

function App() {
  const { state, cleanJwt } = useAuthContext();

  const handleOnLogout = () => {
    localStorage.removeItem('jwt');
    cleanJwt();
  };

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
              element={<Layout children={<Booking />} />} 
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
          </Routes>
        </div>
        <Footer />
      </div>
    </>
  );
}

export default App;
