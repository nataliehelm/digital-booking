import { render, screen } from "@testing-library/react";
import { BrowserRouter } from "react-router-dom";
import App from "./App";

describe("<App />", () => {
  test("Should render <Header />", () => {
    render(
      <BrowserRouter>
        <App />
      </BrowserRouter>
    );
    expect(screen.getByRole("img", { name: /DB Logo/i })).toBeInTheDocument();
  });
});
