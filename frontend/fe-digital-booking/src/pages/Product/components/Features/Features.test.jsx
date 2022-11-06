import { render, screen } from '@testing-library/react';
import Features from './Features';
import items from './lib/features.json';

describe('<Features />', () => {
  test('Should render 7 items', () => {
    render(<Features items={items} />);
    expect(screen.getAllByRole('article')).toHaveLength(7);
  });
});
