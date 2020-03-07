<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login - JSP page</title>
</head>
<body>

	<%
	String messageA = (String) request.getAttribute("messageA");
	if(messageA == null)
		messageA = "";
	String messageB = (String) request.getAttribute("messageB");
	if(messageB == null)
		messageB = "";
	if(session.getAttribute("a") == null)
		session.setAttribute("a", 0);
	if(session.getAttribute("b") == null)
		session.setAttribute("b", 0);
	if(session.getAttribute("rezultat") == null)
		session.setAttribute("rezultat", 0);
	%>


	<form action = "../WebServletMath/ServletMath" method="post">
		Prvi broj: <input type="text" value = "<%=session.getAttribute("a") %>" id="a" name="a" />
		<br/>
		<%=messageA %>
		<br/>
		Drugi broj: <input type="text" value = "<%=session.getAttribute("b") %>" id="b" name="b" />
		<br/>
		<%=messageB %>
		<br/>
		Rezultat:&nbsp;&nbsp;<%=session.getAttribute("rezultat") %>
		<br/>
		
		<input type = "submit" name = "operacija" value="plus"/>
		<input type = "submit" name = "operacija" value="minus"/>
	</form>
</body>
</html>