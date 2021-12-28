package com.example.bookit.domain;

import java.io.Serializable;

public class Category implements Serializable {
    public static final Category[] CATEGORY_LIST = {
            new Category(101, "소설"),
            new Category(102, "에세이"),
            new Category(103, "예술"),
            new Category(104, "사회 / 정치"),
            new Category(105, "역사"),
            new Category(107, "잡지"),
            new Category(108, "만화"),
            new Category(109, "유아 / 청소년"),
            new Category(111, "가정 / 육아"),
            new Category(115, "국어 / 외국어"),
            new Category(116, "자연과학"),
            new Category(117, "경제 / 경영"),
            new Category(118, "자기계발"),
            new Category(119, "인문"),
            new Category(120, "종교"),
            new Category(123, "자격서 / 수험서"),
            new Category(125, "전공도서"),
            new Category(126, "건강 / 뷰티"),
            new Category(128, "여행"),
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
