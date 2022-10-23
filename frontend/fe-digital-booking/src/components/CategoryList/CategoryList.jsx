import React from "react";
import styles from "./CategoryList.module.scss";
import { Heading } from "../../atoms";
import useFetch from "../../hook/useFetch";

const CategoryList = () => {
  const API_URL = `http://localhost:8081/categories`;

  const { isLoading, errorMessage, apiData } = useFetch(API_URL);
  console.log(apiData);
  if (isLoading)
    return (
      <div className="App">
        <p>Loading data...</p>
      </div>
    );

  return (
    <div className={styles["categoryList-container"]}>
      <section>
        <Heading variant="h1">Buscar por tipo de alojamiento</Heading>
      </section>
    </div>
  );
};

export default CategoryList;
