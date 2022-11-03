import { render, screen } from '@testing-library/react';
import Feature from './Feature';

describe('<Feature />', () => {
  test('Should render basic component with correct inputs', () => {
    render(
      <Feature
        title="Normas de la casa"
        items={['Check-out: 10:00', 'No se permiten fiestas', 'No fumar']}
      />
    );
    expect(screen.getByText('Normas de la casa')).toBeInTheDocument();
    expect(screen.getAllByRole('heading')).toHaveLength(1);
    expect(screen.getByText('Check-out: 10:00')).toBeInTheDocument();
    expect(screen.getByText('No se permiten fiestas')).toBeInTheDocument();
    expect(screen.getByText('No fumar')).toBeInTheDocument();
  });
});
