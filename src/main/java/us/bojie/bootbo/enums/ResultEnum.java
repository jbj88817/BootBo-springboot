package us.bojie.bootbo.enums;

public enum ResultEnum {
    UNKNOWN_ERROR(-1,"UNKNOWN_ERROR"),
    SUCCESS(0, "SUCCESS"),
    PRIMARY_SCHOOL(100, "You're at element"),
    MIDDEL_SCHOOL(101, "You're at mid-school")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
