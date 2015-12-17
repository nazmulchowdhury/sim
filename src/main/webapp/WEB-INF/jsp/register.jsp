<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="springForm" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Information Registration</title>
        <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet"/>
        <link rel="shortcut icon" href="<c:url value="/resources/icon/sms.png"/>"/>
        <script src="<c:url value="/resources/js/jquery.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
        <script src="<c:url value="/resources/js/respond.min.js"/>"></script>
    </head>
    <body>
        <div class="container">           
            <div class="row">
                <br>   
                <springForm:form class="form-horizontal" modelAttribute="student" role="form" action="student">
                    <fieldset>
                        <legend class="text-primary">Information Registration</legend>
                        <p class="text-danger">${message}</p>

                        <div class="form-group">
                            <springForm:label class="col-sm-2 control-label" path="name">Name</springForm:label>
                                <div class="col-sm-5">
                                <springForm:input path="name" class="form-control" placeholder="Enter Name"/>
                            </div>
                            <springForm:errors class="col-sm-5 text-danger" path="name"/>
                        </div>
                        <div class="form-group">
                            <springForm:label class="col-sm-2 control-label" path="roll">Roll</springForm:label>
                                <div class="col-sm-5">
                                <springForm:input path="roll" class="form-control" placeholder="Enter Roll"/>
                            </div>
                            <springForm:errors class="col-sm-5 text-danger" path="roll"/>
                        </div>
                        <div class="form-group">
                            <springForm:label class="col-sm-2 control-label" path="name">Email</springForm:label>
                                <div class="col-sm-5">
                                <springForm:input path="email" class="form-control" placeholder="Enter Email"/>
                            </div>
                            <springForm:errors class="col-sm-5 text-danger" path="email"/>
                        </div>
                        <div class="form-group">
                            <springForm:label class="col-sm-2 control-label" path="name">District</springForm:label>
                                <div class="col-sm-5">
                                <springForm:input path="district" class="form-control" placeholder="Enter District"/>
                            </div>
                            <springForm:errors class="col-sm-5 text-danger" path="district"/>
                        </div>
                        <div class="form-group">
                            <springForm:label class="col-sm-2 control-label" path="phoneNumber">Phone Number</springForm:label>
                                <div class="col-sm-5">
                                <springForm:input path="phoneNumber" class="form-control" placeholder="Enter Phone Number"/>
                            </div>
                            <springForm:errors class="col-sm-5 text-danger" path="phoneNumber"/>
                        </div>
                        <div class="form-group">
                            <springForm:label class="col-sm-2 control-label" path="cgpa">CGPA</springForm:label>
                                <div class="col-sm-5">
                                <springForm:input path="cgpa" class="form-control" placeholder="Enter CGPA"/>
                            </div>
                            <springForm:errors class="col-sm-5 text-danger" path="cgpa"/>
                        </div>
                        <div class="form-group">
                            <springForm:label class="col-sm-2 control-label" path="bloodGroup">Blood Group</springForm:label>
                                <div class="col-sm-5">
                                <springForm:input path="bloodGroup" class="form-control" placeholder="Enter Blood Group"/>
                            </div>
                            <springForm:errors class="col-sm-5 text-danger" path="bloodGroup"/>
                        </div>
                        <div class="form-group">
                            <springForm:label class="col-sm-2 control-label" path="nid">National ID</springForm:label>
                                <div class="col-sm-5">
                                <springForm:input path="nid" class="form-control" placeholder="Enter National ID"/>
                            </div>
                            <springForm:errors class="col-sm-5 text-danger" path="nid"/>
                        </div>
                        <div class="col-sm-2"></div>
                        <div class="col-sm-5">
                            <a class="btn btn-success" href="${pageContext.servletContext.contextPath}/index">Index</a>
                            <button type="submit" class="btn btn-primary pull-right">Register</button>
                        </div>                 
                    </fieldset>
                </springForm:form>
            </div>
        </div>
    </body>
</html>