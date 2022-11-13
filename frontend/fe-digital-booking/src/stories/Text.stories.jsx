import React from 'react';

import Text from '../atoms/Text/Text';

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: 'DigitalBooking/Text',
  component: Text,
};

// More on component templates: https://storybook.js.org/docs/react/writing-stories/introduction#using-args
const Template = (args) => <Text {...args} />;

export const BasicText = Template.bind({});
BasicText.args = {
  variant: 't1',
  children: 'Text',
};
