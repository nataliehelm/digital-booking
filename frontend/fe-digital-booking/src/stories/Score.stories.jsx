import React from 'react';

import Score from '../atoms/Score/Score';

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: 'DigitalBooking/Score',
  component: Score,
};

// More on component templates: https://storybook.js.org/docs/react/writing-stories/introduction#using-args
const Template = (args) => <Score {...args} />;

export const BasicScore = Template.bind({});
BasicScore.args = {
  score: 8,
};
