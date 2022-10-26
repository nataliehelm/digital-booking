import { useMemo } from "react";
import { Button, Heading, Text } from "../../../atoms";
import useInput from "../../../atoms/Input/hooks/useInput";
import Input from "../../../atoms/Input/Input";
import styles from "./SignIn.module.scss";
import { Link } from "react-router-dom";
import {
  emailValidator,
  mandatoryValidator,
  passwordValidator,
} from "../../../utils/validators";

const SignIn = () => {
  const name = useInput("", mandatoryValidator);
  const lastname = useInput("", mandatoryValidator);
  const email = useInput("", emailValidator);
  const password = useInput("", passwordValidator);
  let passwordConfirmation = useInput("");

  passwordConfirmation = {
    ...passwordConfirmation,
    hasError:
      !!passwordConfirmation.value &&
      password.value !== passwordConfirmation.value,
    errorMessage:
      passwordConfirmation.value &&
      password.value !== passwordConfirmation.value
        ? "Las contraseñas no coinciden"
        : "",
  };

  const disabled = useMemo(() => {
    return [name, lastname, email, password, passwordConfirmation].some(
      (item) => item.value === "" || item.hasError
    );
  }, [name, lastname, email, password, passwordConfirmation]);

  return (
    <main className={styles.main}>
      <Heading variant="h1" classname={styles.title}>
        Crear cuenta
      </Heading>
      <form className={styles["sign-in-form"]}>
        <section>
          <div className={styles.names}>
            <Input {...name} name="name" label="Nombre" />
            <Input {...lastname} name="lastname" label="Apellido" />
          </div>
          <Input
            {...email}
            name="email"
            label="Correo electrónico"
            type="email"
          />
          <Input
            {...password}
            name="password"
            label="Contraseña"
            type="password"
          />
          <Input
            {...passwordConfirmation}
            name="password-confirmation"
            label="Confirmar contraseña"
            type="password"
          />
        </section>
        <Button
          disabled={disabled}
          variant="b1"
          type="submit"
          classname={styles["submit-button"]}
          onClick={console.log}
        >
          Crear cuenta
        </Button>
        <Text variant="t2" classname={styles["login-text"]}>
          <>
            ¿Ya tienes una cuenta?{" "}
            <Link to="/login">
              <span>Iniciar sesión</span>
            </Link>
          </>
        </Text>
      </form>
    </main>
  );
};

export default SignIn;
