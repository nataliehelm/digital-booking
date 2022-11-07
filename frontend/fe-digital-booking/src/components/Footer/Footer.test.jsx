import { render, screen } from '@testing-library/react';
import Footer from './Footer';

describe('<Footer />', () => {
  test('Should render a footer', () => {
    render(<Footer />);
    expect(screen.getByRole('contentinfo')).toBeInTheDocument();
  });

  test('Should show the current year', () => {
    const year = new Date().getFullYear();
    render(<Footer />);
    expect(screen.getByRole('contentinfo').textContent).toContain(
      year.toString()
    );
    expect(screen.getByRole('contentinfo').textContent).toContain(
      'Digital Booking'
    );
  });

  test('Should render Social Network component in the footer', () => {
    render(<Footer />);
    //expect(screen.getAllByRole('link')).toBeInTheDocument();
    expect.arrayContaining(screen.getAllByRole('link'));
  });
});
