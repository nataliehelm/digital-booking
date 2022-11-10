import { render, screen } from '@testing-library/react';
import Policies from './Policies';
import policies from './lib/policies.json';

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
