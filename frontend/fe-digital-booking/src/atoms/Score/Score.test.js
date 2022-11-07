import { render, screen } from '@testing-library/react';
import Score from './Score';

describe('<Score />', () => {
  test('Should render a score', () => {
    render(<Score score={7} />);
    expect(screen.getByText('7')).toBeInTheDocument();
  });
});
