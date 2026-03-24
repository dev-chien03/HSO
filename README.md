# HSO

Máy chủ game (custom MMO) chạy trên Java 17, dùng MySQL và bộ dữ liệu nhị phân trong thư mục `data/`.

## Kiến trúc nhanh
- Java 17 + Maven; entrypoint: `core.Start`.
- MySQL (kết nối qua HikariCP).
- Gói chạy tự chứa: `HSO-1.0-jar-with-dependencies.jar` (plugin assembly).

## Yêu cầu
- JDK 17
- MySQL 8.x (hoặc tương thích)

## Cài đặt & chạy
1) Clone mã nguồn.
2) Tạo database (ví dụ `hso_data`) và import file [hso_data.sql](hso_data.sql).
3) Sửa cấu hình [hso.conf](hso.conf):
	- `port`: cổng server (mặc định 19129)
	- `mysql-host`, `mysql-user`, `mysql-password`, `mysql-database`
	- `debug`, `ratio_hp`, các tham số event/time-out nếu cần
4) Build: `mvn package -DskipTests`
5) Chạy server: `java -jar -server target/HSO-1.0-jar-with-dependencies.jar` (hoặc dùng `start.bat`).

## Lưu ý dữ liệu
- Thư mục `data/` đã được .gitignore; không đẩy lên repo.
- Cần có đủ dữ liệu trong `data/` để server hoạt động (tệp nhị phân, msg, part…).

## Công cụ đi kèm
- Có sẵn Maven wrapper và bộ Maven trong `.tools/apache-maven-3.9.9` nếu không muốn cài Maven toàn cục.
