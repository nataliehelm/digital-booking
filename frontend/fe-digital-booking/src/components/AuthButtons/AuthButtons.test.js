import { render, screen } from "@testing-library/react";
import { BrowserRouter } from "react-router-dom";
import AuthButtons from "./AuthButtons";

describe("<AuthButtons />", () => {
  test("Should render two <Button />", () => {
    render(
      <BrowserRouter>
        <AuthButtons />
      </BrowserRouter>
    );
    expect(screen.getAllByRole("button")).toHaveLength(2);
  });
});
