import { Button, Heading, Text } from "../../../atoms";
import useInput from "../../../atoms/Input/hooks/useInput";
import Input from "../../../atoms/Input/Input";
import styles from "./LogIn.module.scss";
import { Link } from "react-router-dom";
import { mandatoryValidator } from "../../../utils/validators";
import { useMemo } from "react";

const LogIn = () => {
  const email = useInput("", mandatoryValidator);
  const password = useInput("", mandatoryValidator);

  const disabled = useMemo(() => {
    return [email, password].some((item) => item.value === "" || item.hasError);
  }, [email, password]);

  return (
    <main className={styles.main}>
      <form className={styles["login-in-form"]}>
        <Heading variant="h1" classname={styles.title}>
          Iniciar sesión
        </Heading>
        <section className={styles["form-container"]}>
          <Heading variant="h1" classname={styles["title-tablet-desktop"]}>
            Iniciar sesión
          </Heading>
          <Input
            name="email"
            value={email.value}
            onChange={email.onChange}
            label="Correo electrónico"
            type="email"
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
            disabled={disabled}
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
