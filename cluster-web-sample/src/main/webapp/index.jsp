<%@ page language="java" session="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<html>
<head>
    <title>Cluster Web Sample: Setting values in Session</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script type="text/javascript" src="js/functions.js"></script>
</head>
<body>
<center>
    <table border="1">
    <tr>
      <td><img src="img/rh1.jpg"/></td>
      <td><img src="img/rh2.jpg"/></td>
    </tr>
    </table>
  
    <h1>Session Test App: Setting Values</h1>
    
    <%
         session.setAttribute("SessionKey", "SessionKeyValue Set at " + new java.util.Date());
         System.out.println("index.jsp setAttribute() called on Session with value = " + (String) session.getAttribute("SessionKey"));
    %>
   	<h2>Attribute "SessionKey" is set in the HttpSession</h2>
    <code>session.getId() = <%= session.getId() %></code>  
    <br/>
    <code>session.getAttribute("SessionKey") = <%=session.getAttribute("SessionKey") %></code>
    <br/><br/>
   	<a href="sessionCheck.jsp">Click Here to move to nextPage sessionCheck.jsp</a>
</center>
<br/><br/>
<b><font color="red">NOTE:</font></b> Please check the value of HttpSession Attribute which displays the timestamp when the attribute was created & set inside the HttpSession.
 Which is useful to check whether it's a new HttpSession with new Attribute or the replicated HttpSession with the same attribute.
<br/>
As many times you will refresh the "index.jsp" page a new HttpSession attribute will be added with current TimeStamp.
<br/><br/>
<a href="" onclick="showAlert('Testing JavaScript')">Click here to test JavaScript Functions</a>

</body>
</html>
