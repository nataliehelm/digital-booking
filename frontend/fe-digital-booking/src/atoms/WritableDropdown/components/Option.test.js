import { render, screen } from "@testing-library/react";
import Option from "./Option";

describe("<Option />", () => {
  test("Should render the component with 'Colombia' description", () => {
    render(<Option title="Colombia" onClick={jest.fn} />);
    expect(screen.getByText("Colombia")).toBeInTheDocument();
  });
});
