<%--
  Created by IntelliJ IDEA.
  User: hariduddukunta
  Date: 14/07/22
  Time: 1:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>DataTables in Spring MVC Framework and Spring Data JPA</title>
    <link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" type="text/css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#productList').DataTable({
                pageLength : 2,
                ajax : {
                    url : '${pageContext.request.contextPath}/api/product/findall',
                    dataSrc : ''
                },
                columns : [ {
                    title : 'Id',
                    data : 'id'
                }, {
                    title : 'Name',
                    data : 'name'
                }, {
                    title : 'Price',
                    data : 'price'
                }, {
                    title : 'Quantity',
                    data : 'quantity'
                }, {
                    title : 'Status',
                    data : 'status',
                    render: function(data) {
                        return data ? 'Show' : 'Hide';
                    }
                }, {
                    title : 'Photo',
                    data : 'photo',
                    render: function(data) {
                        return '<img src="${pageContext.request.contextPath}/resources/http://learningprogramming.net/wp-content/uploads/java/spring_mvc/' + data + '" width="50" />';
                    }
                } ]
            });
        });
    </script>
</head>
<body>

<table id="productList" class="display" style="width: 100%"></table>

</body>
</html>
