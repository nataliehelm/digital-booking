import { render, screen, fireEvent } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import Drawer from './Drawer';

const mockedNavigate = jest.fn();

jest.mock('react-router-dom', () => ({
  ...jest.requireActual('react-router-dom'),
  useNavigate: () => mockedNavigate,
}));

describe('<Drawer />', () => {
  test("Should contain the 'MENÚ label", () => {
    render(
      <BrowserRouter>
        <Drawer setShowDrawer={() => jest.fn()} />
      </BrowserRouter>
    );
    expect(screen.getByText('MENÚ')).toBeInTheDocument();
  });

  test('Should render 4 links', () => {
    render(
      <BrowserRouter>
        <Drawer setShowDrawer={() => jest.fn()} />
      </BrowserRouter>
    );
    expect(screen.getAllByRole('link')).toHaveLength(4);
  });

  test("setShowDrawer should be called with 'false' value when <button /> is clicked", () => {
    const setShowDrawer = jest.fn();
    render(
      <BrowserRouter>
        <Drawer setShowDrawer={setShowDrawer} />
      </BrowserRouter>
    );
    const button = screen.getByRole('button');
    fireEvent.click(button);
    expect(setShowDrawer).toBeCalledWith(false);
  });

  test("Should render 'Felipe Monterrosa' when has username prop", () => {
    const setShowDrawer = jest.fn();
    render(
      <BrowserRouter>
        <Drawer setShowDrawer={setShowDrawer} username="Felipe Monterrosa" />
      </BrowserRouter>
    );
    expect(screen.getByText('Felipe Monterrosa')).toBeInTheDocument();
  });

  test('Should redirect to signup when signup is clicked', () => {
    jest.spyOn(Storage.prototype, 'setItem');
    Storage.prototype.setItem = jest.fn();
    const setShowDrawer = jest.fn();

    render(
      <BrowserRouter>
        <Drawer setShowDrawer={setShowDrawer} />
      </BrowserRouter>
    );

    const button = screen.getByText('Crear cuenta');
    fireEvent.click(button);

    expect(mockedNavigate).toHaveBeenCalledWith('/signup');
  });

  test('Should redirect to login when login is clicked', () => {
    jest.spyOn(Storage.prototype, 'setItem');
    Storage.prototype.setItem = jest.fn();
    const setShowDrawer = jest.fn();

    render(
      <BrowserRouter>
        <Drawer setShowDrawer={setShowDrawer} />
      </BrowserRouter>
    );

    const button = screen.getByText('Iniciar sesión');
    fireEvent.click(button);

    expect(mockedNavigate).toHaveBeenCalledWith('/login');
  });
});
