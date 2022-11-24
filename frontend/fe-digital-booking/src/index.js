import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { BrowserRouter } from 'react-router-dom';
import { AuthProvider } from './providers/AuthProvider';
import { ErrorBoundary } from 'react-error-boundary';
import './index.scss';
import './react-date-range-styles.scss'; // main style file react-date-range
import './react-date-range-default-theme.scss'; // theme css file react-date-range
import Error from './components/Error';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <ErrorBoundary FallbackComponent={Error} onReset={() => {}}>
        <AuthProvider>
          <App />
        </AuthProvider>
      </ErrorBoundary>
    </BrowserRouter>
  </React.StrictMode>
);
