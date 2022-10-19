import { render, screen, fireEvent } from "@testing-library/react";
import Header from "./Header";

describe("<Header />", () => {
  test("Should contain logo", () => {
    render(<Header />);
    expect(screen.getByRole("img", { name: /DB Logo/i })).toBeInTheDocument();
  });

  test("Should render <Drawer /> when <button /> is clicked", async () => {
    render(<Header />);
    const button = screen.getByRole("button", { name: /menu/i });
    fireEvent.click(button);
    await screen.findByText("MENÚ");
  });
});
