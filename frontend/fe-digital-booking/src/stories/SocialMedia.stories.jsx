import React from 'react';

import SocialMedia from '../atoms/SocialMedia/SocialMedia';

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: 'DigitalBooking/SocialMedia',
  component: SocialMedia,
};

// More on component templates: https://storybook.js.org/docs/react/writing-stories/introduction#using-args
const Template = (args) => (
  <div style={{ width: '448px' }}>
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
    <SocialMedia {...args} />
  </div>
);

export const BasicSocialMedia = Template.bind({});
BasicSocialMedia.args = {
  socialTypes: ['facebook', 'whatsapp', 'mail', 'twitter'],
  url: '/products/1',
};
