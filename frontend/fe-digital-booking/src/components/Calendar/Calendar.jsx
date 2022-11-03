import { DateRange } from 'react-date-range';
import PropTypes from 'prop-types';
import styles from './Calendar.module.scss';
import Button from '../../atoms/Button/Button';
import { es } from 'date-fns/locale';

import 'react-date-range/dist/styles.css';
import './digital-booking-calendar-theme.scss';
import Input from '../../atoms/Input/Input';
import { useState, useRef } from 'react';
import useOnClickOutside from '../../hooks/useOnClickOutside/useOnClickOutside';

const Calendar = ({
  months,
  datesRange,
  setDatesRange,
  calendarPlaceholder,
}) => {
  const [showCalendar, setShowCalendar] = useState(false);
  const calendarRef = useRef();
  useOnClickOutside(calendarRef, () => setShowCalendar(false));

  return (
    <div style={{ position: 'relative' }} ref={calendarRef}>
      <Input
        //disabled
        name="basic-input"
        onChange={() => {}}
        placeholder={calendarPlaceholder}
        placeholderIcon={<i className="fa-regular fa-calendar"></i>}
        value=""
        onClick={() => {
          setShowCalendar(true);
        }}
      />
      {showCalendar && (
        <>
          <DateRange
            locale={es}
            onChange={(item) => setDatesRange([item.selection])}
            editableDateInputs={false}
            moveRangeOnFirstSelection={false}
            ranges={datesRange}
            months={months}
            direction="horizontal"
            className={styles.calendarElement}
            showMonthAndYearPickers={false}
            showDateDisplay={false}
            monthDisplayFormat="MMMM"
            weekdayDisplayFormat="EEEEE"
          />

          <div
            id="calendar-submit"
            style={{
              position: 'absolute',
              right: '0',
              bottom: '0',
              width: '90%',
              left: '0',
              margin: 'auto',
              backgroundColor: 'white',
              height: '70px',
              padding: '15px 0',
            }}
          >
            <Button variant="b1" onClick={() => setShowCalendar(false)}>
              Aplicar
            </Button>
          </div>
        </>
      )}
    </div>
  );
};

Calendar.propTypes = {
  months: PropTypes.number.isRequired,
  calendarPlaceholder: PropTypes.string.isRequired,
};

export default Calendar;
