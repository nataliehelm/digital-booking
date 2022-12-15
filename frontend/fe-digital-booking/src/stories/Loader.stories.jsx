import React from 'react';

import Loader from '../components/Loader';

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: 'DigitalBooking/Loader',
  component: Loader,
};

// More on component templates: https://storybook.js.org/docs/react/writing-stories/introduction#using-args
const Template = (args) => (
  <div
    style={{
      backgroundColor: 'rgba(56, 59, 88, 0.1)',
      width: '100vw',
      height: '100vh',
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'center',
    }}
  >
    <Loader {...args} />
  </div>
);

export const BasicLoader = Template.bind({});
BasicLoader.args = {};
