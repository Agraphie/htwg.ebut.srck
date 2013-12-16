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
	<%@ include file="alert.jsp"%>
	<%@ include file="authentication.jsp"%>
	<%@ include file="navigation.jspfragment"%>

	<h1>Export Product Catalog</h1>

	<form method="POST"	action="<%= response.encodeURL("controllerservlet") %> ">
		<input type="hidden" name="action" value="exportCustomerProducts">
			<p>Export by Short-Description(optional): <input type="text" name="filter"></p>
			<h3>Select export format</h3>
			<p><label><input type="radio" value="formatBMEcat" name="exportFormat" checked="checked">BMEcat</label></p>
			<p><label><input type="radio" value="formatXhtml" name="exportFormat">XHTML</p></label>
			<p><input type="submit" name="Submit" value="export"></p>

	</form>
	<% File file = (File) session.getAttribute("file"); 
		if(file != null){
			//we got the file, now delete the reference so this event won't trigger again. m'kay?
			request.getSession(true).setAttribute("file", null);

			String filePath = file.getAbsolutePath();
			int length   = 0;
	        ServletOutputStream outStream;
			try {
				outStream = (ServletOutputStream) session.getAttribute("out");
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
		       	outStream.flush();
				outStream.close();
		        file.delete();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	%>
</body>
</html>
