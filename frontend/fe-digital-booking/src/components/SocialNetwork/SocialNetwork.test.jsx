import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import SocialNetwork from './SocialNetwork';

describe('<SocialNetwork />', () => {
  test('should renderize icons with a link to the social networks', () => {
    render(<SocialNetwork />);
    expect.arrayContaining(screen.getAllByRole('link'));
  });

  test('should renderize the social network icons with a link to each network', () => {
    render(<SocialNetwork />);
    const links = screen.getAllByRole('link');
    expect(links).toHaveLength(4);
    expect(links.every((link) => link.href)).toBeTruthy();
  });
  test('link to the social network should open in a new tab', () => {
    render(<SocialNetwork />);
    const links = screen.getAllByRole('link');
    expect(links.every((link) => link.target === '_blank')).toBeTruthy();
  });
  test('should contain a link to Facebook', () => {
    render(<SocialNetwork />);
    const links = screen.getAllByRole('link');
    expect(
      links.some((link) => link.href.includes('facebook.com'))
    ).toBeTruthy();
  });
});
