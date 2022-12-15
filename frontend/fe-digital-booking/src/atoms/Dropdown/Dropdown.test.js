import { render, screen, fireEvent } from '@testing-library/react';
import useOnClickOutside from '../../hooks/useOnClickOutside/useOnClickOutside';
import Dropdown from './Dropdown';

const options = [
  {
    id: 1,
    title: 'Colombia',
  },
  {
    id: 2,
    title: 'Buenos Aires',
    description: 'Argentina',
  },
];

jest.mock('../../hooks/useOnClickOutside/useOnClickOutside', () => jest.fn());

describe('<Dropdown />', () => {
  test('Should render component with Colombia and Argentina labels', async () => {
    render(<Dropdown options={options} onChange={jest.fn} />);
    const input = screen.getByRole('textbox');
    fireEvent.focus(input);
    expect(screen.getByText('Colombia')).toBeInTheDocument();
    expect(screen.getByText('Argentina')).toBeInTheDocument();
  });

  test('Component should return object with selected option when is clicked', async () => {
    const onChange = jest.fn();
    const outsideClick = jest.fn();
    useOnClickOutside.mockImplementation(() => ({
      ref: undefined,
      handler: outsideClick,
    }));
    render(
      <div>
        <button></button>
        <Dropdown options={options} onChange={onChange} />
      </div>
    );
    const outside = screen.getByRole('button');
    const input = screen.getByRole('textbox');
    fireEvent.focus(input);
    const colombiaOption = screen.getByText('Colombia');
    fireEvent.click(colombiaOption);
    expect(onChange).toBeCalledWith({
      description: undefined,
      id: 1,
      title: 'Colombia',
    });
    fireEvent.click(outside);
  });
});
