import React from 'react';

import Dropdown from '../atoms/Dropdown/Dropdown';

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: 'DigitalBooking/Dropdown',
  component: Dropdown,
};

// More on component templates: https://storybook.js.org/docs/react/writing-stories/introduction#using-args
const Template = (args) => (
  <>
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
    <div style={{ width: '300px' }}>
      <Dropdown {...args} />
    </div>
  </>
);

export const BasicDropdown = Template.bind({});
BasicDropdown.args = {
  options: [
    {
      id: 1,
      title: '01:00 AM',
    },
    {
      id: 2,
      title: '02:00 AM',
    },
    {
      id: 3,
      title: '03:00 AM',
    },
    {
      id: 4,
      title: '04:00 AM',
    },
    {
      id: 5,
      title: '05:00 AM',
    },
    {
      id: 6,
      title: '06:00 AM',
    },
    {
      id: 7,
      title: '07:00 AM',
    },
    {
      id: 8,
      title: '08:00 AM',
    },
    {
      id: 9,
      title: '09:00 AM',
    },
    {
      id: 10,
      title: '10:00 AM',
    },
    {
      id: 11,
      title: '11:00 AM',
    },
    {
      id: 12,
      title: '12:00 AM',
    },
    {
      id: 13,
      title: '01:00 PM',
    },
    {
      id: 14,
      title: '02:00 PM',
    },
    {
      id: 15,
      title: '03:00 PM',
    },
    {
      id: 16,
      title: '04:00 PM',
    },
    {
      id: 17,
      title: '05:00 PM',
    },
    {
      id: 18,
      title: '06:00 PM',
    },
    {
      id: 19,
      title: '07:00 PM',
    },
    {
      id: 20,
      title: '08:00 PM',
    },
    {
      id: 21,
      title: '09:00 PM',
    },
    {
      id: 22,
      title: '10:00 PM',
    },
    {
      id: 23,
      title: '11:00 PM',
    },
    {
      id: 24,
      title: '12:00 PM',
    },
  ],
  onChange: console.log,
};
