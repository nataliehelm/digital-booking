import { render, screen } from "@testing-library/react";
import Botton from "./Botton";

describe("<Botton />", () => {
  test("Should have botton-1 class when has b1 variant", () => {
    render(<Botton variant="b1">B1</Botton>);
    expect(screen.getByText("B1").className).toContain("botton-1");
  });
  test("Should have botton-2 class when has b2 variant", () => {
    render(<Botton variant="b2">B2</Botton>);
    expect(screen.getByText("B2").className).toContain("botton-2");
  });
});
