import { eachDayOfInterval } from 'date-fns';

export const getDatesInRange = (startDate, endDate) => {
  return eachDayOfInterval({
    start: new Date(startDate),
    end: new Date(endDate),
  });
};
