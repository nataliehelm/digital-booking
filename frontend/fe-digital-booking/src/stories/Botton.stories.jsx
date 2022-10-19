import React from "react";

import Botton from "../atoms/Botton/Botton";

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: "DigitalBooking/Botton",
  component: Botton,
};

// More on component templates: https://storybook.js.org/docs/react/writing-stories/introduction#using-args
const Template = (args) => <Botton {...args} />;

export const BasicBotton = Template.bind({});
BasicBotton.args = {
  variant: "b1",
  children: "Botton",
};
