<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="views.add.title" /></title>
    </head>
    <body>
        <form:form action="save.htm" modelAttribute="UserVO">

            <label><fmt:message key="views.add.user.id"/></label>
            <form:input path="id"></form:input>
            <br />
            <label><fmt:message key="views.add.user.name"/></label>
            <form:input path="name"  ></form:input>
            <br />
            <label><fmt:message key="views.add.user.last_name"/></label>
            <form:input path="last_name"  ></form:input>
            <br />
            <input type="submit" value="Save" ></input>
        </form:form>

        <table border="1">
            <thead>
                <tr>
                    <th><fmt:message key="views.add.user.id" /></th>
                    <th><fmt:message key="views.add.user.name" /></th>
                    <th><fmt:message key="views.add.user.last_name" /></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="row" items="${users}">
                        <tr>
                        <td><c:out value="${row.id}" /></td>
                        <td><c:out value="${row.name}" /></td>
                        <td><c:out value="${row.last_name}"/></td>
                        </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
