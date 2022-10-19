import { render, screen } from "@testing-library/react";
import Heading from "./Heading";

describe("<Heading />", () => {
  test("Should render its respective <h> element depending on the variant", () => {
    render(<Heading variant="h1">H1</Heading>);
    expect(screen.getByText("H1")).toBeInTheDocument();
    expect(screen.getByText("H1").nodeName).toBe("H1");

    render(<Heading variant="h2">H2</Heading>);
    expect(screen.getByText("H2")).toBeInTheDocument();
    expect(screen.getByText("H2").nodeName).toBe("H2");

    render(<Heading variant="h3">H3</Heading>);
    expect(screen.getByText("H3")).toBeInTheDocument();
    expect(screen.getByText("H3").nodeName).toBe("H3");

    render(<Heading variant="h4">H4</Heading>);
    expect(screen.getByText("H4")).toBeInTheDocument();
    expect(screen.getByText("H4").nodeName).toBe("H4");
  });
});
