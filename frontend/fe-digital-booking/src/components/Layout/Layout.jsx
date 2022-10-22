import React, { Children } from 'react'
import styles from './Layout.module.scss'
import useLayoutDimension from './hook/useLayoutDimension'
import PropTypes from 'prop-types'


const Layout = ({children}) => {
  const{fullHeight, headerHeight} = useLayoutDimension()
  return (
    <div className={styles["layout-container"]} style={{height: fullHeight, marginTop: headerHeight}}>
      {children}
    </div>
  )
}

Layout.propTypes = {children: PropTypes.element.isRequired}

export default Layout
