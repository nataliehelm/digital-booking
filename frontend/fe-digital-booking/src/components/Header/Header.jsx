import React, { useState } from "react";
import Drawer from "./Drawer";
import styles from "./Header.module.css";

const Header = () => {
  const [showDrawer, setShowDrawer] = useState(false);

  return (
    <>
      {showDrawer && <Drawer setShowDrawer={setShowDrawer} />}
      {!showDrawer && (
        <main className={styles["header-container"]}>
          <img src="assets/logo.svg" alt="DB Logo" />
          <span className="material-icons" onClick={() => setShowDrawer(true)}>
            menu
          </span>
        </main>
      )}
    </>
  );
};

export default Header;
