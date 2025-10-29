# 🚗 PRJ Final Assiment - Car Rental App 

Ứng dụng **thuê xe trực tuyến** 
---

## 🏗️ Mô hình kiến trúc MVC

### 🔹 **Model**
- Gồm các **entity class**: `Car`, `User`, `ChatMessage`, ...  
- Dùng **JPA (Hibernate)** để ánh xạ giữa Java Object và bảng dữ liệu SQL Server.  
- Giao tiếp với DB thông qua `EntityManager` trong `JPAUtil.java`.

### 🔹 **View**
- Các trang **JSP** nằm trong thư mục `web/`, hiển thị giao diện người dùng.  
- Sử dụng **JSTL** để truy xuất dữ liệu và **Bootstrap** để tạo giao diện thân thiện.  
- Có các trang chính:
  - `index.jsp`: Trang chủ cho Guest
  - `user_home.jsp`: Trang chính của User
  - `admin_dashboard.jsp`: Trang quản trị
  - `login.jsp`, `register.jsp`, `car_list.jsp`, `chat.jsp`, ...

### 🔹 **Filter**
- Thực hiện phân quyền giữa **User**, **Admin** và **Guest**.

## 👥 Phân quyền chức năng

| Vai trò  | Chức năng chính |
|-----------|----------------|
| **Guest** | Xem danh sách xe, không thể đặt xe. Khi bấm “Đặt xe” sẽ yêu cầu đăng nhập. |
| **User**  | Đăng nhập / đăng ký, tìm xe, đặt xe, hủy xe, xem lịch sử thuê, chat |
| **Admin** | Quản lý toàn bộ xe, người dùng, đơn thuê |
---

## 💾 Cấu trúc thư mục
