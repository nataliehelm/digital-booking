import { render, screen } from '@testing-library/react';
import Layout from './Layout';

describe('<Layout />', () => {
  test('should renderize the main container of the website', () => {
    render(
      <Layout>
        <h1>This is the children</h1>
      </Layout>
    );
    expect(screen.getByRole('heading').tagName).toBe('H1');
  });
});
