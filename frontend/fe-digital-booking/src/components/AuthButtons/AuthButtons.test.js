import { render, screen } from "@testing-library/react";
import AuthButtons from "./AuthButtons";

describe("<AuthButtons />", () => {
  test("Should render two <Button />", () => {
    render(<AuthButtons />);
    expect(screen.getAllByRole("button")).toHaveLength(2);
  });
});
