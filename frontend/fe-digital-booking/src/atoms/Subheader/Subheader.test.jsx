import { render, screen, fireEvent } from '@testing-library/react';
import Subheader from './Subheader';

describe('<Subheader />', () => {
  test('Should render the component', () => {
    render(
      <Subheader title="Title" subtitle="Subtitle" onBackClick={jest.fn} />
    );
    expect(screen.getByRole('complementary')).toBeInTheDocument();
  });

  test('Should render the component with two heading', () => {
    render(
      <Subheader title="Title" subtitle="Subtitle" onBackClick={jest.fn} />
    );
    expect(screen.getAllByRole('heading')).toHaveLength(2);
  });

  test('Should execute a function when icon is clicked', () => {
    const handleClick = jest.fn();
    render(
      <Subheader title="Title" subtitle="Subtitle" onBackClick={handleClick} />
    );
    const icon = screen.getByRole('figure');
    fireEvent.click(icon);
    expect(handleClick).toBeCalled();
  });
});
