import { useEffect, useState } from 'react';
import { Button } from '../../../../atoms';
import Dropdown from '../../../../atoms/Dropdown';
import Calendar from '../../../../components/Calendar/Calendar';
import styles from './Searcher.module.scss';
import useBreakpoint from './../../../../hooks/useBreakpoint';
import useFetch from '../../../../hooks/useFetch/useFetch';
import parsedLocations from '../../../../mappers/locations.mapper';

const Searcher = () => {
  const breakpoint = useBreakpoint();
  const { isLoading, data: _locations } = useFetch('locations');

  const [locations, setLocations] = useState([]);
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
  const [locationSelected, setLocationSelected] = useState();

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
            <div className={styles['inputs-container']}>
              <div className={styles['cities-container']}>
                <div className={styles.dropdown}>
                  <Dropdown
                    onChange={setLocationSelected}
                    options={locations}
                  />
                </div>
              </div>

              <div className={styles['calendars-container']}>
                <div className={styles.calendars}>
                  <Calendar
                    datesRange={datesRange}
                    setDatesRange={setDatesRange}
                    months={['sm', 'md'].includes(breakpoint) ? 1 : 2}
                    calendarPlaceholder={calendarPlaceholder}
                  />
                </div>
              </div>
            </div>

            <div className={styles['submit-container']}>
              <Button
                variant="b1"
                classname={styles['submit-button']}
                onClick={() => console.log({ datesRange, locationSelected })}
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
