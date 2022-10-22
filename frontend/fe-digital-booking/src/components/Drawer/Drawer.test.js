import { render, screen, fireEvent } from "@testing-library/react";
import { BrowserRouter } from "react-router-dom";
import Drawer from "./Drawer";

describe("<Drawer />", () => {
  test("Should contain the 'MENÚ label", () => {
    render(
      <BrowserRouter>
        <Drawer setShowDrawer={() => jest.fn()} />
      </BrowserRouter>
    );
    expect(screen.getByText("MENÚ")).toBeInTheDocument();
  });

  test("Should render 6 links", () => {
    render(
      <BrowserRouter>
        <Drawer setShowDrawer={() => jest.fn()} />
      </BrowserRouter>
    );
    expect(screen.getAllByRole("link")).toHaveLength(6);
  });

  test("setShowDrawer should be called with 'false' value when <button /> is clicked", () => {
    const setShowDrawer = jest.fn();
    render(
      <BrowserRouter>
        <Drawer setShowDrawer={setShowDrawer} />
      </BrowserRouter>
    );
    const button = screen.getByRole("button");
    fireEvent.click(button);
    expect(setShowDrawer).toBeCalledWith(false);
  });

  test("Should render 'Felipe Monterrosa' when has username prop", () => {
    const setShowDrawer = jest.fn();
    render(
      <BrowserRouter>
        <Drawer setShowDrawer={setShowDrawer} username="Felipe Monterrosa" />
      </BrowserRouter>
    );
    expect(screen.getByText("Felipe Monterrosa")).toBeInTheDocument();
  });

  test("localStorage Should set 'Felipe Monterrosa' username when login is clicked", () => {
    jest.spyOn(Storage.prototype, "setItem");
    Storage.prototype.setItem = jest.fn();
    const setShowDrawer = jest.fn();

    render(
      <BrowserRouter>
        <Drawer setShowDrawer={setShowDrawer} />
      </BrowserRouter>
    );

    const button = screen.getByText("Crear cuenta");
    fireEvent.click(button);

    expect(localStorage.setItem).toHaveBeenCalledWith(
      "username",
      "Felipe Monterrosa"
    );
  });

  test("localStorage Should remove username when logout is clicked", () => {
    jest.spyOn(Storage.prototype, "removeItem");
    Storage.prototype.removeItem = jest.fn();
    const setShowDrawer = jest.fn();

    render(
      <BrowserRouter>
        <Drawer setShowDrawer={setShowDrawer} username="Felipe Monterrosa" />
      </BrowserRouter>
    );

    const button = screen.getByRole("button", {
      name: /¿Deseas cerrar sesión?/i,
    });
    fireEvent.click(button);

    expect(localStorage.removeItem).toHaveBeenCalledWith("username");
  });
});
