import React from 'react';

import Toast from '../atoms/Toast/Toast';

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: 'DigitalBooking/Toast',
  component: Toast,
};

// More on component templates: https://storybook.js.org/docs/react/writing-stories/introduction#using-args
const Template = (args) => (
  <div style={{ width: '448px' }}>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
      integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
      crossOrigin="anonymous"
      referrerPolicy="no-referrer"
    />
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/js/all.min.js"
      integrity="sha512-naukR7I+Nk6gp7p5TMA4ycgfxaZBJ7MO5iC3Fp6ySQyKFHOGfpkSZkYVWV5R7u7cfAicxanwYQ5D1e17EfJcMA=="
      crossOrigin="anonymous"
      referrerPolicy="no-referrer"
    ></script>
    <Toast {...args} />
  </div>
);

export const SuccessToast = Template.bind({});
SuccessToast.args = {
  variant: 'success',
  label: 'Petición correcta',
};

export const ErrorToast = Template.bind({});
ErrorToast.args = {
  variant: 'error',
  label: 'Para realizar una reserva necesitas estar logueado',
};

export const ClosableToast = Template.bind({});
ErrorToast.args = {
  variant: 'error',
  label: 'Para realizar una reserva necesitas estar logueado',
  isClosable: true,
};
