import { render, screen } from "@testing-library/react";
import Login from "./Login";

describe("<Login />", () => {
  test("Should render the component", () => {
    render(<Login />);
    expect(screen.getAllByRole("main")).toHaveLength(1);
  });
});
