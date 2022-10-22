import { Button, Heading, Text } from "../../../atoms";
import useInput from "../../../atoms/Input/hooks/useInput";
import Input from "../../../atoms/Input/Input";
import styles from "./LogIn.module.scss";
import { Link } from "react-router-dom";

const LogIn = () => {
  const email = useInput("");
  const password = useInput("");

  return (
    <main className={styles.main}>
      <form className={styles["login-in-form"]}>
        <Heading variant="h1" classname={styles.title}>
          Iniciar sesión
        </Heading>
        <section>
          <Input
            name="email"
            value={email.value}
            onChange={email.onChange}
            label="Correo electrónico"
          />
          <Input
            name="password"
            value={password.value}
            onChange={password.onChange}
            label="Contraseña"
            type="password"
          />
          <Button
            variant="b2"
            type="submit"
            classname={styles["submit-button"]}
            onClick={console.log}
          >
            Ingresar
          </Button>
          <Text variant="t2" classname={styles["signin-text"]}>
            <>
              ¿Aún no tenes cuenta?{" "}
              <Link to="/signin">
                <span> Registrate</span>
              </Link>
            </>
          </Text>
        </section>
      </form>
    </main>
  );
};

export default LogIn;
