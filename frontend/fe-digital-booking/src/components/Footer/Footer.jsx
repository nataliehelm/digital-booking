import React, {useState} from "react";
import SocialNetwork from "../SocialNetwork/SocialNetwork";
import styles from "./Footer.module.scss";


const Footer = () => {

    const [showSocialIcons, setShowSocialIcons] = useState(false);
    const username = localStorage.getItem("username");


    return (
        <footer id="footer" className={styles["footer-container"]}>
            <div className={styles.trademark}>
                <p>&copy;2023 Digital Booking</p>
            </div>
            
            <SocialNetwork/>
        </footer>

    );

};

export default Footer;

