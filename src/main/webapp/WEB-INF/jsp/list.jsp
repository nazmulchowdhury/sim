<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registered Students Information</title>
        <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet"/>
        <link rel="shortcut icon" href="<c:url value="/resources/icon/sms.png"/>"/>     
        <script src="<c:url value="/resources/js/jquery.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
        <script src="<c:url value="/resources/js/respond.min.js"/>"></script>
    </head>
    <body>
        <div class="container">

            <div class="row">
                <h3 class="text-center text-danger">Registered Students Information</h3>
                <p class="text-success">${message}</p>
                <table class="table alert-info table-striped">
                    <th>Name</th>
                    <th>Roll</th>
                    <th>Email</th>
                    <th>District</th>
                    <th>Phone Number</th>
                    <th>CGPA</th>
                    <th>Blood Group</th>
                    <th>National ID</th>
                    <th></th>
                    <th></th>
                    <th></th>
                        <c:if test="${not empty students}">
                            <c:forEach var="student" items="${students}">
                            <tr>
                                <td><c:out value="${student.name}"/></td>
                                <td><c:out value="${student.roll}"/></td>
                                <td><c:out value="${student.email}"/></td>
                                <td><c:out value="${student.district}"/></td>
                                <td><c:out value="${student.phoneNumber}"/></td>
                                <td><c:out value="${student.cgpa}"/></td>
                                <td><c:out value="${student.bloodGroup}"/></td>
                                <td><c:out value="${student.nid}"/></td>
                                <td>
                                    <a class="btn btn-info btn-sm" href="<c:url value='/student/${student.id}'/>">View</a>
                                </td>                            
                                <td>
                                    <form method="post" action="<c:url value='/student/${student.id}'/>">
                                        <input type="hidden" name="id" value="<c:out value="${student.id}"/>"/>
                                        <input type="submit" class="btn btn-warning btn-sm" value="Edit"/>
                                    </form>
                                </td>
                                <td>
                                    <form method="post" action="<c:url value='/student'/>">
                                        <input type="hidden" name="id" value="<c:out value="${student.id}"/>"/>
                                        <input type="submit" class="btn btn-danger btn-sm" value="Delete"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>
            </div>
            <div class="row">
                <a class="btn btn-success" href="${pageContext.servletContext.contextPath}/index">Index</a>
            </div>
        </div>
    </body>
</html>