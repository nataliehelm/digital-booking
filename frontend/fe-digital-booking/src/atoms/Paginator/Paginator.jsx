import PropTypes from 'prop-types';
import PaginatorItem from './components/PaginatorItem/PaginatorItem';

const Paginator = ({
  currentPage,
  onClick,
  totalPages,
  itemsPerPage,
  isFirstPage,
  isLastPage,
}) => {
  return (
    <div style={{ display: 'flex', gap: '5px' }}>
      <PaginatorItem
        onClick={() => onClick(currentPage - 1)}
        disabled={isFirstPage}
      >
        <i
          className="fa-solid fa-circle-chevron-left"
          style={{ cursor: 'pointer' }}
        />
      </PaginatorItem>
      {pages.map((p) => (
        <PaginatorItem onClick={onClick}>{p}</PaginatorItem>
      ))}
      <PaginatorItem
        onClick={() => onClick(currentPage + 1)}
        disabled={isLastPage}
      >
        <i
          className="fa-solid fa-circle-chevron-right"
          style={{ cursor: 'pointer' }}
        />
      </PaginatorItem>
    </div>
  );
};

Paginator.propTypes = {
  currentPage: PropTypes.number.isRequired,
  onClick: PropTypes.func.isRequired,
  totalPages: PropTypes.number.isRequired,
  itemsPerPage: PropTypes.number.isRequired,
  isFirstPage: PropTypes.bool.isRequired,
  isLastPage: PropTypes.bool.isRequired,
};

export default Paginator;
