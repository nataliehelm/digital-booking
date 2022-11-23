import PropTypes from 'prop-types';

const PaginatorItem = ({ children, onClick, disabled }) => {
  return (
    <button
      onClick={() => onClick(Number(children))}
      style={{
        cursor: 'pointer',
        width: '20px',
        height: '20px',
        padding: '20px',
        border: '1px solid black',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        borderRadius: '5px',
      }}
      disabled={disabled}
    >
      {children}
    </button>
  );
};

PaginatorItem.propTypes = {
  children: PropTypes.element.isRequired,
  onClick: PropTypes.func.isRequired,
  disabled: PropTypes.bool.isRequired,
};

export default PaginatorItem;
