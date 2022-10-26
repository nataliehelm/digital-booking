import { useEffect, useState } from 'react';
import breakpoints, { sm, lg, md, xl } from './breakpoints';

const useBreakpoint = () => {
  const [breakpoint, setBreakPoint] = useState('');
  const [windowSize, setWindowSize] = useState({
    width: undefined,
    height: undefined,
  });

  const handleResize = () => {
    setWindowSize({
      width: window.innerWidth,
      height: window.innerHeight,
    });
  };

  useEffect(() => {
    window.addEventListener('resize', handleResize);
    handleResize();

    if (0 <= windowSize.width && windowSize.width <= sm) {
      setBreakPoint(breakpoints[sm]);
    }
    if (sm <= windowSize.width && windowSize.width <= md) {
      setBreakPoint(breakpoints[sm]);
    }
    if (md <= windowSize.width && windowSize.width <= lg) {
      setBreakPoint(breakpoints[md]);
    }
    if (lg <= windowSize.width && windowSize.width <= xl) {
      setBreakPoint(breakpoints[lg]);
    }
    if (windowSize.width >= xl) {
      setBreakPoint(breakpoints[xl]);
    }

    return () => window.removeEventListener('resize', handleResize);
  }, [windowSize.width]);
  return breakpoint;
};

export default useBreakpoint;
