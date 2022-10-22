
const useLayoutDimension = () => {

	const header = document.getElementById("header")
	const headerHeight = header?.offsetHeight || 0
	const fullHeight = `calc(100vh - ${headerHeight}px)`

	return {
		fullHeight, headerHeight: headerHeight + "px"
	}

}

export default useLayoutDimension
