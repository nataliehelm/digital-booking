import { useState } from "react";

const useInput = (initialValue, validator) => {
  const [value, setValue] = useState(initialValue);
  const [error, setError] = useState([false]);

  const handleChange = (event) => {
    setValue(event.target.value);
    setError(validator?.(event.target.value) || [false, ""]);
  };

  return {
    value,
    onChange: handleChange,
    hasError: error[0],
    errorMessage: error[1],
  };
};

export default useInput;
