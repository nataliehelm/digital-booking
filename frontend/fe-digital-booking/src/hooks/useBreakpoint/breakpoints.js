import styles from './../../styles/_export.scss';

export const sm = Number(styles.sm?.split('px')[0] || 0);
export const md = Number(styles.md?.split('px')[0] || 0);
export const lg = Number(styles.lg?.split('px')[0] || 0);
export const xl = Number(styles.xl?.split('px')[0] || 0);

const breakpoints = {
  [sm]: 'sm',
  [md]: 'md',
  [lg]: 'lg',
  [xl]: 'xl',
};

export default breakpoints;
