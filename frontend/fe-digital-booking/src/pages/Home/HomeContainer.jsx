import useHome from './hooks';
import Home from './Home';

const HomeContainer = () => {
  const props = useHome();
  return <Home {...props} />;
};

export default HomeContainer;
