import { Button } from "../../../../atoms";
import Input from "../../../../atoms/Input/Input";
import styles from "./Searcher.module.scss";

const Searcher = () => {
  return (
    <aside className={styles["searcher-container"]}>
      <h1>Busca ofertas en hoteles, casas y mucho más</h1>
      <form>
        <Input
          name="basic-input"
          onChange={() => {}}
          placeholder="¿A dónde vamos?"
          placeholderIcon={<i class="fa-solid fa-location-dot"></i>}
          value=""
        />
        <Input
          name="basic-input"
          onChange={() => {}}
          placeholder="Check in - Check out"
          placeholderIcon={<i class="fa-regular fa-calendar"></i>}
          value=""
        />
        <Button variant="b1" classname={styles["submit-button"]}>
          Buscar
        </Button>
      </form>
    </aside>
  );
};

export default Searcher;
