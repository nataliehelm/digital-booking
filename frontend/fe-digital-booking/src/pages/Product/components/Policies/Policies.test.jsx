import { render, screen } from '@testing-library/react';
import Policies from './Policies';

describe('<Policies />', () => {
  test('Should render basic component with correct inputs', () => {
    render(<Policies policies={policies} />);
    expect(screen.getByText('Normas de la casa')).toBeInTheDocument();
    expect(screen.getAllByRole('heading')).toHaveLength(6);
    expect(screen.getByText('Check-out: 10:00')).toBeInTheDocument();
    expect(screen.getByText('No se permiten fiestas')).toBeInTheDocument();
    expect(screen.getByText('No fumar')).toBeInTheDocument();
  });
});

const policies = [
  {
    id: 1,
    title: 'Normas de la casa',
    subPolicies: [
      {
        id: 1,
        description: 'Check-out: 10:00',
      },
      {
        id: 2,
        description: 'No se permiten fiestas',
      },
      {
        id: 3,
        description: 'No fumar',
      },
    ],
  },
  {
    id: 2,
    title: 'Salud y seguridad',
    subPolicies: [
      {
        id: 4,
        description:
          'Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus',
      },
      {
        id: 5,
        description: 'Detector de humo',
      },
      {
        id: 6,
        description: 'Depósito de seguridad',
      },
    ],
  },
  {
    id: 3,
    title: 'Política de cancelación',
    subPolicies: [
      {
        id: 7,
        description:
          'Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.',
      },
    ],
  },
  {
    id: 4,
    title: 'Políticas de niños',
    subPolicies: [
      {
        id: 8,
        description: 'No se aceptan niños.',
      },
    ],
  },
  {
    id: 5,
    title: 'Políticas de camas adicionales y cunas',
    subPolicies: [
      {
        id: 9,
        description: 'No se pueden agregar cunas en este alojamiento.',
      },
      {
        id: 10,
        description:
          'No se pueden agregar camas adicionales en este alojamiento.',
      },
    ],
  },
];
