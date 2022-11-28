import PropTypes from 'prop-types';
import PaginatorItem from './components/PaginatorItem/PaginatorItem';
import styles from './Paginator.module.scss';

const Paginator = ({
  currentPage,
  onClick,
  isFirstPage,
  isLastPage,
  displayPages,
}) => {
  const pagesGap = currentPage > displayPages ? currentPage - displayPages : 0;

  return (
    <div className={styles['paginator-container']}>
      <PaginatorItem
        onClick={() => onClick(currentPage - 1)}
        disabled={isFirstPage}
      >
        <i className="fa-solid fa-circle-chevron-left" />
      </PaginatorItem>

      {[...Array(displayPages).keys()].map((page) => {
        const _page = page + 1 + pagesGap;
        return (
          <PaginatorItem
            key={`page-${page + 1}`}
            onClick={onClick}
            isCurrent={currentPage === _page}
          >
            {_page}
          </PaginatorItem>
        );
      })}

      <PaginatorItem
        onClick={() => onClick(currentPage + 1)}
        disabled={isLastPage}
      >
        <i className="fa-solid fa-circle-chevron-right" />
      </PaginatorItem>
    </div>
  );
};

Paginator.propTypes = {
  currentPage: PropTypes.number.isRequired,
  onClick: PropTypes.func.isRequired,
  totalPages: PropTypes.number,
  numberOfElements: PropTypes.number,
  totalElements: PropTypes.number,
  isFirstPage: PropTypes.bool.isRequired,
  isLastPage: PropTypes.bool.isRequired,
  displayPages: PropTypes.number.isRequired,
};

export default Paginator;
