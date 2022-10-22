import { useEffect } from "react";
import { useState } from "react";

const useLayoutDimension = () => {
  const [fullHeight, setFullHeight] = useState("");
  const [headerHeight, setHeaderHeight] = useState("");

  const setDimensions = () => {
    const header = document.getElementById("header");
    const _headerHeight = header?.offsetHeight || 0;
    const _fullHeight = `calc(100vh - ${_headerHeight}px)`;
    setFullHeight(_fullHeight);
    setHeaderHeight(_headerHeight + "px");
  };

  useEffect(() => {
    setDimensions();
  }, []);

  return {
    fullHeight,
    headerHeight,
  };
};

export default useLayoutDimension;
