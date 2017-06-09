<%--<jsp:useBean id="converted_temp" scope="request" type="java.lang.String"/>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Conversion: ${converted_temp} <br/><br/>
<%= request.getAttribute("converted_temp") %>.
<form method="post" action="">
    From-to: <select name="type">
        <option value="cel2fahr">Cel to Fahr</option>
        <option value="fahr2cel">Fahr to Cel</option>
    </select><br/>
    Temp: <input type="text" name="temp"/><br/>

    <input type="submit" value="Convert">
</form>

</body>
</html>
