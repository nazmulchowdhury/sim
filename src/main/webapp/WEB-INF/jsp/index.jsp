<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information Management</title>
        <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet"/> 
        <link rel="shortcut icon" href="<c:url value="/resources/icon/sms.png"/>"/>      
        <script src="<c:url value="/resources/js/jquery.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
        <script src="<c:url value="/resources/js/respond.min.js"/>"></script>
    </head>
    <body>        
        <div class="container">
            <div class="row">
                <h2 class="text-center text-info">Student Information Management</h2>
            </div>
            <div class="row">
                <p><a href="student" class="btn btn-success btn-lg">New Student Registration</a></p>
                <p><a href="student/list" class="btn btn-danger btn-lg">View Registered Students</a></p>
            </div>
        </div>
    </body>
</html>