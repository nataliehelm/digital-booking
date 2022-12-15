import { render } from '@testing-library/react';
import Rank from './Rank';

describe('<Rank>', () => {
  test('Should render a stars rank component with 5 stars total', () => {
    render(<Rank ranking={3} />);
    expect(document.getElementsByClassName('fa-star')).toHaveLength(5);
  });

  test('Should render a rank with 3 stars on and 2 stars off', () => {
    render(<Rank ranking={3} />);
    expect(
      document.getElementsByClassName('fa-solid fa-star star-on')
    ).toHaveLength(3);
    expect(
      document.getElementsByClassName('fa-solid fa-star star-off')
    ).toHaveLength(2);
  });
});
