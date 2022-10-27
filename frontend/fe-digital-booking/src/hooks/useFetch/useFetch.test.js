import { renderHook, waitFor } from '@testing-library/react';
import useFetch from './useFetch';
import fetchMock from 'fetch-mock';
import 'whatwg-fetch';

describe('useFetch hook', () => {
  beforeAll(() => {
    global.fetch = fetch;
  });
  afterAll(() => {
    fetchMock.restore();
  });

  test('Should fetch a basic request', async () => {
    fetchMock.mock('https://localhost:8081/categories', {
      data: undefined,
    });
    const { result } = renderHook(() => useFetch('categories'));

    await waitFor(() => expect(result.current.isLoading).toBe(false));
  });

  test('Should fetch a basic error', async () => {
    fetchMock.mock('https://localhost:8081/locations', 500);
    const { result } = renderHook(() => useFetch('locations'));

    await waitFor(() => expect(result.current.isError).toBe(true));
  });
});
