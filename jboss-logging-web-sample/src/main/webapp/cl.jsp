<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String cl = request.getParameter("cl");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ClassLoader Tester</title>
<style>
body {
	font-family: sans-serif;
	background-color: #ffd2d2;
}

.impar {
	background-color: #CC0000;
	color: white;
}

.par {
	background-color: #781F1C;
	color: white;
}

.letratecnica {
	font-family: monospace;
	text-align: center;
	font-size: 1.5em;
}
</style>
</head>
<body>
	<div
		style="width: 80%; margin-left: auto; margin-right: auto; text-align: center;">
		<h3>How is my WAR loading classes?</h3>
		<form action="cl.jsp">
			Full class name: <input type="text" name="cl"><br>
			<br> <input type="submit" value="ask it">
		</form>
	</div>
	<%
		if (cl != null && !cl.equals("")) {
			Class clase = null;
			ClassLoader clLoader = null;
			String literalClase = "";
			String literalClassLoader = "";
			String literalLocation = "";
			try {
				clase = Class.forName(cl);
				clLoader = clase.getClassLoader();
				if (clLoader == null) {
					literalClassLoader = "Null ClassLoader . Probably it is the BootStrap ClassLoader ";
				} else {
					literalClassLoader = clLoader.toString();
				}

				if (clase.getProtectionDomain() != null
						&& clase.getProtectionDomain().getCodeSource() != null) {
					literalLocation = clase.getProtectionDomain()
							.getCodeSource().getLocation().toString();
				}
				literalClase = clase.getName();
			} catch (ClassNotFoundException cnfe) {
				//literalClase = " Clase no encontrada.";
				literalClase = " Class not found in WAR classloader.";
			} catch (SecurityException se) {
				//literalClassLoader = "El SecutityManager no deja acceder a ese ClassLoader ";
				literalClassLoader = "Java secutity manager does not allow to access that ClassLoader ";
			}
	%>
	<br>
	<br>
	<div style="width: 50%; margin-left: auto; margin-right: auto;">
		<table>
			<tr class="impar">
				<td><b>Class Name:</b></td>
				<td class="letratecnica"><%=literalClase%></td>
			</tr>
			<tr class="par">
				<td><b>ClassLoader:</b></td>
				<td class="letratecnica"><%=literalClassLoader%></td>
			</tr>
			<tr class="impar">
				<td><b>Location:</b></td>
				<td class="letratecnica"><%=literalLocation%></td>
			</tr>
		</table>
	</div>

	<%
		}
	%>
	<pre style="text-align: center;">

MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMMWNNNNNNWNNXXXXXNWMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMMNK00000000000KNNX0XWMMMMMMMMMMMMMMMM
MMMMMMMMMMMMMWK0XKK0KK000000KK000KWMMMMMMMMMMMMMMM
MMMMMMMMMMMMMN00XWWNNXX00000000000KWMMMMMMMMMMMMMM
MMMMMMMMWWWWWN000000000000000000000XMMMMMMMMMMMMMM
MMMMMNKK0000XWNXK0000000000000000000NMMMMMMMMMMMMM
MMMMW00000000NWMMWWNNXXK000000000000XNNWWMMMMMMMMM
MMMMMX000000000KNWWMMMMMN00000000000K0000KNMMMMMMM
MMMMMMWX00000000000KKXNNWX00000000000000000XMMMMMM
MMMMMMMMWNK00000000000000000000000000000000XWMMMMM
MMMMMMMMMMWKO0K000000000000000000000000000KWMMMMMM
MMMMMMMMMWd. .dNNXXK00000000000000000000KNWMMMMMMM
MMMMMMWNNW0'   ..;0WWWNNXXKKKKKKKKKKXNWWMMMMMMMMMM
Odooc;...cKNd.     ,d0KK0Okk0Okk000WMMMMMMMMMMMMMM
,          ..                     dWMMMMMMMMMMMMMM
O.                       cxkx:   .KMMMWWNNNWMMMMMM
M0.                        .    '0WWK;..   ..lMMMM
MM0,                           lX0c.        ,0MMMM
MMMM0;                        cd:         ;0MMMMMM
MMMMMM0;                                ;0MMMMMMMM
MMMMMMMMK:.                          .:KMMMMMMMMMM
MMMMMMMMMMMxc.                    .cxMMMMMMMMMMMMM


</pre>
</body>
</html>
