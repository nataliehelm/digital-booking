import { useEffect } from 'react';
import { DateRange } from 'react-date-range';
import PropTypes from 'prop-types';
import styles from './Calendar.module.scss';
import Button from '../../atoms/Button/Button';
import useBreakpoint from '../../hooks/useBreakpoint';
import { es } from 'date-fns/locale';

const Calendar = ({ months, datesRange, setDatesRange }) => {
  const breakpoint = useBreakpoint();

  useEffect(() => {
    const container = document.querySelector('.rdrMonthAndYearWrapper');
    const prevMonth = document.querySelector('.rdrPprevButton');
    const nextMonth = document.querySelector('.rdrNextButton');
    const monthTitles = document.getElementsByClassName('rdrMonthName');
    const rightMonth = document.getElementsByClassName('rdrMonth')[1];
    const daysInRange = document.getElementsByClassName('rdrInRange');
    const months = document.querySelector('.rdrMonthsHorizontal');

    const firstDay = document.querySelector('.rdrStartEdge');
    const lastDay = document.querySelector('.rdrEndEdge');

    const setStyles = () => {
      if (container) {
        container.style['height'] = '0';
        container.style['color'] = 'transparent';
        container.style['position'] = 'relative';
      }
      if (prevMonth) {
        prevMonth.style['top'] = '15px';
        prevMonth.style['position'] = 'absolute';
      }

      if (nextMonth) {
        nextMonth.style['top'] = '15px';
        nextMonth.style['right'] = '0px';
        nextMonth.style['position'] = 'absolute';
      }

      if (monthTitles) {
        [...monthTitles].forEach((title) => {
          title.style['text-align'] = 'center';
        });
      }

      if (rightMonth) rightMonth.style['border-left'] = '1px solid #A8A8A8';
      if (months) {
        months.style['height'] = '350px';
        months.style['justify-content'] = 'center';
      }

      if (firstDay) {
        firstDay.style['background-color'] = '#1DBEB4';
        firstDay.style['border-radius'] = '100%';
        firstDay.style['height'] = '20px';
        firstDay.style['width'] = '20px';
        firstDay.style['top'] = '8px';
      }

      if (lastDay) {
        lastDay.style['background-color'] = '#1DBEB4';
        lastDay.style['border-radius'] = '100%';
        lastDay.style['height'] = '20px';
        lastDay.style['width'] = '20px';
        lastDay.style['top'] = '8px';
      }

      [...daysInRange].forEach((day) => {
        day.style['background-color'] = '#1DBEB4';
        day.style['border-radius'] = '100%';
        day.style['height'] = '20px';
        day.style['width'] = '20px';
        day.style['top'] = '8px';
      });

      if (breakpoint !== 'sm' && breakpoint !== 'md') {
        if (firstDay) firstDay.style['left'] = '3px';
        if (lastDay) lastDay.style['left'] = '3px';

        [...daysInRange].forEach((day) => {
          day.style['left'] = '3px';
        });
      } else {
        if (firstDay) firstDay.style['left'] = '13px';
        if (lastDay) lastDay.style['left'] = '13px';

        [...daysInRange].forEach((day) => {
          day.style['left'] = '13px';
        });
      }
    };

    prevMonth.addEventListener('click', setStyles);
    nextMonth.addEventListener('click', setStyles);

    setStyles();
  }, [datesRange, breakpoint]);

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
