import { render, screen } from "@testing-library/react";
import App from "./App";

describe("<App />", () => {
  test("Should render <Header />", () => {
    render(<App />);
    expect(screen.getByRole("img", { name: /DB Logo/i })).toBeInTheDocument();
  });
});
