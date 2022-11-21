import { useEffect, useState } from 'react';
import { Button, WritableDropdown } from '../../../../atoms';
import { useBreakpoint, useFetch } from './../../../../hooks';
import { Calendar } from '../../../../components';
import { isSameOrBefore } from '../../../../utils/dates';
import parsedLocations from '../../../../mappers/locations.mapper';
import styles from './Searcher.module.scss';

const Searcher = ({
  datesRange,
  setLocationSelected,
  setDatesRange,
  locationSelected,
  onSubmit,
  reset,
  onClick,
}) => {
  const breakpoint = useBreakpoint();
  const { isLoading, data: _locations } = useFetch('locations');

  const [locations, setLocations] = useState([]);
  const [calendarPlaceholder, setCalendarPlaceholder] = useState(
    'Check in - Check out'
  );
  const [showCalendar, setShowCalendar] = useState(false);

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
    if (isSameOrBefore(new Date(), datesRange[0].startDate)) {
      const finalPlaceHolder = `${datesRange[0].startDate.toLocaleDateString(
        'es-ES',
        options
      )} - ${datesRange[0].endDate.toLocaleDateString('es-ES', options)}`;
      setCalendarPlaceholder(finalPlaceHolder);
    } else {
      setCalendarPlaceholder('Check in - Check out');
    }
  }, [datesRange]);

  return (
    <>
      {isLoading && <h1>Cargando...</h1>}
      {!isLoading && (
        <aside className={styles['searcher-container']}>
          <h1>Busca ofertas en hoteles, casas y mucho más</h1>
          <form
            onSubmit={(e) => {
              e.preventDefault();
              onSubmit({ datesRange, locationSelected });
            }}
          >
            <div className={styles['inputs-container']}>
              <div className={styles['cities-container']}>
                <div className={styles.dropdown}>
                  <WritableDropdown
                    onChange={setLocationSelected}
                    options={locations}
                    reset={reset}
                  />
                </div>
              </div>

              <div className={styles['calendars-container']}>
                <div className={styles.calendars}>
                  <Calendar
                    datesRange={datesRange}
                    setDatesRange={setDatesRange}
                    months={['sm', 'md', 'lg'].includes(breakpoint) ? 1 : 2}
                    calendarPlaceholder={calendarPlaceholder}
                    showCalendar={showCalendar}
                    setShowCalendar={setShowCalendar}
                  />
                </div>
              </div>
            </div>

            <div className={styles['submit-container']}>
              <Button
                variant="b1"
                classname={styles['submit-button']}
                type="submit"
                onClick={() => {
                  onClick();
                  setShowCalendar(false);
                }}
              >
                Buscar
              </Button>
            </div>
          </form>
        </aside>
      )}
    </>
  );
};

export default Searcher;
