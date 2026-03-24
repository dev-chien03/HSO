package core;

import client.Player;
import template.Quest;
import java.io.IOException;
import java.util.*;

public class QuestManager {
    public static List<Quest> quests = new ArrayList<>();

    public static void load() {
        quests.clear();

        // ===== CHUỖI NHIỆM VỤ CHÍNH =====

        // 1. Khởi hành - Người mẹ -> Lính gác
        addQuest(1, "Khởi hành", -16, -6, (byte)0, -1, 0,
            "Hãy rời nhà và đến gặp Lính gác để bắt đầu chuyến phiêu lưu.",
            "Đến gặp Lính gác để hoàn thành nhiệm vụ khởi hành.",
            2, 500, 1000, 5);

        // 2. Tiến vào làng Sói - Alisama: giết 10 Smiley
        addQuest(2, "Tiến vào làng Sói", -77, -7, (byte)1, 0, 10,
            "Đánh đuổi 10 con Smiley, sau đó quay trở lại gặp anh Lính gác để hoàn thành bài thử thách.",
            "Tiêu diệt 10 Smiley rồi quay lại gặp Lính gác.",
            3, 800, 1500, 8);

        // 3. Thử thách đầu tiên - Lính gác: talk -> đi hang
        addQuest(3, "Thử thách đầu tiên", -7, -77, (byte)0, -1, 0,
            "Đi xuống một cái hang nằm đâu đó trong Bìa Rừng, phía Nam ngôi làng để đến Khu Rừng Ảo Giác. Truy tìm sinh vật bí ẩn đã tấn công dân làng.",
            "Tìm hiểu sinh vật bí ẩn rồi quay lại báo cáo Alisama.",
            4, 1000, 2000, 10);

        // 4. Bia đá cổ đại - Alisama -> Zulu
        addQuest(4, "Bia đá cổ đại", -77, -8, (byte)0, -1, 0,
            "Hãy lắng nghe phù thủy trẻ Zulu hướng dẫn cách sử dụng Bia đá dịch chuyển tức thời.",
            "Đến gặp Zulu để học cách dịch chuyển.",
            5, 500, 1000, 5);

        // 5. Nước mắt hồi phục - Zulu: giết 20 Smiley
        addQuest(5, "Nước mắt hồi phục", -8, -3, (byte)1, 0, 20,
            "Hãy thu thập 20 giọt nước mắt của những con Smiley ở khu bìa rừng phía Tây Làng Sói.",
            "Thu thập 20 giọt nước mắt Smiley rồi mang về cho Lisa.",
            6, 1200, 2500, 12);

        // 6. Nỗi sợ ốc sên - Lisa: giết 20 Ốc sên (mob_id=1)
        addQuest(6, "Nỗi sợ ốc sên", -3, -3, (byte)1, 1, 20,
            "Đuổi 20 con ốc sên ở khu bìa rừng và báo lại cho Lisa.",
            "Tiêu diệt 20 Ốc Sên rồi quay lại gặp Lisa.",
            7, 1500, 3000, 15);

        // 7. Quái thú trong hang động - Lisa: giết 30 Lửa ma trơi + 30 Chuột
        addQuest(7, "Quái thú trong hang động", -3, -5, (byte)1, 2, 30,
            "Tiêu diệt 30 con Lửa ma trơi, 30 con Chuột trong một cái hang ở khu Bìa rừng. Sau đó quay lại báo cáo cho Hammer.",
            "Tiêu diệt Lửa ma trơi và Chuột rồi báo cáo Hammer.",
            8, 2000, 4000, 20);

        // 8. Món quà của Hammer - Hammer: giết 40 Nấm ảo giác
        addQuest(8, "Món quà của Hammer", -5, -3, (byte)1, 4, 40,
            "Hãy đi xuyên qua Hang Lửa để đến được rừng Ảo giác, sau đó đi săn nấm ảo giác để thu thập 40 bông hoa ngàn hương từ chúng. Sau cùng mang về gửi cho Lisa cùng với lá thư tỏ tình của Hammer.",
            "Thu thập 40 hoa từ Nấm Ảo Giác rồi mang về cho Lisa.",
            9, 2500, 5000, 25);

        // 9. Tảng đá ghi nhớ - Lisa -> talk boss Thủy Quái
        addQuest(9, "Tảng Đá Ghi Nhớ", -3, -8, (byte)0, -1, 0,
            "Từ Cánh Đồng Sói đi về phía Nam, băng qua Thung Lũng Kỳ Bí để đến một cái hồ thủy quái, đi vòng quanh bờ hồ để bước vào nơi có những tảng bia đá. Đối đầu với một con quái vật nguy hiểm.",
            "Tìm tảng đá ghi nhớ rồi quay lại gặp Zulu.",
            10, 3000, 6000, 30);

        // 10. Lãnh địa của loài sói - Zulu: giết 50 Chó điên + 50 Sói xám
        addQuest(10, "Lãnh địa của loài sói", -8, -4, (byte)1, 6, 50,
            "Hãy bước ra Cánh Đồng Sói phía Bắc làng và săn 50 con chó điên và 50 con sói xám. Sau đó về báo cáo lại cho Doubar.",
            "Săn 50 Chó Điên và 50 Sói Xám rồi báo cáo Doubar.",
            11, 3500, 7000, 35);

        // 11. Quái vật trong rừng - Doubar: giết 50 Chuột 3 mắt + 50 Bọ sát thủ
        addQuest(11, "Quái vật trong rừng", -4, -4, (byte)1, 8, 50,
            "Hãy đi đến Thung Lũng Kỳ Bí và săn 50 con chuột 3 mắt, 50 con bọ sát thủ. Từ Cánh Đồng Sói đi về hướng Tây để đến thung lũng, xong việc trở về báo cáo Doubar.",
            "Săn 50 Chuột Ba Mắt và 50 Bọ Sát Thủ rồi báo cáo Doubar.",
            12, 4000, 8000, 40);

        // 12. Áo giáp của chiến binh - Doubar: giết 50 Sên Xanh
        addQuest(12, "Áo giáp của chiến binh", -4, -4, (byte)1, 10, 50,
            "Bạn phải băng qua một cây cầu ở Thung Lũng Kỳ Bí để đến được Hồ Ký Ức, đi vào lòng hồ để săn loài Sên Xanh, thu thập 50 mẫu keo dính đặc biệt cho Doubar.",
            "Thu thập 50 keo dính từ Sên Xanh rồi mang về cho Doubar.",
            13, 4500, 9000, 45);

        // 13. Thủy thủ gặp nạn - Doubar -> Cướp biển
        addQuest(13, "Thủy Thủ Gặp Nạn", -4, -34, (byte)0, -1, 0,
            "Từ Cánh Đồng Sói đi về hướng Đông để ra biển, đi dọc theo bờ biển tìm vị trí những thủy thủ gặp nạn.",
            "Tìm những thủy thủ gặp nạn ở bờ biển.",
            14, 3000, 5000, 25);

        // 14. Tiến ra bờ biển - Cướp biển: giết 50 Mèo Vàng
        addQuest(14, "Tiến ra bờ biển", -34, -3, (byte)1, 12, 50,
            "Từ Cánh Đồng Sói đi về phía Đông để tiến ra Bờ Biển, săn lũ Mèo Vàng để thu thập 50 nhúm Lông Mèo cho Lisa.",
            "Thu thập 50 Lông Mèo Vàng rồi mang về cho Lisa.",
            15, 5000, 10000, 50);

        // 15. Săn bạch tuộc - Lisa: giết 50 Bạch Tuộc Gai
        addQuest(15, "Săn bạch tuộc", -3, -3, (byte)1, 13, 50,
            "Quay trở lại Bờ Biển và tìm những con Bạch Tuộc Gai, thu thập 50 lọ mực độc rồi mang về cho Lisa.",
            "Thu thập 50 mực độc từ Bạch Tuộc Gai rồi mang về cho Lisa.",
            16, 5500, 11000, 55);

        // 16. Lá ngụy trang - Lisa: giết 50 Cáo Xanh
        addQuest(16, "Lá ngụy trang", -3, -3, (byte)1, 14, 50,
            "Đi thẳng đến hết đường bờ biển để đến khu Vực Đá, săn cáo xanh để lấy 50 lá ngụy trang cho Lisa.",
            "Thu thập 50 lá ngụy trang từ Cáo Xanh cho Lisa.",
            17, 6000, 12000, 60);

        // 17. Trận chiến ngoài khơi - Lisa -> talk Thủy quái
        addQuest(17, "Trận Chiến Ngoài Khơi", -3, -34, (byte)0, -1, 0,
            "Tiến ra rặng Đá Ngầm, giành lại chiếc rương bí ẩn từ con thủy quái đầu đàn.",
            "Đánh bại thủy quái rồi quay lại báo cáo.",
            18, 7000, 14000, 70);

        // 18. Phá giải vòng vây - Cướp biển: giết 50 Cua Đá + 50 Tôm Quỷ
        addQuest(18, "Phá giải vòng vây", -34, -2, (byte)1, 15, 50,
            "Hãy tiêu diệt 50 con Cua Đá và 50 Tôm Quỷ ở Rặng Đá Ngầm.",
            "Tiêu diệt 50 Cua Đá và 50 Tôm Quỷ rồi báo cáo Zoro.",
            19, 7500, 15000, 75);

        // 19. Chiếc rương bí ẩn - Zoro -> talk
        addQuest(19, "Chiếc Rương bí ẩn", -2, -2, (byte)0, -1, 0,
            "Tiếp tục nói chuyện với trưởng làng Zoro.",
            "Nói chuyện với Zoro.",
            20, 5000, 10000, 50);

        // 20. Bậc thầy thuốc nổ - Zoro: giết 50 Quả Bí Ma
        addQuest(20, "Bậc thầy thuốc nổ", -2, -5, (byte)1, 19, 50,
            "Từ Cánh Đồng Sói đi thẳng lên phương Bắc đến khu Đầm Lầy. Săn Quả Bí Ma lấy 50 Vỏ Bí.",
            "Thu thập 50 Vỏ Bí từ Quả Bí Ma rồi mang về cho Hammer.",
            21, 8000, 16000, 80);

        // 21. Truy tìm Giun Quái Thú - Hammer: giết 50 Giun Quái Thú
        addQuest(21, "Truy tìm Giun Quái Thú", -5, -5, (byte)1, 21, 50,
            "Tiếp tục đi thẳng từ Đầm Lầy để đến ngôi Đền Cổ, tìm 50 Bột Diêm từ bộ lạc Giun Quái Thú.",
            "Thu thập 50 Bột Diêm từ Giun Quái Thú rồi mang về cho Hammer.",
            22, 8500, 17000, 85);

        // 22. Nguyên liệu cuối cùng - Hammer: giết 80 Dơi Hang Động
        addQuest(22, "Nguyên liệu cuối cùng", -5, -5, (byte)1, 22, 80,
            "Trong khu Đền Cổ có một cái hang, hãy đi xuống đó tìm 80 hỗn hợp phân của những con Dơi Hang Động khát máu.",
            "Thu thập 80 phân Dơi Hang Động rồi mang về cho Hammer.",
            23, 9000, 18000, 90);

        // 23. Chuẩn bị phá cửa hang - Hammer -> Lính gác
        addQuest(23, "Chuẩn bị phá cửa hang", -5, -7, (byte)0, -1, 0,
            "Hãy chuyển khối bộc phá cho tên lính gác trước cửa Hang Sói Quỷ ở Cánh Đồng Sói.",
            "Mang bộc phá đến cho Lính gác.",
            24, 5000, 10000, 50);

        // 24. Tiến vào diệt Sói - Lính gác: giết Sói Bất Tử (mob_id=23)
        addQuest(24, "Tiến Vào Diệt Sói", -7, -7, (byte)1, 23, 1,
            "Tiến vào hang đánh bại Sói Bất Tử, sau đó trở ra báo cáo cho tên lính gác.",
            "Đánh bại Sói Bất Tử rồi báo cáo Lính gác.",
            25, 15000, 30000, 150);

        // 25. Quái vật đầm lầy - Lính gác: giết 60 Nhện Đầm Lầy
        addQuest(25, "Quái vật đầm lầy", -7, -8, (byte)1, 18, 60,
            "Hãy đi lên vùng Đầm Lầy phía Bắc săn 60 con Nhện Đầm Lầy. Sau đó quay về mô tả lại lũ nhện cho Zulu.",
            "Săn 60 Nhện Đầm Lầy rồi báo cáo Zulu.",
            26, 10000, 20000, 100);

        // 26. Bọ cạp cổ đại - Zulu: giết 60 Bọ Cạp Máu
        addQuest(26, "Bọ cạp cổ đại", -8, -8, (byte)1, 20, 60,
            "Tiếp tục từ Đầm Lầy đi thẳng đến khu Đền Cổ. Săn 60 con Bọ Cạp Máu rồi trở về nói chuyện với Zulu.",
            "Săn 60 Bọ Cạp Máu rồi báo cáo Zulu.",
            27, 11000, 22000, 110);

        // 27. Gặp gỡ Benjamin - Zulu -> Benjamin
        addQuest(27, "Gặp gỡ Benjamin", -8, -19, (byte)0, -1, 0,
            "Hãy theo lời Zoro tìm đến Benjamin ở đâu đó trong Thành Phố Kho Báu.",
            "Đến gặp Benjamin ở Thành Phố Kho Báu.",
            28, 8000, 16000, 80);

        // 28. Nền văn minh cổ đại - Benjamin: giết 80 Nước Độc (mob_id=27)
        addQuest(28, "Nền văn minh cổ đại", -19, -19, (byte)1, 27, 80,
            "Từ Thành Phố Kho Báu hãy trở xuống Khu Rừng Chết phía Nam để tìm 80 giọt nước độc từ lũ quái trông giống Smiley.",
            "Thu thập 80 giọt nước độc rồi mang về cho Benjamin.",
            29, 12000, 24000, 120);

        // 29. Quái vật Suối Ma - Benjamin: giết 80 Cầu Quỷ (mob_id=30)
        addQuest(29, "Quái vật Suối Ma", -19, -19, (byte)1, 30, 80,
            "Hãy đi đến Suối Ma phía Tây Khu Rừng Chết để săn những con Cầu Quỷ, thu thập 80 hàm răng quỷ từ chúng.",
            "Thu thập 80 răng quỷ từ Cầu Quỷ rồi mang về cho Benjamin.",
            30, 13000, 26000, 130);

        // 30. Truyền thuyết về Mắt Thần - Benjamin -> Black Eye
        addQuest(30, "Truyền Thuyết Về Mắt Thần", -19, -21, (byte)0, -1, 0,
            "Đến gặp Black eye để hỏi về thánh vật Mắt Thần.",
            "Đến gặp Black Eye.",
            31, 10000, 20000, 100);

        // 31. Guardian - Black Eye: giết Guardian (mob_id=51)
        addQuest(31, "Guardian - quái vật cổ đại", -21, -21, (byte)1, 51, 1,
            "Hãy đi sâu vào Khu Rừng Chết, băng qua Suối Ma và Thung lũng đá để đối mặt với trùm Guardian. Kẻ đang giữ mảnh tinh thể thứ nhất.",
            "Đánh bại Guardian rồi báo cáo Black Eye.",
            32, 20000, 40000, 200);

        // 32. Người thầy của Lisa - Black Eye: giết Ruồi Hút Máu (mob_id=25)
        addQuest(32, "Người thầy của Lisa", -21, -3, (byte)1, 25, 80,
            "Đến Khu Rừng Chết và thu thập Trứng Ruồi từ những con Ruồi Hút Máu.",
            "Thu thập 80 Trứng Ruồi rồi mang về cho Lisa.",
            33, 14000, 28000, 140);

        // 33. Lọ thuốc dũng cảm - Lisa: giết Ma Cây (mob_id=26)
        addQuest(33, "Lọ thuốc dũng cảm", -3, -3, (byte)1, 26, 80,
            "Tiếp tục thu thập Vỏ Cây từ loài Ma Cây trong Khu Rừng Chết.",
            "Thu thập 80 Vỏ Cây từ Ma Cây rồi mang về cho Lisa.",
            34, 14500, 29000, 145);

        // 34. Món quà đặc biệt - Lisa -> Lisa
        addQuest(34, "Món quà đặc biệt", -3, -3, (byte)0, -1, 0,
            "Hãy mang lọ thuốc trở về cho Lisa để giúp cô ấy chữa chứng bệnh sợ hãi.",
            "Nói chuyện với Lisa.",
            35, 10000, 20000, 100);

        // 35. Con suối tử thần - Lính gác: giết 80 Cây Ăn Thịt + 80 Hoa Xúc Tu
        addQuest(35, "Con suối tử thần", -7, -7, (byte)1, 28, 80,
            "Nhiệm vụ từ lính gác cổng phía Nam thành phố: Đi đến Suối ma tiêu diệt 80 Cây Ăn Thịt và 80 Hoa Xúc Tu.",
            "Tiêu diệt 80 Cây Ăn Thịt và 80 Hoa Xúc Tu rồi báo cáo Lính gác.",
            36, 15000, 30000, 150);

        // 36. Thung Lũng Đá Quý - Lính gác: giết 80 Tắc Kè + 80 Ong Sát Thủ
        addQuest(36, "Thung Lũng Đá Quý", -7, -7, (byte)1, 31, 80,
            "Hãy băng qua Suối Ma để tiến vào Thung Lũng Đá, đánh đuổi 80 Tắc Kè và 80 Ong Sát Thủ. Sau đó trở về nói chuyện với lính gác ở cổng phía Nam thành phố.",
            "Tiêu diệt 80 Tắc Kè và 80 Ong Sát Thủ rồi báo cáo Lính gác.",
            37, 16000, 32000, 160);

        // 37. Mảnh ghép bản đồ - Lính gác: giết 50 Kẻ Giữ Mộ (mob_id=36)
        addQuest(37, "Mảnh ghép bản đồ", -7, -21, (byte)1, 36, 50,
            "Nhiệm vụ đi xuống Hầm mộ tìm 50 mảnh ghép bản đồ từ những Kẻ Giữ Mộ. Sau đó đưa chúng trở về cho Black eye.",
            "Thu thập 50 mảnh ghép từ Kẻ Giữ Mộ rồi mang về cho Black Eye.",
            38, 17000, 34000, 170);

        // 38. Cuộc tìm kiếm khó khăn - Black Eye: giết 50 Tử Thần (mob_id=40)
        addQuest(38, "Cuộc tìm kiếm khó khăn", -21, -21, (byte)1, 40, 50,
            "Phần còn lại của tấm bản đồ nằm ở tầng tận cùng của Hầm mộ. Hãy tiêu diệt Tử Thần và tìm lại 50 mảnh ghép cuối cùng cho Black eye.",
            "Thu thập 50 mảnh ghép từ Tử Thần rồi mang về cho Black Eye.",
            39, 18000, 36000, 180);

        // 39. Bí ẩn lăng mộ cổ - Black Eye: giết Xác Ướp Ngàn Năm (mob_id=52)
        addQuest(39, "Bí ẩn lăng mộ cổ", -21, -21, (byte)1, 52, 1,
            "Hãy quay trở lại tầng sâu nhất của Hầm Mộ, tìm căn phòng bí mật và đối đầu với kẻ canh giữ viên đá thần.",
            "Đánh bại kẻ canh giữ rồi báo cáo Black Eye.",
            40, 25000, 50000, 250);

        // 40. Bóng ma trong hầm mộ - Lính gác: giết 100 Dơi Mặt Người (mob_id=33)
        addQuest(40, "Bóng ma trong hầm mộ", -7, -7, (byte)1, 33, 100,
            "Đi xuống hầm mộ và săn 100 con Dơi Mặt Người. Sau đó trở lại nói chuyện với lính gác trước cửa hầm.",
            "Săn 100 Dơi Mặt Người rồi báo cáo Lính gác.",
            41, 18000, 36000, 180);

        // 41. Những chiến binh bất tử - Lính gác: giết 100 Chiến Binh Ma + 100 Vệ Sĩ Hắc Ám
        addQuest(41, "Những chiến binh bất tử", -7, -7, (byte)1, 34, 100,
            "Hãy đánh bại 100 Chiến Binh Ma và 100 Vệ Sĩ Hắc Ám bên dưới hầm mộ. Sau đó trở lên nói chuyện với tên lính gác trước cửa hầm.",
            "Tiêu diệt 100 Chiến Binh Ma và Vệ Sĩ Hắc Ám rồi báo cáo Lính gác.",
            42, 20000, 40000, 200);

        // 42. Huyền thoại Quái Vật Đầu Bò - Lính gác -> Benjamin
        addQuest(42, "Huyền thoại Quái Vật Đầu Bò", -7, -19, (byte)0, -1, 0,
            "Hãy quay trở lại Benjamin ở khu phố Phía Tây để hỏi Quái Vật Đầu Bò.",
            "Đến gặp Benjamin.",
            43, 15000, 30000, 150);

        // 43. Hành trình săn Quái Vật Đầu Bò - Benjamin: giết Quái Vật Đầu Bò (mob_id=53)
        addQuest(43, "Hành trình săn tìm Quái Vật trong sa mạc", -19, -19, (byte)1, 53, 1,
            "Hãy ra cổng phía Tây Thành Phố rồi tiến vào vùng sa mạc. Đi đến tận cùng phía bắc sẽ đến được bờ biển. Từ nơi đó, hãy tiếp tục đi tìm Ngọn đồi Xác Chết và đánh bại Quái Vật Đầu Bò để tìm mảnh tinh thể thứ 3.",
            "Đánh bại Quái Vật Đầu Bò rồi báo cáo Benjamin.",
            44, 30000, 60000, 300);

        // 44. Băng qua cây cầu lớn - Lính gác: giết 100 Nhện Vàng + 100 Ma Ngụy Trang
        addQuest(44, "Băng qua cây cầu lớn", -7, -7, (byte)1, 41, 100,
            "Hãy tiêu diệt 100 con Nhện Vàng và 100 con Ma Ngụy Trang ở cây cầu nối với Thành Phố, giúp đỡ tên lính gác ở cổng phía Tây.",
            "Tiêu diệt Nhện Vàng và Ma Ngụy Trang rồi báo cáo Lính gác.",
            45, 22000, 44000, 220);

        // 45. Trận chiến với Sư tử sa mạc - Lính gác: giết 100 Sư Tử Sa Mạc (mob_id=44)
        addQuest(45, "Trận chiến với Sư tử sa mạc", -7, -20, (byte)1, 44, 100,
            "Băng qua cây cầu lớn từ cổng phía Tây thành phố để đến Hố Tử Thần. Thu thập 100 Sừng Sư Tử từ loài Sư Tử Sa mạc rồi mang về cho Emma.",
            "Thu thập 100 Sừng Sư Tử rồi mang về cho Emma.",
            46, 24000, 48000, 240);

        // 46. Nghĩa địa cát - Emma: giết 100 Ốc Sên Cát + 100 Thằn Lằn Đỏ
        addQuest(46, "Nghĩa địa cát", -20, -19, (byte)1, 45, 100,
            "Tiến lên vùng Nghĩa Địa Cát, săn 100 con Ốc Sên Cát và 100 con Thằn Lằn đỏ. Quay về báo cáo cho Benjamin.",
            "Săn 100 Ốc Sên Cát và 100 Thằn Lằn Đỏ rồi báo cáo Benjamin.",
            47, 25000, 50000, 250);

        // 47. Bóng tối trỗi dậy - Benjamin: giết 200 Lính Hắc Ám + 200 Sóc Gai
        addQuest(47, "Bóng tối trỗi dậy", -19, -21, (byte)1, 54, 200,
            "Từ Nghĩa Địa Cát, hãy đi về hướng Tây để đến vùng tiếp giáp với Hạ Giới hoặc hướng Đông là đường lên Thượng Giới. Tìm và tiêu diệt 200 tên Lính Hắc Ám và 200 con Sóc Gai. Trở về báo cáo Black Eye.",
            "Tiêu diệt 200 Lính Hắc Ám và Sóc Gai rồi báo cáo Black Eye.",
            48, 30000, 60000, 300);

        // 48. Ma lực Đá Linh Hồn - Black Eye: giết 200 Nấm Dạ Xoa (mob_id=58)
        addQuest(48, "Ma lực Đá Linh Hồn", -21, -21, (byte)1, 58, 200,
            "Hãy quay trở lại vùng đất giáp với Hạ Giới để thu thập 200 đá linh hồn từ lũ Nấm Dạ Xoa.",
            "Thu thập 200 Đá Linh Hồn từ Nấm Dạ Xoa rồi mang về cho Black Eye.",
            49, 32000, 64000, 320);

        // 49. Chuyến đi săn Rồng - Black Eye: giết 200 Rồng Bay (mob_id=61)
        addQuest(49, "Chuyến đi săn Rồng", -21, -21, (byte)1, 61, 200,
            "Hãy tìm Con Đường Hiểm Trở ở hướng Đông và săn loài Rồng Bay, nhặt 200 mảnh Đá Linh Hồn.",
            "Thu thập 200 mảnh Đá Linh Hồn từ Rồng Bay rồi mang về cho Black Eye.",
            50, 35000, 70000, 350);

        // 50. Tương Lai Thế Giới - Black Eye -> Benjamin (QUEST CUỐI)
        addQuest(50, "Tương Lai Thế Giới", -21, -19, (byte)0, -1, 0,
            "Hãy quay trở lại gặp Benjamin xem chuyện gì đã xảy ra với ông ấy.",
            "Đến gặp Benjamin.",
            0, 50000, 100000, 500); // quest cuối, nextQuestId = 0
    }

    private static void addQuest(int id, String name, int npcFrom, int npcTo, byte type, int mobId, int killCount,
                                  String desc, String detail, int nextQuestId, int rewardExp, int rewardVang, int rewardNgoc) {
        quests.add(new Quest(
            (short) id, true, name, (byte) npcFrom, desc, (byte) npcTo, detail, (short) nextQuestId,
            type, mobId, killCount, rewardExp, rewardVang, rewardNgoc
        ));
    }

    public static Quest getByNPC(byte npcId) {
        for (Quest q : quests) {
            if (q.npcFrom == npcId) return q;
        }
        return null;
    }

    public static Quest getById(short id) {
        for (Quest q : quests) {
            if (q.id == id) return q;
        }
        return null;
    }

    /** Lấy quest hiện tại của player */
    public static Quest getPlayerQuest(Player p) {
        if (p.questId <= 0) return null;
        return getById(p.questId);
    }

    /** questKill = -1 nghĩa là chưa chấp nhận nhiệm vụ hiện tại */
    public static boolean isQuestAccepted(Player p) {
        return p.questKill >= 0;
    }

    /** Kiểm tra quest đã hoàn thành chưa (chỉ check mục tiêu kill) */
    public static boolean isQuestComplete(Player p) {
        Quest q = getPlayerQuest(p);
        if (q == null) return false;
        if (!isQuestAccepted(p)) return false;
        if (q.type == 0) return false; // talk quest - hoàn thành khi gặp NPC đích
        if (q.type == 1) return p.questKill >= q.killCount;
        return false;
    }

    /** Player trả quest, nhận thưởng */
    public static void completeQuest(Player p) throws IOException {
        Quest q = getPlayerQuest(p);
        if (q == null) return;
        boolean canComplete = isQuestComplete(p) || (q.type == 0 && isQuestAccepted(p));
        if (!canComplete) {
            if (q.type == 1) {
                Service.send_notice_box(p.conn, "Chưa hoàn thành! " + p.questKill + "/" + q.killCount);
            }
            return;
        }
        // Phần thưởng
        if (q.rewardExp > 0) p.update_Exp(q.rewardExp, true);
        if (q.rewardVang > 0) p.update_vang(q.rewardVang);
        if (q.rewardNgoc > 0) p.update_ngoc(q.rewardNgoc);

        String reward = "Hoàn thành: " + q.name + "!\nPhần thưởng:";
        if (q.rewardExp > 0) reward += " +" + q.rewardExp + " EXP";
        if (q.rewardVang > 0) reward += " +" + q.rewardVang + " Vàng";
        if (q.rewardNgoc > 0) reward += " +" + q.rewardNgoc + " Ngọc";

        // Chuyển sang quest tiếp theo
        if (q.nextQuestId > 0) {
            p.questId = q.nextQuestId;
            p.questKill = -1; // quest mới ở trạng thái có thể nhận (!)
            Quest next = getById(q.nextQuestId);
            if (next != null) {
                reward += "\n\nNhiệm vụ mới: " + next.name;
            }
        } else {
            p.questId = -1;
            p.questKill = 0;
            reward += "\n\nĐã hoàn thành tất cả nhiệm vụ chính!";
        }
        Service.send_notice_box(p.conn, reward);
        Service.send_quest(p.conn);
    }

    /** Gọi khi player giết mob */
    public static void onMobKill(Player p, int mobId) throws IOException {
        Quest q = getPlayerQuest(p);
        if (q == null || q.type != 1) return;
        if (!isQuestAccepted(p)) return;
        if (q.mobId != mobId) return;
        if (p.questKill >= q.killCount) return;
        p.questKill++;
        if (p.questKill >= q.killCount) {
            // Hoàn thành mục tiêu - cập nhật dấu ? vàng trên NPC
            Service.send_quest(p.conn);
            Service.send_notice_box(p.conn, "Hoàn thành mục tiêu " + q.name + "!\nQuay lại gặp NPC để trả nhiệm vụ.");
        } else if (p.questKill % 5 == 0 || p.questKill == 1) {
            // Cập nhật tiến độ mỗi 5 con
            Service.send_quest_doing(p.conn, q, p.questKill);
        }
    }
}
