import React from "react";
import { Button } from "../../atoms";
import "./AuthButtons.module.scss";
import { Link } from "react-router-dom";

const AuthButtons = () => {
  return (
    <section>
      <Link to="/signin">
        <Button variant="b2" onClick={console.log}>
          Crear cuenta
        </Button>
      </Link>
      <Link to="/login">
        <Button variant="b2" onClick={console.log}>
          Iniciar sesión
        </Button>
      </Link>
    </section>
  );
};

export default AuthButtons;
