<%@ page session="true"
	import="de.htwg_konstanz.ebus.framework.wholesaler.api.bo.*,de.htwg_konstanz.ebus.framework.wholesaler.api.boa.*,java.math.BigDecimal,de.htwg_konstanz.ebus.framework.wholesaler.vo.util.PriceUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>eBusiness Framework Demo - Import</title>
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<link rel="stylesheet" type="text/css" href="default.css">
<script>
	function buttonEnable(ev) {
		document.getElementById("submit").disabled = true;
		if (ev.value) {
			var fehlerMeldung = document.getElementById("fehlerMeldung");
			if (fehlerMeldung != null) {
				document.getElementById("fehlerMeldung").remove();
			}
			var fileName = ev.value;
			var res = fileName.substr(fileName.lastIndexOf('.')) == '.xml';
			if (res) {
				document.getElementById("submit").disabled = false;
			} else {
				document.body.innerHTML += '<div id="fehlerMeldung"> Datei ist keine XML Datei!</div>';
			}
		}
	}
</script>
</head>

<body>

	<%@ include file="header.jsp"%>
	<div id=""></div>
	<%@ include file="error.jsp"%>
	<%@ include file="authentication.jsp"%>
	<%@ include file="navigation.jspfragment"%>

	<h1>Import Product Catalog</h1>

	<form method="POST"	enctype="multipart/form-data" action="<%= response.encodeURL("controllerservlet?action=importSupplierProducts") %> ">
		<input type="hidden" name="action" value="importSupplierProducts">
		File to upload: <input type="file" name="upfile" id="upfile" onChange="buttonEnable(this)"><br /> 
		<input type="submit" value="Press" id="submit" disabled> to upload the file!
	</form>

	<table class="dataTable">
		<thead>
			<tr>
				<th><b>Title</b></th>
				<th><b>Description</b></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${sessionScope.productList}">
				<jsp:useBean id="product" type="de.htwg_konstanz.ebus.framework.wholesaler.api.bo.BOProduct" />
				<tr valign="top">
					<td><%= product.getShortDescriptionCustomer() %></td>
					<td width="400px"><%= product.getLongDescriptionCustomer() %></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
