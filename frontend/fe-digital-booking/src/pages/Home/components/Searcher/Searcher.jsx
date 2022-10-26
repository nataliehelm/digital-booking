import { useEffect, useRef, useState } from 'react';
import { Button } from '../../../../atoms';
import Dropdown from '../../../../atoms/Dropdown';
import Input from '../../../../atoms/Input/Input';
import Calendar from '../../../../components/Calendar/Calendar';
import styles from './Searcher.module.scss';
import useBreakpoint from './../../../../hooks/useBreakpoint';
import useOnClickOutside from '../../../../hooks/useOnClickOutside/useOnClickOutside';
import useFetch from '../../../../hooks/useFetch/useFetch';
import parsedLocations from '../../../../mappers/locations.mapper';

const Searcher = () => {
  const breakpoint = useBreakpoint();
  const {
    isLoading,
    data: _locations,
    isError,
  } = useFetch('http://localhost:8081/locations');

  const [locations, setLocations] = useState([]);
  const [showCalendar, setShowCalendar] = useState(false);
  const [calendarPlaceholder, setCalendarPlaceholder] = useState(
    'Check in - Check out'
  );
  const [datesRange, setDatesRange] = useState([
    {
      startDate: new Date(),
      endDate: null,
      key: 'selection',
    },
  ]);

  const calendarRef = useRef();
  useOnClickOutside(calendarRef, () => setShowCalendar(false));

  useEffect(() => {
    if (!isLoading) {
      const finalLocations = parsedLocations(_locations);
      setLocations(finalLocations);
    }
  }, [_locations, isLoading]);

  useEffect(() => {
    const options = {
      month: 'short',
      day: 'numeric',
    };
    if (datesRange[0].startDate && datesRange[0].endDate) {
      const finalPlaceHolder = `${datesRange[0].startDate.toLocaleDateString(
        'es-ES',
        options
      )} - ${datesRange[0].endDate.toLocaleDateString('es-ES', options)}`;
      setCalendarPlaceholder(finalPlaceHolder);
    }
  }, [datesRange]);

  return (
    <>
      {isLoading && <h1>Cargando...</h1>}
      {!isLoading && (
        <aside className={styles['searcher-container']}>
          <h1>Busca ofertas en hoteles, casas y mucho más</h1>
          <form>
            <div className={styles['cities-container']}>
              <div className={styles.dropdown}>
                <Dropdown onChange={console.log} options={locations} />
              </div>
            </div>

            <div
              onClick={() => setShowCalendar(true)}
              className={styles['calendars-container']}
              ref={calendarRef}
            >
              <Input
                disabled
                name="basic-input"
                onChange={() => {}}
                placeholder={calendarPlaceholder}
                placeholderIcon={<i className="fa-regular fa-calendar"></i>}
                value=""
              />
              {showCalendar && (
                <div className={styles.calendars}>
                  <Calendar
                    datesRange={datesRange}
                    setDatesRange={setDatesRange}
                    months={['sm', 'md'].includes(breakpoint) ? 1 : 2}
                  />
                </div>
              )}
            </div>

            <Button
              variant="b1"
              classname={styles['submit-button']}
              onClick={console.log}
            >
              Buscar
            </Button>
          </form>
        </aside>
      )}
    </>
  );
};

export default Searcher;
