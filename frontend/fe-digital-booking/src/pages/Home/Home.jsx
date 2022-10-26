import React from 'react';
import { Button } from '../../atoms';
import Searcher from './components/Searcher';
import styles from './Home.module.scss';

const Home = () => {
  const handleOnClick = () => {
    console.log('test');
    fetch('http://localhost:8081/categories/')
      .then((response) => response.json())
      .then((data) => console.log(data));
  };
  return (
    <div className={styles['home-container']}>
      <Searcher />
      <Button onClick={handleOnClick} variant="b1">
        FETCH
      </Button>
      {/* <h1>Este es el home</h1>
      <p>Aqui debe ir el bloque de categoria y de resultados</p> */}
    </div>
  );
};

export default Home;
