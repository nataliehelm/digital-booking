import Admin from './Admin';
import useAdmin from './pages/hooks/useAdmin';

const AdminContainer = () => {
  const props = useAdmin();
  return <Admin {...props} />;
};

export default AdminContainer;
