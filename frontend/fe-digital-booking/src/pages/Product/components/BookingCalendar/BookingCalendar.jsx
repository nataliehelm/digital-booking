import { useEffect, useRef, useState } from 'react';
import { DateRange } from 'react-date-range';
import { es } from 'date-fns/locale';
import PropTypes from 'prop-types';

import styles from './BookingCalendar.module.scss';
import 'react-date-range/dist/styles.css';

const BookingCalendar = ({ months }) => {
  const [datesRange, setDatesRange] = useState([
    {
      startDate: new Date(),
      endDate: null,
      key: 'selection',
    },
  ]);

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
          onChange={(item) => setDatesRange([item.selection])}
          ranges={datesRange}
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
