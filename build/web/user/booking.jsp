<%-- 
    Document   : userHome
    Created on : Oct 28, 2025, 2:27:45 PM
    Author     : PC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../inclides/navbar.jsp" %>

<html>
<head>
    <title>Xe bạn đã đặt</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f9f9f9; margin: 0; padding: 0; }
        .container { max-width: 900px; margin: auto; padding: 20px; background: white; }
        h2 { color: #333; border-bottom: 2px solid #ff9900; padding-bottom: 5px; }
        .car-card {
            border: 1px solid #ddd;
            padding: 15px;
            margin-bottom: 15px;
            border-radius: 6px;
            background: #fff;
            box-shadow: 0 2px 4px rgba(0,0,0,0.05);
        }
        .car-card h3 { margin: 0 0 10px; }
        .car-card p { margin: 5px 0; }
    </style>
</head>
<body>
<div class="container">
    <h2>🧾 Xe bạn đã đặt</h2>

    <c:if test="${empty myBookings}">
        <p>Bạn chưa đặt xe nào.</p>
    </c:if>

    <c:forEach var="booking" items="${myBookings}">
        <div class="car-card">
            <h3>${booking.car.name}</h3>
            <p>Hãng: ${booking.car.brand}</p>
            <p>Giá thuê: ${booking.car.pricePerDay} VNĐ/ngày</p>
            <p>Ngày đặt: ${booking.bookingDate}</p>
            <p>Trạng thái: ${booking.status}</p>
        </div>
    </c:forEach>
</div>
</body>
</html>


