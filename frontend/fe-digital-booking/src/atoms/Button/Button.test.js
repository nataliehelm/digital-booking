import { render, screen } from "@testing-library/react";
import Button from "./Button";

describe("<Button />", () => {
  test("Should render basic button", () => {
    render(
      <Button onClick={console.log} variant="b1">
        Button 1
      </Button>
    );
    expect(screen.getByRole("button").className).toContain("button-1");
  });
});
