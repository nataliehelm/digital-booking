import { render, screen, fireEvent } from "@testing-library/react";
import { BrowserRouter } from "react-router-dom";
import Header from "./Header";

describe("<Header />", () => {
  test("Should contain logo", () => {
    render(
      <BrowserRouter>
        <Header />
      </BrowserRouter>
    );
    expect(screen.getByRole("img", { name: /DB Logo/i })).toBeInTheDocument();
  });

  test("Should render <Drawer /> when <button /> is clicked", async () => {
    render(
      <BrowserRouter>
        <Header />
      </BrowserRouter>
    );
    const button = screen.getByRole("button", { name: "" });
    fireEvent.click(button);
    await screen.findByText("MENÚ");
  });
});
