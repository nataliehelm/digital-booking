import { differenceInDays } from 'date-fns';

export const isSameOrBefore = (date1, date2) => {
  return differenceInDays(date1, date2) <= 0;
};
