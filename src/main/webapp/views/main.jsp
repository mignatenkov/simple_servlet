<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Home Page</title>
</head>
<body>

<form action="main" method="post">
    <input type="text" name="new_line"><br>
    <input type="submit" /><br>
</form>

<c:forTokens items="${lines}" delims = "," var="line">
    ${line}<br>
</c:forTokens>

</body>
</html>