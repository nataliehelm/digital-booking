import React from "react";
import { Button } from "../../atoms";
import "./AuthButtons.module.scss";

const AuthButtons = () => {
  return (
    <section>
      <Button variant="b5" onClick={console.log}>
        Crear cuenta
      </Button>
      <Button variant="b5" onClick={console.log}>
        Iniciar sesión
      </Button>
    </section>
  );
};

export default AuthButtons;
