package com.hwadee.common;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

public class StatusConverter implements Converter<String> {
    @Override
    public Class<String> supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public String convertToJavaData(ReadCellData cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }

    public WriteCellData<String> convertToExcelData(String value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return new WriteCellData<>(StatusEnum.getValue(value));
    }



    enum StatusEnum {
        NORMAL("1", "正常"),
        MAINTENANCE("2", "保修"),
        BROKEN("3", "损坏");
        private String code;
        private String value;

        StatusEnum(String code, String value) {
            this.code = code;
            this.value = value;
        }

        public static String getValue(String status) {
            StatusEnum[] values = values();
            for (StatusEnum value : values) {
                if (value.code.equals(status)) {
                    return value.value;
                }else {
                    return "未知";
                }
            }
            return "";
        }
    }
}
