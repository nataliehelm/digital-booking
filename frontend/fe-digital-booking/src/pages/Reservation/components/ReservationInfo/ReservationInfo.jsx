import React from 'react'
import styles from './ReservationInfo.module.scss'
import { Input, Dropdown, WritableDropdown } from '../../../../atoms'
import useAuthContext from '../../../../providers/AuthProvider/useAuthContext'
import { useFetch } from '../../../../hooks'
import parsedLocations from '../../../../mappers/locations.mapper'

const ReservationInfo = ({}) => {

	const { state, cleanJwt } = useAuthContext();
	const { isLoading, data } = useFetch(`locations`)

	console.log(data)


  return (
		<div className={styles['container']}>
			<h2 className={styles['input-title']}>Cómpleta tus datos</h2>
			<div className={styles['reservation-info-container']}>
					<div className={styles['input-divider']}>
								<Input 
										name="nombre"
										value={state.decodedJwt?.name || ''}
										label="Nombre"
										type="text"
										disabled
										classname={styles['input-style']}
								/>
								<Input 
										name="apellido"
										value={state.decodedJwt?.lastname || ''}
										label="Apellido"
										type="text"
										disabled
										classname={styles['input-style']}
									/>
					</div>
					<div className={styles['input-divider']}>
							<Input 
									name="email"
									value={state.decodedJwt?.sub || ''}
									label="Correo Electronico"
									type="text"
									disabled
									classname={styles['input-style']}
								/>
							<Dropdown
									options={data}
									onChange={() => {}}
								/>
					</div>
			</div>

		</div>
  )
}

export default ReservationInfo
