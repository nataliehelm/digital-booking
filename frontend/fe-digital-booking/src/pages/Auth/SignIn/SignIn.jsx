import { useMemo } from "react";
import { Button, Heading, Text } from "../../../atoms";
import useInput from "../../../atoms/Input/hooks/useInput";
import Input from "../../../atoms/Input/Input";
import { EMAIL_REGEX } from "../../../utils/regex";
import styles from "./SignIn.module.scss";

const mandatoryValidator = (value) => [!value, "Campo obligatorio"];

const emailValidator = (value) => {
  if (!EMAIL_REGEX.test(value)) {
    return [true, "Email inválido"];
  }
  return mandatoryValidator(value);
};

const passwordValidator = (value) => {
  if (value.length < 6)
    return [true, "La contraseña debe tener minimo 6 caracteres"];
  return mandatoryValidator(value);
};

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
    <main style={{ marginTop: "93px" }} className={styles.main}>
      <Heading variant="h1" classname={styles.title}>
        Crear cuenta
      </Heading>
      <form className={styles["sign-in-form"]}>
        <section>
          <Input {...name} name="name" label="Nombre" />
          <Input {...lastname} name="lastname" label="Apellido" />
          <Input {...email} name="email" label="Correo electrónico" />
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
          variant="b2"
          type="submit"
          classname={styles["submit-button"]}
          onClick={console.log}
        >
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

export default SignIn;
