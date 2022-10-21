import { Button, Heading, Text } from "../../../atoms";
import useInput from "../../../atoms/Input/hooks/useInput";
import Input from "../../../atoms/Input/Input";
import styles from "./LogIn.module.scss";

const LogIn = () => {
  const name = useInput("");
  const lastname = useInput("");
  const email = useInput("");
  const password = useInput("");
  const passwordConfirmation = useInput("");

  return (
    <main style={{ marginTop: "93px" }} className={styles.main}>
      <Heading variant="h1" classname={styles.title}>
        Crear cuenta
      </Heading>
      <form className={styles["sign-in-form"]}>
        <section>
          <Input
            name="name"
            value={name.value}
            onChange={name.onChange}
            label="Nombre"
          />
          <Input
            name="lastname"
            value={lastname.value}
            onChange={lastname.onChange}
            label="Apellido"
          />
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
          <Input
            name="passwordConfirmation"
            value={passwordConfirmation.value}
            onChange={passwordConfirmation.onChange}
            label="Confirmar contraseña"
            type="password"
          />
        </section>
        <Button variant="b2" type="submit" classname={styles["submit-button"]}>
          Crear cuenta
        </Button>
        <Text variant="t2" classname={styles["login-text"]}>
          <>
            ¿Ya tienes una cuenta? <span> Iniciar sesión</span>
          </>
        </Text>
      </form>
    </main>
  );
};

export default LogIn;
