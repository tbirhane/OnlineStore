<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/mycss.css">
</head>
<body>
<div id="login-container"></div>
<%
    Cookie[] cookies=request.getCookies();
    String userName = "";
    String rememberme = "";
    String message = "";
    if(session.getAttribute("msg") != null)
     message = (String)session.getAttribute("msg");
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("user-name")) {
                userName = cookie.getValue();
            }
            if(cookie.getName().equals("checkbox")) {
                if (cookie.getValue() == null)
                    rememberme = "";
                else
                    rememberme = "checked";
            }


        }
    }
%>
<h3>Well come</h3>
<%=request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%>

<form action="<%=request.getContextPath()%>/login" method="post">

    <p>
        <label> user name: <input class="login-input" type="text" name="user-name" value="<%=userName%>" size="20" maxlength="25"></label>
    </p>
    <p>
        <label> password: <input class="login-input" type="password" name="password" size="20" maxlength="25"></label>
    </p>

    <input class="btn btn-info" type="submit" value="login">

    <label> remember me: </label><input type="checkbox" name="checkbox" <%=rememberme%> >
    <p style="color: red"><%=message%></p>
</form>
</div>
</body>
</html>
