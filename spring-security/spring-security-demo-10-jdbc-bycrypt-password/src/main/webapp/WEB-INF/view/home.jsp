<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>

	<h2>luv2code Company Home Page</h2>

    <p>
        User : <security:authentication property="principal.username" />
        <br><br>
        Role(s) : <security:authentication property="principal.authorities" />
    </p>
    <hr>

    <!-- Add link to Leader this is for Managers -->

    <security:authorize access="hasRole('MANAGER')">
        <p>
            <a href="${pageContext.request.contextPath}/leaders">
            LeaderShip Meeting </a>
            Only for Manager)
        </p>
    </security:authorize>

    <!-- Add link to Systems this is for Admins -->
    <security:authorize access="hasRole('ADMIN')" >
        <p>
            <a href="${pageContext.request.contextPath}/systems">
            IT Systems Meeting </a>
            (Only for Admins)
        </p>
     </security:authorize>




    <br><br>
	Welcome to the luv2code company home page!
    <br><br>


    <form:form action="${pageContext.request.contextPath}/logout"
        method="POST">

            <input type="submit" value="Logout" />

    </form:form>


</body>

</html>