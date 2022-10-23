import { render, screen, fireEvent } from "@testing-library/react";
import Dropdown from "./Dropdown";

const options = [
  {
    id: 1,
    title: "Colombia",
  },
  {
    id: 2,
    title: "Argentina",
  },
];

describe("<Dropdown />", () => {
  test("Should render component with Colombia and Argentina labels", () => {
    render(<Dropdown options={options} onChange={jest.fn} />);
    expect(screen.getByText("Colombia")).toBeInTheDocument();
    expect(screen.getByText("Argentina")).toBeInTheDocument();
  });

  test("Component should return object with selected option when is clicked", () => {
    const onChange = jest.fn();
    render(<Dropdown options={options} onChange={onChange} />);
    const colombiaOption = screen.getByText("Colombia");
    fireEvent.click(colombiaOption);
    expect(onChange).toBeCalledWith({
      description: undefined,
      id: 1,
      title: "Colombia",
    });
  });
});
