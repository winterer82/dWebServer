<html>
<link rel="stylesheet" href="CSS/dWebStyle.css">

<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>dWebTest</title>
</head>
<%
String id = (String)request.getAttribute("id"); // Post msg
if(id == null){
	id = "0";
}

%>

<script src="JS/jquery-3.3.1.js"></script>
<script src="JS/dWebScript.js"></script>

<body onload="btnClick(1)" class="shell">
	<form action="dWebController" method="post">  
	<input type="hidden" id="id" name="id" value="<%=id%>" />
	<div class="msgGroup">
		<div class="topBox">
			<textarea id='msg' class="textBox"></textarea>
		</div>
		<br class="clear">
		<div class="bottomBox BBL">
			<textarea id='remark' class="textBox"></textarea>
		</div>
		<div class="bottomBox BBR">
			<textarea id='memo' class="textBox"></textarea>
		</div>
	</div> <!-- // msgGroup-->
	<br class="clear">
	<div class="btnGroup">
		<span onclick="btnClick(0)"><img class="btnImg BBL" src="img/arrow_l.png"/></span>
		<span onclick="btnClick(1)"><img class="btnImg BBR" src="img/arrow_r.png"/></span>
	</div> <!-- // btnGroup-->
	</form>
</body>
</html>