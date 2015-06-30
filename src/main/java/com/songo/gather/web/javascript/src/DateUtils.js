/**
 * 
 */
function getWeekday(sDate) {
	var date = new Date(sDate.replace(/-/g, '/'));
	var a = [ '周日', '周一', '周二', '周三', '周四', '周五', '周六' ];
	return a[date.getDay()];
}