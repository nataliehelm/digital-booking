import Footer from './components/Footer';
import Layout from './components/Layout';
import useAuthContext from './providers/AuthProvider/useAuthContext';
import withAuthGuardian from './hocs/withAuthGuardian';
import styles from './App.module.scss';
import { Routes, Route } from 'react-router-dom';
import { Header } from './components/Header';
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
  const { state, cleanJwt } = useAuthContext();

  const handleOnLogout = () => {
    localStorage.removeItem('jwt');
    cleanJwt();
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
        <Footer />
      </div>
    </>
  );
}

export default App;
