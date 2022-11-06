import { useRef } from 'react';
import { DateRange } from 'react-date-range';
import { es } from 'date-fns/locale';
import PropTypes from 'prop-types';

import styles from './BookingCalendar.module.scss';
import 'react-date-range/dist/styles.css';

const BookingCalendar = ({ months }) => {
  const calendarRef = useRef();

  const bookedDates = [
    '2022-11-25',
    '2022-11-24',
    '2022-11-23',
    '2022-11-05',
    '2022-11-06',
    '2022-11-07',
    '2022-11-08',
    '2022-11-09',
  ];

  const disabledDates = bookedDates.map((date) => new Date(date));

  return (
    <div style={{ position: 'relative' }} ref={calendarRef}>
      <>
        <DateRange
          locale={es}
          editableDateInputs={false}
          moveRangeOnFirstSelection={false}
          months={months}
          direction="horizontal"
          className={styles.calendarElement}
          disabledDates={disabledDates}
          showMonthAndYearPickers={false}
          showDateDisplay={false}
          showSelectionPreview={false}
          showPreview={false}
          monthDisplayFormat="MMMM"
          weekdayDisplayFormat="EEEEE"
        />
      </>
    </div>
  );
};

BookingCalendar.propTypes = {
  months: PropTypes.number.isRequired,
};

export default BookingCalendar;
