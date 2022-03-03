package kr.books.bitbooks.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum CategoryTypeEnum {
    NOVEL("00", "소설"),
    Foreign("01", "외국어"),
    HOBBY("02", "취미"),
    JOB("03", "직업"),
    COOKING("04", "요리");

    private String key;
    private String value;

    CategoryTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @JsonCreator
    public static CategoryTypeEnum value(String key) {
        return Arrays.stream(CategoryTypeEnum.values())
                .filter((var status) -> status.getKey().equals(key))
                .findFirst()
                .orElse(null);
    }

    @JsonValue
    public String getKey() {
        return key;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
