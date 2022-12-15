import React from 'react';
import { Button, Heading } from '../atoms';

import InfoBanner from '../atoms/InfoBanner/InfoBanner';

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: 'DigitalBooking/InfoBanner',
  component: InfoBanner,
};

// More on component templates: https://storybook.js.org/docs/react/writing-stories/introduction#using-args
const Template = (args) => (
  <div style={{ width: '100%' }}>
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
    <InfoBanner {...args} />
  </div>
);

export const SuccessInfoBanner = Template.bind({});
SuccessInfoBanner.args = {
  children: (
    <>
      <i
        className="fa-regular fa-circle-check color-primary"
        style={{ fontSize: '75px' }}
      ></i>
      <Heading variant="h1" classname="color-primary">
        ¡Muchas gracias!
      </Heading>
      <Heading variant="h2" classname="color-secondary">
        Su reserva se ha realizado con éxito
      </Heading>
      <div style={{ width: '206px', marginTop: '15px' }}>
        <Button variant="b1">ok</Button>
      </div>
    </>
  ),
};

export const ErrorInfoBanner = Template.bind({});
ErrorInfoBanner.args = {
  children: (
    <>
      <i
        className="fa-solid fa-circle-exclamation color-dark-red"
        style={{ fontSize: '75px' }}
      ></i>
      <Heading variant="h1" classname="color-error">
        ¡Error!
      </Heading>
      <Heading variant="h2" classname="color-secondary">
        Intenta de nuevo
      </Heading>
      <div style={{ width: '206px', marginTop: '15px' }}>
        <Button variant="b1">ok</Button>
      </div>
    </>
  ),
};
