import { render, screen, fireEvent } from '@testing-library/react';
import CategoryList from './CategoryList';

describe('<CategoryList />', () => {
  test('should render the component', () => {
    render(
      <CategoryList
        isLoading={false}
        categories={categories}
        onClick={jest.fn}
        selectedIds={[]}
      />
    );
    expect(screen.getAllByRole('listitem')).toHaveLength(4);
  });
  test('Should execute a function when icon is clicked', () => {
    const handleClick = jest.fn();
    render(
      <CategoryList
        isLoading={false}
        categories={categories}
        onClick={handleClick}
        selectedIds={[]}
      />
    );
    const categoryCard = screen.getAllByRole('listitem');
    fireEvent.click(categoryCard[0]);
    expect(handleClick).toBeCalledWith(1);
  });
  test('should show a figure when isLoading is true', () => {
    render(
      <CategoryList
        isLoading={true}
        categories={categories}
        onClick={jest.fn}
        selectedIds={[]}
      />
    );
    expect(screen.getByRole('figure')).toBeInTheDocument();
  });
});

const categories = [
  {
    id: 1,
    name: 'Hoteles',
    description: '807.105 hoteles',
    image_url:
      'https://images.unsplash.com/photo-1566073771259-6a8506099945?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80',
  },
  {
    id: 2,
    name: 'Hostels',
    description: '807.105 hoteles',
    image_url:
      'https://images.unsplash.com/photo-1582719508461-905c673771fd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1925&q=80',
  },
  {
    id: 3,
    name: 'Departamentos',
    description: '807.105 hoteles',
    image_url:
      'https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1980&q=80',
  },
  {
    id: 4,
    name: 'Bed and breakfast',
    description: '807.105 hoteles',
    image_url:
      'https://images.unsplash.com/photo-1584132905271-512c958d674a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80',
  },
];
