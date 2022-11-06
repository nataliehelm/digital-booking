import { render, screen } from '@testing-library/react';
import Policies from './Policies';

describe('<Policies />', () => {
  test('Should render basic component with correct inputs', () => {
    render(<Policies />);
    expect(screen.getByText('Normas de la casa')).toBeInTheDocument();
    expect(screen.getAllByRole('heading')).toHaveLength(4);
    expect(screen.getByText('Check-out: 10:00')).toBeInTheDocument();
    expect(screen.getByText('No se permiten fiestas')).toBeInTheDocument();
    expect(screen.getByText('No fumar')).toBeInTheDocument();
  });
});
