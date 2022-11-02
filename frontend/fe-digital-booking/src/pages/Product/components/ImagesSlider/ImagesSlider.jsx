import {useState} from 'react'
import styles from './ImageSlider.module.scss'
import closeButton from '../Carousel/images/closeButton.svg'
import "react-responsive-carousel/lib/styles/carousel.min.css"; // requires a loader
import { Carousel } from 'react-responsive-carousel';

const ImagesSlider = ({setSlider, images}) => {

    const closeModal = () => {
        setSlider(false)
    }

  return (
		<div>
			<div className={styles['modal']}>
				<div className={styles['close-modal']}>
					<img src={closeButton} alt="close-modal" onClick={closeModal} />
				</div>
				<div>
					<Carousel>
						{images.map((image) => {
							return(
								<img src={image} alt=''></img>
							)
						})}
					</Carousel>
				</div>
			</div>
		</div>
  )
}

export default ImagesSlider
