package ra.edu.controller;

public class Bai1 {
    /*
     1. JWT là gì?
     - JWT (JSON Web Token) là một tiêu chuẩn mở (RFC 7519) dùng để truyền tải thông tin
       giữa các bên dưới dạng chuỗi JSON được mã hóa và ký.
     - JWT thường được sử dụng để xác thực (authentication) và phân quyền (authorization).

     2. Ưu điểm và Nhược điểm
     Ưu điểm:
     - Stateless: không cần lưu session phía server.
     - Nhanh: không phải truy vấn DB để lấy thông tin người dùng mỗi lần request.
     - Dễ tích hợp với các nền tảng khác nhau (web, mobile, microservices).

     Nhược điểm:
     - Không dễ thu hồi token (phải dùng blacklist hoặc hạn chế thời gian sống).
     - Payload có thể giải mã dễ dàng nếu không mã hóa thêm => không lưu dữ liệu nhạy cảm.
     - Kích thước token có thể lớn.

     3. Cấu trúc của JWT:
     Cú pháp:
       Header.Payload.Signature

     Ví dụ:
       eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.
       eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwicm9sZSI6ImFkbWluIn0.
       SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c

     - Header: chứa thuật toán ký (HS256, RS256, ...) và loại token (typ: "JWT").
     - Payload: chứa dữ liệu (claims) như userId, name, role, exp,...
     - Signature: dùng để xác minh token có bị sửa đổi hay không.

     Công thức signature:
       HMACSHA256(
         base64UrlEncode(header) + "." + base64UrlEncode(payload),
         secret
       )

     4. Trường hợp sử dụng phổ biến của JWT:
     - Xác thực người dùng (authentication) sau khi login.
     - Phân quyền (authorization) dựa trên role trong token.
     - Giao tiếp giữa các microservices.
     - Sử dụng trong các ứng dụng SPA hoặc mobile để duy trì trạng thái đăng nhập.
     */
}
