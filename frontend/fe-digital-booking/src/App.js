import Footer from "./components/Footer/Footer";
import { Header } from "./components/Header";
import { SignIn } from "./pages/Auth";
import Layout from "./components/Layout";


function App() {
  return (
    <div className="App">
      <Header />
      <Layout>
        <SignIn />
      </Layout>
      <Footer/>
    </div>
  );
}

export default App;
