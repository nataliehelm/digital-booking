import { DateRange } from 'react-date-range';
import PropTypes from 'prop-types';
import styles from './Calendar.module.scss';
import Button from '../../atoms/Button/Button';
import { es } from 'date-fns/locale';

import 'react-date-range/dist/styles.css';
import './digital-booking-calendar-theme.scss';

const Calendar = ({ months, datesRange, setDatesRange }) => {
  return (
    <div style={{ position: 'relative' }}>
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
        <Button variant="b1" onClick={console.log}>
          Aplicar
        </Button>
      </div>
    </div>
  );
};

Calendar.propTypes = {
  months: PropTypes.number.isRequired,
};

export default Calendar;
