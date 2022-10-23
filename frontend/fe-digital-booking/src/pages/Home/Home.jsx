import React from "react";
import Searcher from "./components/Searcher";
import styles from "./Home.module.scss";

const Home = () => {
  return (
    <div className={styles["home-container"]}>
      <Searcher />
      {/* <h1>Este es el home</h1>
      <p>Aqui debe ir el bloque de categoria y de resultados</p> */}
    </div>
  );
};

export default Home;
