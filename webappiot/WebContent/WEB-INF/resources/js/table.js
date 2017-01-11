function onLoad(rowId, columnId, value, evaluation) {
	var id = rowId.toString() + columnId.toString();
	$("#" + id).html(value);
	
	if(evaluation == 'Danger'){
		$("#" + id).addClass("danger");
	}
	else if(evaluation == 'Warning'){
		$("#" + id).addClass("warning");
	}
	else if(evaluation == 'Normal'){
		$("#" + id).addClass("success");
	}
}
$(document).ready()
