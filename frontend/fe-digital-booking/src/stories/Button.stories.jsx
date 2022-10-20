import React from "react";

import Button from "../atoms/Button/Button";

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: "DigitalBooking/Button",
  component: Button,
};

// More on component templates: https://storybook.js.org/docs/react/writing-stories/introduction#using-args
const Template = (args) => <Button {...args} />;

export const BasicButton = Template.bind({});
BasicButton.args = {
  variant: "b1",
  children: "Button",
};
