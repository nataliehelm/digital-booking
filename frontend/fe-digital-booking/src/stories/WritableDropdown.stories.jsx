import React from 'react';

import WritableDropdown from '../atoms/WritableDropdown/WritableDropdown';

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: 'DigitalBooking/WritableDropdown',
  component: WritableDropdown,
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
      <WritableDropdown {...args} />
    </div>
  </>
);

export const BasicWritableDropdown = Template.bind({});
BasicWritableDropdown.args = {
  options: [
    {
      id: 1,
      icon: <i className="fa-solid fa-location-dot"></i>,
      title: 'San Carlos de Bariloche',
      description: 'Argentina',
    },
    {
      id: 2,
      icon: <i className="fa-solid fa-location-dot"></i>,
      title: 'Buenos Aires',
      description: 'Argentina',
    },
    {
      id: 3,
      icon: <i className="fa-solid fa-location-dot"></i>,
      title: 'Mendoza',
      description: 'Argentina',
    },
    {
      id: 4,
      icon: <i className="fa-solid fa-location-dot"></i>,
      title: 'Córdoba',
      description: 'Argentina',
    },
  ],
  onChange: console.log,
};
