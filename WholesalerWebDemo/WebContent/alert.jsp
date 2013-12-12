<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<br>
<!-- ALERT ERROR -->
<div id="wrongFileType"></div>
<c:forEach var="error" items="${sessionScope.errorList}">
<jsp:useBean id="error" type="java.lang.String" />
<b><font color="Red"><div id="alertJsp"><%= error %></div></font></b><br>
</c:forEach>

<!-- ALERT SUCCESS -->
<% 
final String SESSION_ATTRIBUTE_IMPORT_SUCCESSFUL = "userFeedback";
if(session.getAttribute(SESSION_ATTRIBUTE_IMPORT_SUCCESSFUL) != null){
	String message = (String) session.getAttribute(SESSION_ATTRIBUTE_IMPORT_SUCCESSFUL);
	session.removeAttribute(SESSION_ATTRIBUTE_IMPORT_SUCCESSFUL);
	out.write("<div id='alertJsp'><b><font color='green'>"+ message +"</font></b><br><br></dic>");
}
%>




