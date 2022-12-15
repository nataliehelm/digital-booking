import { DateRange } from 'react-date-range';
import { es } from 'date-fns/locale';
import { useEffect } from 'react';
import styles from './BookingCalendar.module.scss';
import PropTypes from 'prop-types';

const BookingCalendar = ({
  setRange,
  minDate,
  range,
  months,
  disabledDates,
}) => {
  useEffect(() => {
    const head = document.head;
    const link = document.createElement('link');

    link.type = 'text/css';
    link.rel = 'stylesheet';
    link.href = '/assets/styles/booking-calendar.css';

    head.appendChild(link);

    return () => {
      head.removeChild(link);
    };
  }, []);

  return (
    <DateRange
      locale={es}
      onChange={(item) => setRange?.([item.selection])}
      editableDateInputs={false}
      moveRangeOnFirstSelection={false}
      minDate={minDate}
      ranges={range}
      months={months}
      direction="horizontal"
      className={styles.calendarElement}
      disabledDates={disabledDates}
      showMonthAndYearPickers={false}
      showDateDisplay={false}
      monthDisplayFormat="MMMM"
      weekdayDisplayFormat="EEEEE"
    />
  );
};

BookingCalendar.propTypes = {
  months: PropTypes.number.isRequired,
  setRange: PropTypes.func,
  minDate: PropTypes.instanceOf(Date).isRequired,
  range: PropTypes.arrayOf(
    PropTypes.shape({
      startDate: PropTypes.instanceOf(Date).isRequired,
      endDate: PropTypes.instanceOf(Date).isRequired,
      key: PropTypes.string.isRequired,
    })
  ),
  disabledDates: PropTypes.arrayOf(PropTypes.instanceOf(Date)),
};

export default BookingCalendar;
