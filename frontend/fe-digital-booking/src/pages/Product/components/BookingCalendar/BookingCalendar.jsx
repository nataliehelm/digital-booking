import { useEffect, useState } from 'react';
import { DateRange } from 'react-date-range';
import { addDays } from 'date-fns';
import { es } from 'date-fns/locale';
import PropTypes from 'prop-types';

import styles from './BookingCalendar.module.scss';
import 'react-date-range/dist/styles.css';
import { getDatesInRange } from '../../../../utils/dates';

const BookingCalendar = ({ months }) => {
  const [range, setRange] = useState([
    {
      startDate: new Date(),
      endDate: addDays(new Date(), 0),
      key: 'selection',
    },
  ]);

  const bookingDates = getDatesInRange(range[0].startDate, range[0].endDate);

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

  const bookedDates = [
    '2022-11-25',
    '2022-11-24',
    '2022-11-23',
    '2022-11-05',
    '2022-11-06',
    '2022-11-07',
    '2022-11-08',
    '2022-11-09',
    '2022-11-15',
  ];

  const disabledDates = bookedDates.map((date) => new Date(date));

  return (
    <div>
      <>
        <DateRange
          locale={es}
          onChange={(item) => setRange([item.selection])}
          editableDateInputs={false}
          moveRangeOnFirstSelection={false}
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
      </>
    </div>
  );
};

BookingCalendar.propTypes = {
  months: PropTypes.number.isRequired,
};

export default BookingCalendar;
