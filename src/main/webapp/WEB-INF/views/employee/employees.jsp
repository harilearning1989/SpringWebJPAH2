<%--
  Created by IntelliJ IDEA.
  User: hariduddukunta
  Date: 14/07/22
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Employee Details</title>
    <link href="<c:url value="/resources/css/jquery.dataTables.min.css" />" type="text/css" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-3.3.1.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.dataTables.min.js" />"></script>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#productList').DataTable({
                pageLength : 18,
                scrollX: true,
                scrollY: 630,
                ajax : {
                    url : '${pageContext.request.contextPath}/emp/listEmp',
                    dataSrc : ''
                },
                columns : [ {
                    title : 'Id',
                    data : 'empId'
                }, {
                    title : 'First Name',
                    data : 'firstName'
                }, {
                    title : 'Last Name',
                    data : 'lastName'
                }, {
                    title : 'Gender',
                    data : 'gender',
                    render: function(data) {
                        return data == 'M' ? 'Male' : 'FeMale';
                    }
                }, {
                    title : 'Email',
                    data : 'email',
                    render: function(data) {
                        return data ? 'Show' : 'Hide';
                    }
                }, {
                    title : 'Salary',
                    data : 'salary',
                    render: function(data) {
                        return data;
                    }
                }, {
                    title : 'phone',
                    data : 'phone',
                    render: function(data) {
                        return data;
                    }
                }, {
                    title : 'Country',
                    data : 'country',
                    render: function(data) {
                        return data;
                    }
                }, {
                    title : 'City',
                    data : 'city',
                    render: function(data) {
                        return data;
                    }
                }, {
                    title : 'State',
                    data : 'state',
                    render: function(data) {
                        return data;
                    }
                }, {
                    title : 'Zip',
                    data : 'zip',
                    render: function(data) {
                        return data;
                    }
                }, {
                    title : 'Region',
                    data : 'region',
                    render: function(data) {
                        return data;
                    }
                }]
            });
        });
    </script>
</head>
<body>

<div class="container" style="background-color: lightblue;width: 100%;height: 100%">
    <div class="panel-heading">
        <%--<div class="panel-title">Employee List</div>--%>
        <input type="button" value="Add Employee"
               onclick="window.location.href='showForm'; return false;"
               class="btn btn-primary" />
        <br/><br/>
    </div>
    <div class="panel-body">
        <table id="productList" class="display" style="width: 100%"></table>
    </div>
</div>
</body>
</html>
