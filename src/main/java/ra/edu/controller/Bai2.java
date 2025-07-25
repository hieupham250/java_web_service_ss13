package ra.edu.controller;

public class Bai2 {

    /*
     1. Mục tiêu:
     - Nắm vững quy trình xác thực người dùng bằng JWT trong REST API.
     - Hiểu rõ vòng đời của JWT từ lúc đăng nhập đến khi truy cập tài nguyên được bảo vệ.

     2. Quy trình xác thực JWT gồm các bước:

     [1] Client gửi yêu cầu đăng nhập (username/password) đến Server qua API `/login`:
         - Dạng POST: { "username": "abc", "password": "123456" }

     [2] Server kiểm tra thông tin đăng nhập:
         - Nếu hợp lệ, Server sinh ra JWT chứa thông tin người dùng và thời gian hết hạn.
         - JWT có thể chứa các claims như userId, username, role, v.v.

     [3] Server trả JWT về cho client:
         - Token trả về nằm trong response body hoặc response header.

     [4] Client lưu JWT (thường trong localStorage hoặc memory – KHÔNG nên lưu trong cookie nếu không bảo mật):
         - Từ các request tiếp theo, Client gửi JWT trong header:
           Authorization: Bearer <token>

     [5] Server nhận request kèm JWT:
         - Middleware (hoặc filter) kiểm tra JWT có hợp lệ không (signature, thời hạn).
         - Nếu hợp lệ: cho phép truy cập tài nguyên bảo vệ.
         - Nếu không hợp lệ hoặc hết hạn: trả về lỗi 401 Unauthorized.

     3. Vai trò của từng bước:
     - Bước 1: Xác thực danh tính ban đầu.
     - Bước 2-3: Sinh và cấp phát "chứng chỉ truy cập" (JWT).
     - Bước 4: Lưu token để dùng cho các request sau.
     - Bước 5: Kiểm tra tính hợp lệ của token và thực hiện kiểm soát truy cập.

     4. Tóm tắt sơ đồ luồng:

       [Client] --(1)--> [POST /login với username/password]
       [Server] --(2)--> Kiểm tra hợp lệ -> tạo JWT
       [Server] --(3)--> Trả JWT về cho Client
       [Client] --(4)--> Gửi các request có header Authorization: Bearer <token>
       [Server] --(5)--> Middleware xác minh JWT -> cho phép hoặc từ chối

     ==> Quy trình này giúp đảm bảo người dùng đã xác thực mới được truy cập tài nguyên.
     */
}
