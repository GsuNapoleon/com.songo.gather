/**
 * 
 */
function getPercent(num, total) {
	if (isNaN(num) || isNaN(total) || parseInt(total) <= 0) {
		return "N/A";
	}
	return (num * 100 / total).toFixed(2) + "%";
}