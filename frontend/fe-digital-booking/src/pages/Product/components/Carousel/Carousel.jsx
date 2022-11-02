import React from 'react'
import styles from './Carousel.module.scss'
import useBreakpoint from '../../../../hooks/useBreakpoint'
import { useState } from 'react'
import { useEffect } from 'react'
import ImagesSlider from '../ImagesSlider/ImagesSlider'




const Carousel = ({imageLeft, imageGrid}) => {

	const [slider, setSlider] = useState(false)

	const brakepoint = useBreakpoint()
	
	const imageSlider = () => {
		setSlider(true)
	}

	if(brakepoint === 'sm' || brakepoint === 'md') {
		return <CarouselMobile images={[imageLeft, ...imageGrid]}/>
	} return (
		<div>
			<div className={styles['product-image-container']}>
				<div className={styles['product-image-left']}>
							<img src={imageLeft} alt="img" />
				</div>
				<div className={styles['product-image-right']}>
					{
						imageGrid.map((image) => {
							return(
								<img src={image} alt=""></img>
							)
						})
					}
				</div>
					<button className={styles['button']} onClick={imageSlider} >Ver más</button>
			</div>
					{slider && <ImagesSlider setSlider={setSlider} images={[imageLeft, ...imageGrid]} />}
		</div>
  )
}


const CarouselMobile = ({images}) => {
	
	const [currentIndex, setCurrentIndex] = useState(0)

	useEffect(() => {
		const interval = setInterval( () => changeImage(currentIndex), 3000)
		return() => clearInterval(interval)
	}, [currentIndex])

	const changeImage = (index) => {
		console.log({index, test:images.length -1})
		if(index != images.length -1) {
			setCurrentIndex(index +1)
		} else {
			setCurrentIndex(0)
		}
	}

	return(
		<div className={styles['product-image-container']}>
			<div className={styles['product-image-left']}>
						<img src={images[currentIndex]} alt="img" />
						<span className={styles['image-number']}>{currentIndex+1}/{images.length}</span>
			</div>
		</div>
	)
}

export default Carousel
