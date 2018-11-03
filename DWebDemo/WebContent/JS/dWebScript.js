function btnClick(ptr){
	var id = parseInt(document.getElementById("id").value);
	if(ptr == 0){
		id=id-1; // Prev page clicked
	} else {
		id=id+1; // Next Page Clicked
	}
	//alert(id);
	sendAjax(id);
}

function sendAjax(id) {
    $.ajax({
        url: "dWebController",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(id),
        contentType: 'application/json',
        mimeType: 'application/json',
 
        success: function (data) {
            if(data.id === undefined){
            	alert("No Data");
            } else {
            	//alert("passed: "+data.id);
            	document.getElementById("id").value = data.id;
            	document.getElementById("msg").innerHTML = data.msg;
            	document.getElementById("remark").innerHTML = data.remark;
            	document.getElementById("memo").innerHTML = data.memo;
            	//document.getElementById("memo").value = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\r\naaaaaa\r\naaaaaaaaaaaaaaaaaaaaaaaaaa\r\naaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\r\naaaaaaaaaaaaaaaaaaaaa\r\naaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\r\naaaaaaaaa\r\naaaaaaaaaaaaa\r\naaaaa";            	
            }
        },
        error:function(data,status,er) {
            alert("error: "+data+" status: "+status+" er:"+er);
        }
    });
}