package com.w.attendance.exception;

/**
 * 业务异常
 *
 * @author linkai(31876) xmlinkai@gmail.com
 * @since 2019-05-22 09:10
 */
public class BusinessException extends RuntimeException {

    private final String msg;
    private final int code;
    /**
     * 目前只有中台的错误才有tip
     */
    private final String tip;

    public BusinessException(BusinessError businessError) {
        super(businessError.toString());
        this.msg = businessError.getMsg();
        this.code = businessError.getCode();
        this.tip = null;
    }

    public BusinessException(BusinessError businessError, String tip) {
        super(businessError.toString());
        this.msg = businessError.getMsg();
        this.code = businessError.getCode();
        this.tip = tip;
    }

    public BusinessException(int code, String msg, String tip) {
        this.code = code;
        this.msg = msg;
        this.tip = tip;
    }

    public BusinessException(BusinessError businessError, Throwable cause) {
        super(businessError.toString(), cause);
        this.msg = businessError.getMsg();
        this.code = businessError.getCode();
        this.tip = null;
    }

    public String getMsg() {
        return msg;
    }

    public String getTip() {
        return tip;
    }

    public int getCode() {
        return code;
    }

    public boolean hasTip() {
        return tip != null && tip.length() > 0;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
            "msg='" + msg + '\'' +
            ", code=" + code +
            ", tip='" + tip + '\'' +
            '}';
    }
}
