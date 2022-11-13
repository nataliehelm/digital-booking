import { Routes, Route } from 'react-router-dom';
import Footer from './components/Footer';
import { Header } from './components/Header';
import { LogIn, SignUp, UserActivation } from './pages/Auth';
import Layout from './components/Layout';
import Home from './pages/Home';
import styles from './App.module.scss';
import Product from './pages/Product/ProductContainer';
import ActivateUserInfo from './pages/Auth/ActivateUserInfo/ActivateUserInfo';

function App() {
  return (
    <>
      <div className="App">
        <Header />
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
          </Routes>
        </div>
        <Footer />
      </div>
    </>
  );
}

export default App;
