import PropTypes from 'prop-types';
import { useRef, useEffect } from 'react';
import { Button, Input } from '../../atoms';
import { DateRange } from 'react-date-range';
import { es } from 'date-fns/locale';

import styles from './Calendar.module.scss';
import 'react-date-range/dist/styles.css';
import { addDays } from 'date-fns';

const Calendar = ({
  months,
  datesRange,
  setDatesRange,
  calendarPlaceholder,
  showCalendar,
  setShowCalendar,
}) => {
  const calendarRef = useRef();

  useEffect(() => {
    const head = document.head;
    const link = document.createElement('link');

    link.type = 'text/css';
    link.rel = 'stylesheet';
    link.href = '/assets/styles/home-calendar.css';

    head.appendChild(link);

    return () => {
      head.removeChild(link);
    };
  }, []);

  const handleOnReset = () => {
    setDatesRange([
      {
        startDate: addDays(new Date(), -1),
        endDate: addDays(new Date(), -1),
        key: 'selection',
      },
    ]);
  };

  return (
    <div style={{ position: 'relative' }} ref={calendarRef}>
      <Input
        noCaret
        name="basic-input"
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
            minDate={new Date()}
          />

          <div className={styles['buttons-container']}>
            <div>
              <Button variant="b2" onClick={handleOnReset}>
                Borrar
              </Button>
            </div>

            <div>
              <Button variant="b1" onClick={() => setShowCalendar(false)}>
                Aplicar
              </Button>
            </div>
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
