<%@ page session="true"
	import="de.htwg_konstanz.ebus.framework.wholesaler.api.bo.*,de.htwg_konstanz.ebus.framework.wholesaler.api.boa.*,java.math.BigDecimal,de.htwg_konstanz.ebus.framework.wholesaler.vo.util.PriceUtil, java.io.File, java.io.DataInputStream, java.io.FileInputStream, java.io.IOException"%>
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

	<form method="POST"	action="<%= response.encodeURL("controllerservlet") %> ">
		<input type="hidden" name="action" value="exportCustomerProducts">
		<input type="text" name="filter">
		<input type="submit" name="Submit" value="export">
		
		<!-- <input type="submit" value="Press" id="submit"> to export all 
		products -->
	</form>
	<% File file = (File) session.getAttribute("file"); 
		if(file != null){
			String filePath = file.getAbsolutePath();
			int length   = 0;
	        ServletOutputStream outStream;
			try {
				outStream = response.getOutputStream();
				ServletContext context = request.getSession().getServletContext();
		        String mimetype = context.getMimeType(filePath);
		       
		        // sets response content type
		        if (mimetype == null) {
		            mimetype = "application/octet-stream";
		        }
		        response.setContentType(mimetype);
		        response.setContentLength((int)file.length());
		        String fileName = (new File(filePath)).getName();
		       
		        // sets HTTP header
		        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		       
		        byte[] byteBuffer = new byte[4096];
		        DataInputStream in = new DataInputStream(new FileInputStream(file));
		       
		        // reads the file's bytes and writes them to the response stream
		        while ((in != null) && ((length = in.read(byteBuffer)) != -1))
		        {
		            outStream.write(byteBuffer,0,length);
		        }
		       
		        in.close();
		        //response is already sent, therefor can't redirect anymore!
				outStream.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	%>
</body>
</html>
