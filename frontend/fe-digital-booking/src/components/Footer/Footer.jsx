import { Botton } from '../../atoms';
import SocialNetwork from '../SocialNetwork';
import { ThemeSelector } from './components';
import styles from './Footer.module.scss';

const Footer = ({ handleTheme }) => {
  const year = new Date().getFullYear();
  return (
    <footer id="footer" className={styles['footer-container']}>
      <div className={styles.trademark}>
        <Botton variant="b1">
          <>&copy;{year} Digital Booking</>
        </Botton>
      </div>
      <ThemeSelector handleTheme={handleTheme} />
      <section>
        <SocialNetwork />
      </section>
    </footer>
  );
};

export default Footer;
