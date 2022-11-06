import { Botton } from '../../atoms';
import SocialNetwork from '../SocialNetwork';
import styles from './Footer.module.scss';

const Footer = () => {
  const year = new Date().getFullYear();
  return (
    <footer id="footer" className={styles['footer-container']}>
      <div className={styles.trademark}>
        <Botton variant="b1">
          <>&copy;{year} Digital Booking</>
        </Botton>
      </div>
      <section>
        <SocialNetwork />
      </section>
    </footer>
  );
};

export default Footer;
