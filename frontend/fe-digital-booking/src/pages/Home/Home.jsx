import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import CategoryList from '../../components/CategoryList';
import Searcher from './components/Searcher';
import styles from './Home.module.scss';

const Home = () => {
  const userData = JSON.parse(localStorage.getItem('userInfo'));
  const navigate = useNavigate();

  useEffect(() => {
    if (userData) {
      if (!userData.isLogged) navigate('/login');
    } else {
      navigate('/login');
    }
  }, [navigate, userData]);

  return (
    <div className={styles['home-container']}>
      <Searcher />
      <CategoryList />
    </div>
  );
};

export default Home;
