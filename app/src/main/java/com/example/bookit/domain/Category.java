package com.example.bookit.domain;

import java.io.Serializable;

public class Category implements Serializable {
    public static final Category[] CATEGORY_LIST = {
            new Category(100, "국내도서"),
            new Category(101, "국내도서>소설"),
            new Category(102, "국내도서>시/에세이"),
            new Category(103, "국내도서>예술/대중문화"),
            new Category(104, "국내도서>사회과학"),
            new Category(105, "국내도서>역사와 문화"),
            new Category(107, "국내도서>잡지"),
            new Category(108, "국내도서>만화"),
            new Category(109, "국내도서>유아"),
            new Category(110, "국내도서>아동"),
            new Category(111, "국내도서>가정과 생활"),
            new Category(112, "국내도서>청소년"),
            new Category(113, "국내도서>초등학습서"),
            new Category(114, "국내도서>고등학습서"),
            new Category(115, "국내도서>국어/외국어/사전"),
            new Category(116, "국내도서>자연과 과학"),
            new Category(117, "국내도서>경제경영"),
            new Category(118, "국내도서>자기계발"),
            new Category(119, "국내도서>인문"),
            new Category(120, "국내도서>종교/역학"),
            new Category(122, "국내도서>컴퓨터/인터넷"),
            new Category(123, "국내도서>자격서/수험서"),
            new Category(124, "국내도서>취미/레저"),
            new Category(125, "국내도서>전공도서/대학교재"),
            new Category(126, "국내도서>건강/뷰티"),
            new Category(128, "국내도서>여행"),

            new Category(200, "외국도서"),
            new Category(201, "외국도서>어린이"),
            new Category(203, "외국도서>ELT/사전"),
            new Category(205, "외국도서>문학"),
            new Category(206, "외국도서>경영/인문"),
            new Category(207, "외국도서>예술/디자인"),
            new Category(208, "외국도서>실용"),
            new Category(209, "외국도서>해외잡지"),
            new Category(210, "외국도서>대학교재/전문서적"),
            new Category(211, "외국도서>컴퓨터"),
            new Category(214, "외국도서>일본도서"),
            new Category(215, "외국도서>프랑스도서"),
            new Category(216, "외국도서>중국도서"),
            new Category(217, "외국도서>해외주문원서"),

            new Category(300, "음반"),
            new Category(301, "음반>가요"),
            new Category(302, "음반>Pop"),
            new Category(303, "음반>Rock"),
            new Category(304, "음반>일본음악"),
            new Category(305, "음반>World Music"),
            new Category(306, "음반>Jazz"),
            new Category(307, "음반>클래식"),
            new Category(308, "음반>국악"),
            new Category(309, "음반>뉴에이지/명상"),
            new Category(310, "음반>O.S.T"),
            new Category(311, "음반>종교음악"),
            new Category(312, "음반>유아/아동/태교"),
            new Category(313, "음반>수입음반"),
            new Category(314, "음반>액세서리/관련상품"),
            new Category(315, "음반>뮤직 DVD"),
            new Category(314, "음반>액세서리/관련상품"),
            new Category(315, "음반>뮤직 DVD"),
            new Category(319, "음반>해외구매"),
            new Category(320, "음반>LP"),

            new Category(400, "DVD"),
            new Category(409, "DVD>애니메이션"),
            new Category(411, "DVD>다큐멘터리"),
            new Category(412, "DVD>TV시리즈"),
            new Category(417, "DVD>건강/취미/스포츠"),
            new Category(425, "DVD>영화"),
            new Category(426, "DVD>해외구매"),
            new Category(427, "DVD>기타"),
            new Category(428, "DVD>블루레이"),
            new Category(429, "DVD>유아동/교육DVD"),
            new Category(430, "DVD>EBS 교육용"),
    };

    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Category getCategoryById(int id) {
        for(int i = 0; i < CATEGORY_LIST.length; i++) {
            Category category = CATEGORY_LIST[i];

            if(category.getId() == id) return category;
        }

        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
