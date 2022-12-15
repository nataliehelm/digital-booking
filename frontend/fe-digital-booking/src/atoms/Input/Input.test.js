import { render, screen, fireEvent, waitFor } from "@testing-library/react";
import Input from "./Input";

describe("<Input />", () => {
  test("Should render a basic input", () => {
    render(<Input name="basic-input" />);
    expect(screen.getByRole("textbox")).toBeInTheDocument();
  });

  test("Should render a basic button with label", () => {
    render(<Input name="basic-input" label="basic info" />);
    expect(screen.getByText("basic info")).toBeInTheDocument();
  });

  test("Should render a basic button with error message", () => {
    render(
      <Input
        name="basic-input"
        label="basic info"
        hasError
        errorMessage="error"
      />
    );
    expect(screen.getByText("error")).toBeInTheDocument();
  });

  test("Should render a basic button with placeholder", () => {
    render(
      <Input
        name="basic-input"
        label="basic info"
        hasError
        errorMessage="error"
        placeholder="placeholder de prueba"
      />
    );
    expect(screen.getByText("placeholder de prueba")).toBeInTheDocument();
  });

  test("Should change from password to text and vice versa when icon is clicked", async () => {
    render(
      <Input
        name="basic-input"
        label="basic info"
        placeholder="placeholder de prueba"
        type="password"
        value="test"
        onChange={jest.fn}
      />
    );

    let button = screen.getByRole("button");
    fireEvent.click(button);
    let input = screen.getByRole("textbox");
    expect(input.type).toBe("text");
    button = screen.getByRole("button");
    fireEvent.click(button);

    await waitFor(() => {
      expect(input).toBeInTheDocument();
    });
    expect(input.type).toBe("password");
  });

  test("Should set showPlaceholder to false when input is focused and set to true when is blured", async () => {
    render(
      <Input
        name="basic-input"
        label="basic info"
        placeholder="placeholder de prueba"
      />
    );

    let input = screen.getByRole("textbox");
    fireEvent.blur(input);
    expect(screen.getByText("placeholder de prueba")).toBeInTheDocument();
    fireEvent.focus(input);
    expect(screen.queryByText("placeholder de prueba")).not.toBeInTheDocument();
  });
});
