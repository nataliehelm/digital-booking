import { render, screen } from "@testing-library/react";
import Text from "./Text";

describe("<Text />", () => {
  test("Should have text-1 class when has t1 variant", () => {
    render(<Text variant="t1">T1</Text>);
    expect(screen.getByText("T1").className).toContain("text-1");
  });
  test("Should have text-2 class when has t2 variant", () => {
    render(<Text variant="t2">T2</Text>);
    expect(screen.getByText("T2").className).toContain("text-2");
  });
});
