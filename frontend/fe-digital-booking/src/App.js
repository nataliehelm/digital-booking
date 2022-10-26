import { Routes, Route } from "react-router-dom";
import Footer from "./components/Footer";
import { Header } from "./components/Header";
import { LogIn, SignIn } from "./pages/Auth";
import Layout from "./components/Layout";
import Home from "./pages/Home";
import styles from "./App.module.scss";

function App() {
  return (
    <>
      <div className="App">
        <Header />
        <div>
          <Routes>
            <Route path="/" element={<Layout children={<Home />} />} />
            <Route
              path="/signin"
              element={
                <Layout
                  className={styles["auth-background"]}
                  children={<SignIn />}
                />
              }
            />
            <Route
              path="/login"
              element={
                <Layout
                  className={styles["auth-background"]}
                  children={<LogIn />}
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
