import React from 'react';
import useInput from '../atoms/Input/hooks/useInput';

import Uploader from '../atoms/Uploader/Uploader';

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: 'DigitalBooking/Uploader',
  component: Uploader,
};

// More on component templates: https://storybook.js.org/docs/react/writing-stories/introduction#using-args
const Template = (args) => {
  const input = useInput(args.value || '');
  return (
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
      <Uploader
        {...args}
        value={input.value}
        onChange={input.onChange}
        hasError={input.hasError}
        errorMessage={input.errorMessage}
        disabled={!input.value}
      />
    </div>
  );
};

export const BasicUploader = Template.bind({});
BasicUploader.args = {
  placeholder: 'Insertar https://',
  value: '',
  onUpload: (value) => console.log('upload', value),
  onRemove: (value) => console.log('remove', value),
};
