<%@ page session="true"
	import="de.htwg_konstanz.ebus.framework.wholesaler.api.bo.*,de.htwg_konstanz.ebus.framework.wholesaler.api.boa.*,java.math.BigDecimal,de.htwg_konstanz.ebus.framework.wholesaler.vo.util.PriceUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>eBusiness Framework Demo - Export</title>
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<link rel="stylesheet" type="text/css" href="default.css">
</head>

<body>

	<%@ include file="header.jsp"%>
	<div id=""></div>
	<%@ include file="error.jsp"%>
	<%@ include file="authentication.jsp"%>
	<%@ include file="navigation.jspfragment"%>

	<h1>Export Product Catalog</h1>

	<form method="POST"	action="<%="controllerservlet?action="		+ Constants.ACTION_EXPORT_CUSTOMER_PRODUCTS%>">
		<input type="submit" value="Press" id="submit"> to export all
		products
	</form>
	<b>Datei lilegt hier:</b>
	<%=session.getAttribute("productFile")%>
	Muss noch ein download daraus gemacht werden....
</body>
</html>
