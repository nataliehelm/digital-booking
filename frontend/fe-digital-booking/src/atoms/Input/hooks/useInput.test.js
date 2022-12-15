import { renderHook, act } from "@testing-library/react";
import useInput from "./useInput";

describe("useInput", () => {
  test("Should set a basic state", () => {
    const { result } = renderHook(() => useInput(""));
    expect(result.current.value).toBe("");
  });
  test("Should change value when onChange is triggered", () => {
    const { result } = renderHook(() => useInput(""));

    act(() => result.current.onChange({ target: { value: "hola" } }));

    expect(result.current.value).toBe("hola");
  });
});
