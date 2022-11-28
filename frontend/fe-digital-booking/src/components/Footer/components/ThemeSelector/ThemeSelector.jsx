import styles from './ThemeSelector.module.scss';
import cn from 'classnames';
import { THEME_A, THEME_B, THEME_C } from '../../../../utils/constants';

const ThemeSelector = ({ handleTheme }) => {
  return (
    <div className={styles['theme-container']}>
      <div
        className={cn(styles.theme, styles['theme-a'])}
        onClick={() => handleTheme(THEME_A)}
      />
      <div
        className={cn(styles.theme, styles['theme-b'])}
        onClick={() => handleTheme(THEME_B)}
      />
      <div
        className={cn(styles.theme, styles['theme-c'])}
        onClick={() => handleTheme(THEME_C)}
      />
    </div>
  );
};

export default ThemeSelector;
