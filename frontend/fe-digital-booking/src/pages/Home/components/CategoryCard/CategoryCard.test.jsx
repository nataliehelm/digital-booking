import CategoryCard from './CategoryCard';
import { render, screen } from '@testing-library/react';

describe('<CategoryCard />', () => {
  test('should render the component', () => {
    render(
      <CategoryCard
        img={'img_url'}
        title={'title'}
        description={'description'}
      />
    );
    expect(screen.getByRole('heading', { name: 'title' }).tagName).toBe('H2');
    expect(screen.getByRole('heading', { name: 'description' }).tagName).toBe(
      'H4'
    );
    expect(screen.getByRole('img')).toHaveAttribute('src', 'img_url');
  });
});
