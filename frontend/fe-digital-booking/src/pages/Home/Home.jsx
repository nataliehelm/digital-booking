import React from "react";
import CategoryList from "../../components/CategoryList";
import styles from "./Home.module.scss";

const Home = () => {
  return (
    <div className={styles["home-container"]}>
      <CategoryList />
    </div>
  );
};

export default Home;
