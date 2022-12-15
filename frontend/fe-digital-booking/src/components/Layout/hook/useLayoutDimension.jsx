import { useEffect, useState } from 'react';

const useLayoutDimension = () => {
  const [fullHeight, setFullHeight] = useState('');
  const [headerHeight, setHeaderHeight] = useState('');
  const [footerHeight, setFooterHeight] = useState('');

  const setDimensions = () => {
    const header = document.getElementById('header');
    const footer = document.getElementById('footer');
    const _headerHeight = header?.offsetHeight || 0;
    const _footerHeight = footer?.offsetHeight || 0;
    const _fullHeight = `calc(100vh - ${_headerHeight}px - ${_footerHeight}px)`;

    setFullHeight(_fullHeight);
    setHeaderHeight(_headerHeight + 'px');
    setFooterHeight(_footerHeight + 'px');
  };

  useEffect(() => {
    setDimensions();
  }, []);

  return {
    fullHeight,
    headerHeight,
    footerHeight,
  };
};

export default useLayoutDimension;
