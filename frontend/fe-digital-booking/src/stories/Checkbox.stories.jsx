import React from 'react';
import { useState } from 'react';
import Checkbox from '../atoms/Checkbox/Checkbox';

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: 'DigitalBooking/Checkbox',
  component: Checkbox,
};

// More on component templates: https://storybook.js.org/docs/react/writing-stories/introduction#using-args
const Template = (args) => {
  const [isChecked, setIsChecked] = useState(false);
  const onChange = (id) => {
    setIsChecked(!isChecked);
  };

  return <Checkbox {...args} onChange={onChange} isChecked={isChecked} />;
};

export const BasicCheckbox = Template.bind({});
BasicCheckbox.args = {
  id: 1,
  name: 'checkbox',
  value: 'checkbox',
  label: 'checkbox',
};
