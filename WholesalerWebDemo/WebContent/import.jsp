<%@ page session="true" import="de.htwg_konstanz.ebus.framework.wholesaler.api.bo.*,de.htwg_konstanz.ebus.framework.wholesaler.api.boa.*,java.math.BigDecimal,de.htwg_konstanz.ebus.framework.wholesaler.vo.util.PriceUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>eBusiness Framework Demo - Import</title>
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<link rel="stylesheet" type="text/css" href="default.css">
</head>

<body>

<%@ include file="header.jsp" %>
<%@ include file="error.jsp" %>
<%@ include file="authentication.jsp" %>
<%@ include file="navigation.jspfragment" %>

<h1>Import Product Catalog</h1>

<form method="POST" enctype="multipart/form-data" action="<%= "controllerservlet?action=" + Constants.ACTION_IMPORT_SUPPLIER_PRODUCTS %>" >
File to upload: <input type="file" name="upfile"><br/>
  <input type="submit" value="Press"> to upload the file!
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
<td><%= product.getShortDescription() %></td> 
<td width="400px"><%= product.getLongDescription() %></td> 
</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>
