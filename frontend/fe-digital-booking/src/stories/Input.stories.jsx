import React from "react";
import useInput from "../atoms/Input/hooks/useInput";

import Input from "../atoms/Input/Input";

// More on default export: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
export default {
  title: "DigitalBooking/Input",
  component: Input,
};

// More on component templates: https://storybook.js.org/docs/react/writing-stories/introduction#using-args
const Template = (args) => {
  const input = useInput(args.value || "");
  return (
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
      <Input {...args} value={input.value} onChange={input.onChange} />
    </>
  );
};

const ErrorTemplate = (args) => {
  const validator = (value) => [!value, "Campo obligatorio"];
  const input = useInput(args.value || "", validator);
  return (
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
      <Input
        {...args}
        value={input.value}
        onChange={input.onChange}
        hasError={input.hasError}
        errorMessage={input.errorMessage}
      />
    </>
  );
};

export const BasicInput = Template.bind({});
BasicInput.args = {
  name: "basic-input",
};

export const InputWithPlaceholder = Template.bind({});
InputWithPlaceholder.args = {
  name: "basic-input",
  placeholder: "¿A dónde vamos?",
};

export const InputWithPlaceholderAndIcon = Template.bind({});
InputWithPlaceholderAndIcon.args = {
  name: "basic-input",
  placeholder: "¿A dónde vamos?",
  placeholderIcon: <i className="fa-solid fa-calendar"></i>,
};

export const InputWithLabel = Template.bind({});
InputWithLabel.args = {
  name: "basic-input",
  placeholder: "¿A dónde vamos?",
  value: "nombre",
  label: "Nombre",
};

export const PasswordInput = Template.bind({});
PasswordInput.args = {
  name: "basic-input",
  value: "contraseña",
  label: "Input Contraseña",
  type: "password",
};

export const ErrorInput = ErrorTemplate.bind({});
ErrorInput.args = {
  name: "basic-input",
  value: "∂",
  label: "Error Input",
  hasError: true,
};

export const ErrorInputWithCustomMessage = ErrorTemplate.bind({});
ErrorInputWithCustomMessage.args = {
  name: "basic-input",
  value: "",
  label: "Error Input",
  hasError: true,
  errorMessage: "Este campo es obligatorio",
};
