<%-- 
    Document   : home
    Created on : Nov 2, 2025, 11:55:57 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/web papes/inclides/navbar.jsp" %>

<html>
<head>
    <title>Trang chủ thuê xe</title>
    <style>
        .container { max-width: 1000px; margin: auto; }
        .grid { display: flex; flex-wrap: wrap; gap: 20px; }
        .car-card {
            border: 1px solid #ccc;
            padding: 15px;
            width: 300px;
            border-radius: 8px;
            box-shadow: 2px 2px 8px rgba(0,0,0,0.1);
        }
        .btn {
            background: #007bff;
            color: white;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            cursor: pointer;
        }
        .btn:disabled {
            background: #ccc;
            cursor: not-allowed;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Danh sách xe</h2>
    <c:if test="${empty cars}">
        <p>Không có xe nào trong hệ thống.</p>
    </c:if>
    <div class="grid">
        <c:forEach var="car" items="${cars}">
            <div class="car-card">
                <h3>${car.name}</h3>
                <p>Hãng: ${car.brand}</p>
                <p>Giá thuê: ${car.pricePerDay} VNĐ/ngày</p>
                <p>Trạng thái: 
                    <c:choose>
                        <c:when test="${car.available}">Còn trống</c:when>
                        <c:otherwise>Đã thuê</c:otherwise>
                    </c:choose>
                </p>

                <c:choose>
                    <c:when test="${role == 'guest'}">
                        <a href="login.jsp" class="btn">Đăng nhập để đặt xe</a>
                    </c:when>
                    <c:when test="${role == 'user'}">
                        <c:choose>
                            <c:when test="${car.available}">
                                <form action="booking" method="post">
                                    <input type="hidden" name="carId" value="${car.id}" />
                                    <button type="submit" class="btn">Đặt xe</button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <button class="btn" disabled>Đã đặt thành công</button>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                </c:choose>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
