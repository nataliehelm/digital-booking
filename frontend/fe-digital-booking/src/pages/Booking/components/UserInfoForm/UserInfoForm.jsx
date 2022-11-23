import React from 'react';
import styles from './UserInfoForm.module.scss';
import cn from 'classnames';
import { Input, WritableDropdown } from '../../../../atoms';

const UserInfoForm = ({
  name,
  lastname,
  email,
  locations,
  onChangeLocation,
  locationSelected,
}) => {
  console.log({ locationSelected });
  return (
    <div className={styles['container']}>
      <h2 className={styles['input-title']}>Cómpleta tus datos</h2>
      <div className={styles['user-form-container']}>
        <div className={styles['input-divider']}>
          <Input
            name="nombre"
            value={name}
            label="Nombre"
            type="text"
            disabled
            classname={styles['input-style']}
          />
          <Input
            name="apellido"
            value={lastname}
            label="Apellido"
            type="text"
            disabled
            classname={styles['input-style']}
          />
        </div>
        <div
          className={cn(styles['input-divider'], styles['latest-inputs'])}
          style={{ position: 'relative' }}
        >
          <Input
            name="email"
            value={email}
            label="Correo Electronico"
            type="text"
            disabled
            classname={styles['input-style']}
          />
          <div
            style={{
              position: 'absolute',
              right: '0',
              marginTop: '23px',
              zIndex: '2',
            }}
          >
            <WritableDropdown
              options={locations}
              onChange={onChangeLocation}
              placeholder="Ciudad"
              location={locationSelected}
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserInfoForm;
