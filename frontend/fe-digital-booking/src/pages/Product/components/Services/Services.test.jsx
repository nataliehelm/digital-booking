import { render, screen } from '@testing-library/react';
import Services from './Services';
import items from './../../lib/services.json';

describe('<Services />', () => {
  test('Should render 7 items', () => {
    render(<Services items={items} />);
    expect(screen.getAllByRole('article')).toHaveLength(7);
  });
});
