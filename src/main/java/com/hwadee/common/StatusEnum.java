package com.hwadee.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum StatusEnum {
    /**
     * 未知
     */
    UNKNOWN(0, "未知"),

    /**
     * 正常
     */
    NORMAL(1, "正常"),

    /**
     * 保修
     */
    MAINTENANCE(2, "保修"),

    /**
     * 损坏
     */
    DAMAGE(3, "损坏");

    private final Integer value;

    @JsonFormat
    private final String description;

    public static StatusEnum convert(Integer value) {
        return Stream.of(values())
                .filter(bean -> bean.value.equals(value))
                .findAny()
                .orElse(UNKNOWN);
    }

    public static StatusEnum convert(String description) {
        return Stream.of(values())
                .filter(bean -> bean.description.equals(description))
                .findAny()
                .orElse(UNKNOWN);
    }
}
