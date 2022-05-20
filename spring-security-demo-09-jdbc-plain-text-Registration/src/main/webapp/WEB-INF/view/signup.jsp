<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
    <title> Sign Up Page</title>
       <style>
        .error{
        color:red
        }
       </style>
    </head>

    <body>
    <h2>SignUP Page</h2>
    <form:form action="saveUser" method="POST" modelAttribute="user">

    <c:if test='${param.error!=null}'>
    <i class="error">Sorry! You entered invalid username/password</i><br><br>
    </c:if>

        User name:<input type="text" name="username"/>
        <br>
        <br>
        Password:<input type="password" name="password"/>
        <br><br>
        <input type="submit" value="save"/>
    </form:form>
    </body>
</html>