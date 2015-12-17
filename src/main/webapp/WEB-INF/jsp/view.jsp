<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Information of ${student.name}</title>
        <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet"/> 
        <link rel="shortcut icon" href="<c:url value="/resources/icon/sms.png"/>"/>      
        <script src="<c:url value="/resources/js/jquery.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
        <script src="<c:url value="/resources/js/respond.min.js"/>"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h3 class="text-center text-danger">Information of ${student.name}</h3>
                
                <table class="table alert-info">
                    <tr>
                        <td>Name :</td>
                        <td>${student.name}</td>
                    </tr>
                    <tr>
                        <td>Roll :</td>
                        <td>${student.roll}</td>
                    </tr>
                    <tr>
                        <td>Email :</td>
                        <td>${student.email}</td>
                    </tr>
                    <tr>
                        <td>District :</td>
                        <td>${student.district}</td>
                    </tr>
                    <tr>
                        <td>Phone Number :</td>
                        <td>${student.phoneNumber}</td>
                    </tr>
                    <tr>
                        <td>CGPA :</td>
                        <td>${student.cgpa}</td>
                    </tr>
                    <tr>
                        <td>Blood Group :</td>
                        <td>${student.bloodGroup}</td>
                    </tr>
                    <tr>
                        <td>National ID :</td>
                        <td>${student.nid}</td>
                    </tr>
                </table>
            </div>
            <div class="row">
                <a class="btn btn-success" href="${pageContext.servletContext.contextPath}/index">Index</a>
            </div>
        </div>
    </body>
</html>