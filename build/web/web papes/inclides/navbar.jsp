<%-- 
    Document   : navbar
    Created on : Oct 28, 2025, 2:24:11 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
    .navbar {
        background-color: #ff9900;
        padding: 10px 20px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        font-family: Arial, sans-serif;
    }
    .navbar .logo {
        font-size: 24px;
        font-weight: bold;
        color: white;
    }
    .navbar ul {
        list-style: none;
        display: flex;
        gap: 15px;
        margin: 0;
        padding: 0;
    }
    .navbar ul li a {
        text-decoration: none;
        color: white;
        font-weight: bold;
    }
    .navbar ul li a:hover {
        text-decoration: underline;
    }
</style>

<div class="navbar">
    <div class="logo">🚗 CarRental</div>
    <ul>
        <!-- Guest -->
        <c:if test="${sessionScope.user == null}">
            <li><a href="${pageContext.request.contextPath}/CarServlet">Trang chủ</a></li>
            <li><a href="${pageContext.request.contextPath}/login.jsp">Đăng nhập</a></li>
            <li><a href="${pageContext.request.contextPath}/register.jsp">Đăng ký</a></li>
        </c:if>

        <!-- User -->
        <c:if test="${sessionScope.role == 'user'}">
            <li><a href="${pageContext.request.contextPath}/user/booking.jsp">Xe của bạn</a></li>
            <li><a href="${pageContext.request.contextPath}/CarServlet">Trang Chủ</a></li>
            <li><a href="${pageContext.request.contextPath}/user/chat.jsp">Chat</a></li>
            <li><a href="${pageContext.request.contextPath}/logoutServlet">Đăng xuất</a></li>
        </c:if>

        <!-- Admin -->
        <c:if test="${sessionScope.role == 'admin'}">
            <li><a href="${pageContext.request.contextPath}/admin/adminHome.jsp">Trang quản trị</a></li>
            <li><a href="${pageContext.request.contextPath}/adminCarServlet">Quản lý xe</a></li>
            <li><a href="${pageContext.request.contextPath}/logoutServlet">Đăng xuất</a></li>
        </c:if>
    </ul>
</div>


