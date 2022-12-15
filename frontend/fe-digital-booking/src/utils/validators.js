import { EMAIL_REGEX } from "./regex";

export const mandatoryValidator = (value) => [!value, "Campo obligatorio"];

export const emailValidator = (value) => {
  if (!EMAIL_REGEX.test(value)) {
    return [true, "Email inválido"];
  }
  return mandatoryValidator(value);
};

export const passwordValidator = (value) => {
  if (value.length < 6)
    return [true, "La contraseña debe tener minimo 6 caracteres"];
  return mandatoryValidator(value);
};
