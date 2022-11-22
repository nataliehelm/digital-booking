import { eachDayOfInterval } from 'date-fns';
import { differenceInDays } from 'date-fns';

export const getDatesInRange = (startDate, endDate) => {
  return eachDayOfInterval({
    start: new Date(startDate),
    end: new Date(endDate),
  });
};

export const isSameOrBefore = (date1, date2) => {
  return differenceInDays(date1, date2) <= 0;
};
