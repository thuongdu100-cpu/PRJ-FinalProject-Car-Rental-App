<%-- 
    Document   : userHome
    Created on : Oct 28, 2025, 2:27:45 PM
    Author     : PC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/web papes/inclides/navbar.jsp" %>

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
        .status {
            font-weight: bold;
            padding: 4px 8px;
            border-radius: 4px;
            display: inline-block;
        }
        .status.pending { background: #ffc107; color: #333; }
        .status.confirmed { background: #28a745; color: white; }
        .status.cancelled { background: #dc3545; color: white; }
        .btn-cancel {
            background: #dc3545;
            color: white;
            padding: 6px 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 10px;
        }
        .btn-cancel:hover { background: #c82333; }
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
            <p>Trạng thái: 
                <span class="status 
                    <c:choose>
                        <c:when test="${booking.status == 'Đang chờ'}">pending</c:when>
                        <c:when test="${booking.status == 'Đã xác nhận'}">confirmed</c:when>
                        <c:otherwise>cancelled</c:otherwise>
                    </c:choose>">
                    ${booking.status}
                </span>
            </p>

            <c:if test="${booking.status == 'Đang chờ' || booking.status == 'Đã xác nhận'}">
                <form action="cancelBooking" method="post" onsubmit="return confirm('Bạn có chắc muốn hủy đặt xe này?')">
                    <input type="hidden" name="bookingId" value="${booking.id}" />
                    <button type="submit" class="btn-cancel">❌ Hủy đặt xe</button>
                </form>
            </c:if>
        </div>
    </c:forEach>
</div>
</body>
</html>



