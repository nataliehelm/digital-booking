import { Button, Heading, Rank, Text } from '../../../../atoms';
import styles from './BookingDetails.module.scss';
import { format, parseISO } from 'date-fns';
import { useEffect, useState } from 'react';

const BookingDetails = ({
  image,
  title,
  subtitle,
  ranking,
  address,
  location,
  range,
}) => {
  const startDate = range[0].startDate;
  const endDate = range[0].endDate;
  const startDateFormatted = format(startDate, 'dd/MM/yyyy');
  const endDateFormatted = endDate ? format(endDate, 'dd/MM/yyyy') : endDate;

  console.log(JSON.parse(localStorage.getItem('date-range'))[0]);
  return (
    <>
      <div className={styles.container}>
        <Heading variant="h2" classname={styles.title}>
          Detalle de la reserva
        </Heading>
        <div className={styles.wrapper}>
          <div className={styles.image}>
            <img src={image}></img>
          </div>
          <div className={styles.details}>
            <Heading variant="h4">{title.toUpperCase()}</Heading>
            <Heading variant="h2">{subtitle}</Heading>
            <Rank ranking={ranking} />
            <div className={styles.location}>
              <i className="fa-solid fa-location-dot"></i>
              <Text variant="t1">
                <span>
                  {address} - <span> {location}</span>
                </span>
              </Text>
            </div>
            <div className={styles.divider}></div>
            <div className={styles.dates}>
              <Heading variant="h3">Check In</Heading>
              <span>{startDateFormatted}</span>
            </div>
            <div className={styles.divider}></div>
            <div className={styles.dates}>
              <Heading variant="h3">Check Out</Heading>
              <span>{endDateFormatted}</span>
            </div>
            <div className={styles.divider}></div>
            <Button type="submit" variant="b1" classname={styles.button}>
              Confirmar reserva
            </Button>
          </div>
        </div>
      </div>
    </>
  );
};

export default BookingDetails;
