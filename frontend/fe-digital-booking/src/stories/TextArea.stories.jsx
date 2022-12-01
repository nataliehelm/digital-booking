import React from 'react';
import useInput from '../atoms/Input/hooks/useInput';

import TextArea from '../atoms/TextArea/TextArea';
import { mandatoryValidator } from '../utils/validators';

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: 'DigitalBooking/TextArea',
  component: TextArea,
};

// More on component templates: https://storybook.js.org/docs/react/writing-stories/introduction#using-args
const Template = (args) => {
  const textArea = useInput('', mandatoryValidator);
  return <TextArea {...args} {...textArea} />;
};

export const BasicTextArea = Template.bind({});
BasicTextArea.args = {
  variant: 't1',
  placeholder: 'Test',
};
