<%-- 
    Document   : carFrom
    Created on : Oct 28, 2025, 2:26:49 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/web papes/inclides/navbar.jsp" %>

<html>
<head>
    <title><c:if test="${car != null}">Sửa xe</c:if><c:if test="${car == null}">Thêm xe mới</c:if></title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f4f4; margin: 0; padding: 0; }
        .form-container {
            max-width: 600px;
            margin: 40px auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }
        h2 { text-align: center; color: #333; margin-bottom: 20px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; font-weight: bold; margin-bottom: 5px; }
        input[type="text"], input[type="number"] {
            width: 100%; padding: 8px;
            border: 1px solid #ccc; border-radius: 4px;
        }
        .form-check {
            display: flex; align-items: center; gap: 10px;
        }
        .btn {
            background: #007bff; color: white;
            padding: 10px 15px; border: none;
            border-radius: 4px; cursor: pointer;
        }
        .btn:hover { background: #0056b3; }
    </style>
</head>
<body>

<div class="form-container">
    <h2><c:if test="${car != null}">✏️ Sửa xe</c:if><c:if test="${car == null}">➕ Thêm xe mới</c:if></h2>

    <form action="${pageContext.request.contextPath}/adminCarServlet" method="post">
        <c:if test="${car != null}">
            <input type="hidden" name="id" value="${car.id}" />
        </c:if>

        <div class="form-group">
            <label for="name">Tên xe</label>
            <input type="text" name="name" id="name" value="${car != null ? car.name : ''}" required />
        </div>

        <div class="form-group">
            <label for="brand">Hãng xe</label>
            <input type="text" name="brand" id="brand" value="${car != null ? car.brand : ''}" required />
        </div>

        <div class="form-group">
            <label for="price">Giá thuê/ngày (VNĐ)</label>
            <input type="number" name="price" id="price" step="0.01" value="${car != null ? car.pricePerDay : ''}" required />
        </div>

        <div class="form-group form-check">
            <input type="checkbox" name="available" id="available"
                   <c:if test="${car == null || car.available}">checked</c:if> />
            <label for="available">Xe còn trống</label>
        </div>

        <button type="submit" class="btn">Lưu xe</button>
    </form>
</div>

</body>
</html>
