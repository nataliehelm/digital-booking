/* eslint-disable testing-library/no-node-access */
/* eslint-disable testing-library/no-container */
import { render, screen, fireEvent } from "@testing-library/react";
import { BrowserRouter } from "react-router-dom";
import SignIn from "./SignIn";

describe("<SignIn />", () => {
  test("Should render the component", () => {
    render(
      <BrowserRouter>
        <SignIn />
      </BrowserRouter>
    );
    expect(screen.getAllByRole("main")).toHaveLength(1);
  });

  test("Should render a error with label 'La contraseña debe tener minimo 6 caracteres' when password has less of 6 chars", () => {
    const { container } = render(
      <BrowserRouter>
        <SignIn />
      </BrowserRouter>
    );

    const name = container.querySelector("#name");
    const lastname = container.querySelector("#lastname");
    const email = container.querySelector("#email");
    const passwordInput = container.querySelector("#password");
    const passConfirmationInput = container.querySelector(
      "#password-confirmation"
    );
    fireEvent.change(name, { target: { value: "Felipe" } });
    fireEvent.change(lastname, { target: { value: "Monterosa" } });
    fireEvent.change(email, {
      target: { value: "felipe.monterrosa@hotmail.com" },
    });
    fireEvent.change(passwordInput, { target: { value: "123" } });
    fireEvent.change(passConfirmationInput, { target: { value: "122" } });

    expect(
      screen.getByText("La contraseña debe tener minimo 6 caracteres")
    ).toBeInTheDocument();
  });

  test("Should render a error with label 'Email inválido' when email is wrong", () => {
    const { container } = render(
      <BrowserRouter>
        <SignIn />
      </BrowserRouter>
    );

    const name = container.querySelector("#name");
    const lastname = container.querySelector("#lastname");
    const email = container.querySelector("#email");
    const passwordInput = container.querySelector("#password");
    const passConfirmationInput = container.querySelector(
      "#password-confirmation"
    );
    fireEvent.change(name, { target: { value: "Felipe" } });
    fireEvent.change(lastname, { target: { value: "Monterosa" } });
    fireEvent.change(email, {
      target: { value: "felipe.monterrosa" },
    });
    fireEvent.change(passwordInput, { target: { value: "123456" } });
    fireEvent.change(passConfirmationInput, { target: { value: "123456" } });

    expect(screen.getByText("Email inválido")).toBeInTheDocument();
  });
});
