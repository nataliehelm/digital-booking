import React from "react";

import Heading from "../atoms/Heading/Heading";

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: "DigitalBooking/Heading",
  component: Heading,
};

// More on component templates: https://storybook.js.org/docs/react/writing-stories/introduction#using-args
const Template = (args) => <Heading {...args} />;

export const BasicHeading = Template.bind({});
BasicHeading.args = {
  variant: "h1",
  children: "Heading",
};
