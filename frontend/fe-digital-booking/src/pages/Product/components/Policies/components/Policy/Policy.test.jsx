import { render, screen } from '@testing-library/react';
import Policy from './Policy';

describe('<Policy />', () => {
  test('Should render basic component with correct inputs', () => {
    render(<Policy title="Normas de la casa" subPolicies={policy} />);
    expect(screen.getByText('Normas de la casa')).toBeInTheDocument();
    expect(screen.getAllByRole('heading')).toHaveLength(1);
    expect(screen.getByText('Check-out: 10:00')).toBeInTheDocument();
    expect(screen.getByText('No se permiten fiestas')).toBeInTheDocument();
    expect(screen.getByText('No fumar')).toBeInTheDocument();
  });
});

const policy = [
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
];
