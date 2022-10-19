import { render, screen, fireEvent } from "@testing-library/react";
import Drawer from "./Drawer";

describe("<Drawer />", () => {
  test("Should contain the 'MENÚ label", () => {
    render(<Drawer setShowDrawer={() => jest.fn()} />);
    expect(screen.getByText("MENÚ")).toBeInTheDocument();
  });

  test("Should render 4 <img />", () => {
    render(<Drawer setShowDrawer={() => jest.fn()} />);
    expect(screen.getAllByRole("img")).toHaveLength(4);
  });

  test("setShowDrawer should be called with 'false' value when <button /> is clicked", () => {
    const setShowDrawer = jest.fn();
    render(<Drawer setShowDrawer={setShowDrawer} />);
    const button = screen.getByRole("button");
    fireEvent.click(button);
    expect(setShowDrawer).toBeCalledWith(false);
  });
});
