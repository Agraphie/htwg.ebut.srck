<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<br>
<div id="wrongFileType"></div>
<c:forEach var="error" items="${sessionScope.errorList}">
<jsp:useBean id="error" type="java.lang.String" />
<b><font color="Red"><div id="errorJsp"><%= error %></div></font></b><br><br>
</c:forEach>


