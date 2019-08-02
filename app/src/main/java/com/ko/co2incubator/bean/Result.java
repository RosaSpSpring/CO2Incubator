package com.ko.co2incubator.bean;
import java.util.List;
/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public class Result {
    private String code;
    private String msg;
    private List<Cell> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Cell> getData() {
        return data;
    }

    public void setData(List<Cell> data) {
        this.data = data;
    }
}
