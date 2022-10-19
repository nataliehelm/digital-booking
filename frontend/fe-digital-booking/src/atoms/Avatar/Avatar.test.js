import { render, screen } from "@testing-library/react";
import Avatar from "./Avatar";

describe("<Avatar />", () => {
  test("Should contain the 'F' label", () => {
    render(<Avatar username="Felipe" />);
    expect(screen.getByText("F")).toBeInTheDocument();
  });
  test("Should contain the 'FM' label", () => {
    render(<Avatar username="Felipe Monterrosa" />);
    expect(screen.getByText("FM")).toBeInTheDocument();
  });
});
