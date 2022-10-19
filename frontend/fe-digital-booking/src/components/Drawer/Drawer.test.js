import { render, screen, fireEvent } from "@testing-library/react";
import Drawer from "./Drawer";

describe("<Drawer />", () => {
  test("Should contain the 'MENÚ label", () => {
    render(<Drawer setShowDrawer={() => jest.fn()} />);
    expect(screen.getByText("MENÚ")).toBeInTheDocument();
  });

  test("Should render 4 <img />", () => {
    render(<Drawer setShowDrawer={() => jest.fn()} />);
    expect(screen.getAllByRole("img")).toHaveLength(4);
  });

  test("setShowDrawer should be called with 'false' value when <button /> is clicked", () => {
    const setShowDrawer = jest.fn();
    render(<Drawer setShowDrawer={setShowDrawer} />);
    const button = screen.getByRole("button");
    fireEvent.click(button);
    expect(setShowDrawer).toBeCalledWith(false);
  });

  test("Should render 'Felipe Monterrosa' when has username prop", () => {
    const setShowDrawer = jest.fn();
    render(
      <Drawer setShowDrawer={setShowDrawer} username="Felipe Monterrosa" />
    );
    expect(screen.getByText("Felipe Monterrosa")).toBeInTheDocument();
  });

  test("localStorage Should set 'Felipe Monterrosa' username when login is clicked", () => {
    jest.spyOn(Storage.prototype, "setItem");
    Storage.prototype.setItem = jest.fn();
    const setShowDrawer = jest.fn();

    render(<Drawer setShowDrawer={setShowDrawer} />);

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
      <Drawer setShowDrawer={setShowDrawer} username="Felipe Monterrosa" />
    );

    const button = screen.getByRole("button", {
      name: /¿Deseas cerrar sesión?/i,
    });
    fireEvent.click(button);

    expect(localStorage.removeItem).toHaveBeenCalledWith("username");
  });
});
