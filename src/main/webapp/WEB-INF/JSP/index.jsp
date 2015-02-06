<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='s' uri='http://www.springframework.org/tags' %>
<!doctype html>
<html lang='nl'>
<head>Welcome</head>
<body>
<h1>${client.name}</h1>
<a href="${s:mvcUrl('IC#viaHyperlink').arg(0,client).build()}">Click me</a>
<%--
line 8 generates an IllegalArgumenException:
The source to convert from must be an instance of long; instead it was a be.vdab.entities.Client
 --%>
</body>
</html>