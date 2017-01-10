function onLoad(rowId, columnId, value) {
	var id = rowId.toString() + columnId.toString();
	var cell = document.getElementById(id);
	cell.innerHTML = value;
}
$(document).ready()
