
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<body>

    <form:form action="processForm" modelAttribute="student" >

        First Name :<form:input path="firstName" />
        <br><br>
        Last Name :<form:input path="lastName" />
        <br><br>

        Country:
        <form:select path="country">

            <form:options items="${student.countryOptions}" />

        </form:select>

        <br> <br>

        Favourite Language :
        Java <form:radiobutton path="favouriteLanguage" value="Java" />
        Kotlin <form:radiobutton path="favouriteLanguage" value="Kotlin" />
        PHP <form:radiobutton path="favouriteLanguage" value="PHP" />
        Ruby <form:radiobutton path="favouriteLanguage" value="Ruby" />
       <br> <br>

       Familiar OS :
               Windows <form:checkbox path="familiarOS" value="Windows" />
               Mac<form:checkbox path="familiarOS" value="Mac" />
               Linux <form:checkbox path="familiarOS" value="Linux" />


       <br> <br>

        <input type="submit" value="Submit" />

    </form:form>

</body>

</html>