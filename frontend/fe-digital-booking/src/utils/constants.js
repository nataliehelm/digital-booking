import stylesVars from './../styles/_export.scss';

export const THEME = 'theme';
export const THEME_A = 'themeA';
export const THEME_B = 'themeB';
export const THEME_C = 'themeC';

export const THEMES = {
  themeA: {
    'color-primary': stylesVars.themeAColorPrimary,
    'color-secondary': stylesVars.themeAColorSecondary,
    'color-tertiary': stylesVars.themeAColorTertiary,
    'color-quaternary': stylesVars.themeAColorQuaternary,
  },
  themeB: {
    'color-primary': stylesVars.themeBColorPrimary,
    'color-secondary': stylesVars.themeBColorSecondary,
    'color-tertiary': stylesVars.themeBColorTertiary,
    'color-quaternary': stylesVars.themeBColorQuaternary,
  },
  themeC: {
    'color-primary': stylesVars.themeCColorPrimary,
    'color-secondary': stylesVars.themeCColorSecondary,
    'color-tertiary': stylesVars.themeCColorTertiary,
    'color-quaternary': stylesVars.themeCColorQuaternary,
  },
};
