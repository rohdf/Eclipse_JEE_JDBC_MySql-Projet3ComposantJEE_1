<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@page import="com.nsis.bean.loginBean" %>
<%@page import="com.nsis.bean.ExceptionBean" %>

<style>
h1 {color:red;}
</style>
</head>
<body>

 <%
  // si l'utilisateur tape l'adresse de la page Bienvenue.jsp sans s'être logué auparavant, on affiche...
  if(request.getSession().getAttribute("user") == null){
   	ExceptionBean exception = (ExceptionBean) request.getSession().getAttribute("exception");
	  out.println("<h1>"+exception.getMessage()+"</h1>");
	  out.print("Vous n'êtes pas connecté. Cliquez <a href=\"index.html\">ici</a> pour vous authentifier");
   
   
  } else {
   // S'il s'est loggué, on affiche...
   loginBean currentUser = (loginBean) request.getSession().getAttribute("user");
   out.print(String.format("Bonjour visiteur ! Tu es connecté en tant que : %s", currentUser.getLogin()));
   out.print("<br />");
   out.print(String.format("Ton mot de passe est : %s", currentUser.getPassword()));
   out.print("<p><a href=\"LogoutServlet\">Déconnexion</a></p>");
  }
 %>

</body>
</html>