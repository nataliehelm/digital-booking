import Footer from './components/Footer';
import Layout from './components/Layout';
import useAuthContext from './providers/AuthProvider/useAuthContext';
import withAuthGuardian from './hocs/withAuthGuardian';
import withAdminGuardian from './hocs/withAdminAuthGuardian';
import styles from './App.module.scss';
import { Admin } from './modules';
import { CreateProduct } from './modules/Admin/pages/CreateProduct';
import { Header } from './components/Header';
import { Routes, Route } from 'react-router-dom';
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
import SuccessCreateProduct from './modules/Admin/pages/SuccessCreateProduct';

function App() {
  const { state, cleanJwt } = useAuthContext();

  const handleOnLogout = () => {
    localStorage.removeItem('jwt');
    cleanJwt();
  };

  const BookingContainer = withAuthGuardian(() => <Booking />);

  // TODO: refactorizar implementación
  const AdminContainer = withAdminGuardian(() => <Admin />);
  const AdminCreateProduct = withAdminGuardian(() => <CreateProduct />);

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
              path="/admin"
              element={<Layout children={<AdminContainer />} />}
            />
            <Route
              path="/admin/product/create"
              element={<Layout children={<AdminCreateProduct />} />}
            />
            <Route
              path="/create-product-success"
              element={<Layout children={<SuccessCreateProduct />} />}
            />
            <Route
              path="/admin/product/:id/edit"
              element={<Layout children={<Admin />} />}
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
