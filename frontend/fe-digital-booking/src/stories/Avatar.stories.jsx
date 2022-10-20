import React from "react";

import Avatar from "../atoms/Avatar/Avatar";

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: "DigitalBooking/Avatar",
  component: Avatar,
};

// More on component templates: https://storybook.js.org/docs/react/writing-stories/introduction#using-args
const Template = (args) => (
  <div
    style={{
      backgroundColor: "grey",
      width: "100px",
      height: "100px",
      display: "flex",
      justifyContent: "center",
      alignItems: "center",
    }}
  >
    <Avatar {...args} />
  </div>
);

export const AvatarWith1Letter = Template.bind({});
AvatarWith1Letter.args = {
  username: "Felipe",
};

export const AvatarWith2Letters = Template.bind({});
AvatarWith2Letters.args = {
  username: "Felipe Monterrosa",
};
