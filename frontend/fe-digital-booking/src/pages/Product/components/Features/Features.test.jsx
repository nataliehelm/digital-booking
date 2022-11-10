import { render, screen } from '@testing-library/react';
import Features from './Features';

describe('<Features />', () => {
  test('Should render 7 items', () => {
    render(<Features items={items} />);
    expect(screen.getAllByRole('article')).toHaveLength(7);
  });
});

const items = [
  {
    id: 1,
    name: 'Cocina',
    icon: 'fa-solid fa-kitchen-set',
  },
  {
    id: 2,
    name: 'Aire acondicionado',
    icon: 'fa-regular fa-snowflake',
  },
  {
    id: 3,
    name: 'Estacionamiento gratuito',
    icon: 'fa-solid fa-car',
  },
  {
    id: 4,
    name: 'Wifi',
    icon: 'fa-solid fa-wifi',
  },
  {
    id: 5,
    name: 'Televisor',
    icon: 'fa-solid fa-tv',
  },
  {
    id: 6,
    name: 'Apto mascotas',
    icon: 'fa-solid fa-paw',
  },
  {
    id: 7,
    name: 'Pileta',
    icon: 'fa-solid fa-person-swimming',
  },
];
