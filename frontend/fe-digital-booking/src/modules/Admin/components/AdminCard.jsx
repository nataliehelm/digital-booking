import { Button, Heading, Text } from '../../../atoms';
import styles from './AdminCard.module.scss';

const AdminCard = ({ name, image, category, address, onClick }) => {
  return (
    <div className={styles['card-container']}>
      <Heading variant="h3" classname={styles.heading}>
        {name}
      </Heading>
      <img src={`${image}`} alt={name}></img>
      <Heading variant="h4" classname={styles.heading}>
        {category}
      </Heading>
      <Text variant="t2" classname={styles.address}>
        {address}
      </Text>
      <section className={styles.button}>
        <Button variant="b1" type="button" onClick={onClick}>
          Editar
        </Button>
      </section>
    </div>
  );
};

export default AdminCard;
