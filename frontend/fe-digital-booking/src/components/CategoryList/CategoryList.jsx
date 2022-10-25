import React from "react";
import styles from "./CategoryList.module.scss";
import { Heading } from "../../atoms";
import useFetch from "../../hooks/useFetch";
import CategoryCard from "../CategoryCard/CategoryCard";

const CategoryList = () => {
  const API_URL = "http://localhost:8081/categories";

  const { isLoading, errorMessage, data } = useFetch(API_URL);
  console.log(data);
  if (isLoading)
    return (
      <div className={styles["category-list-container"]}>
        <figure>
          <img src="assets/loading-gif.gif" alt="Loading..."></img>
        </figure>
      </div>
    );

  return (
    <div className={styles["category-list-container"]}>
      <div className={styles["list-header"]}>
        <Heading variant="h1">Buscar por tipo de alojamiento</Heading>
      </div>
      <div className={styles.list}>
        <ul>
          {data.slice(0, 4).map((categoria) => {
            return (
              <li key={categoria.id}>
                <CategoryCard
                  img={categoria.image_url}
                  title={categoria.title}
                  description={categoria.description}
                />
              </li>
            );
          })}
        </ul>
      </div>
    </div>
  );
};

export default CategoryList;
