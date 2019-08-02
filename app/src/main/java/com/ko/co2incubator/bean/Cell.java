package com.ko.co2incubator.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public class Cell implements Comparable, Serializable {


    private static final long serialVersionUID = -7234227744684702453L;
    private String id;
    private String cid;
    private String name;
    private String gen;
    private int num;
    private String his;
    private String op_type;
    private String op_date;
    private String i_date;
    private String oper;
    private String locs;
    private List<Cell> children = new ArrayList<Cell>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getHis() {
        return his;
    }

    public void setHis(String his) {
        this.his = his;
    }

    public String getOp_type() {
        return op_type;
    }

    public void setOp_type(String op_type) {
        this.op_type = op_type;
    }

    public String getOp_date() {
        return op_date;
    }

    public void setOp_date(String op_date) {
        this.op_date = op_date;
    }

    public String getI_date() {
        return i_date;
    }

    public void setI_date(String i_date) {
        this.i_date = i_date;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getLocs() {
        return locs;
    }

    public void setLocs(String locs) {
        this.locs = locs;
    }

    public List<Cell> getChildren() {
        return children;
    }

    public void setChildren(List<Cell> children) {
        this.children = children;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        if ( o instanceof Cell){
            Cell cell = (Cell) o;
           return -this.op_date.compareTo(cell.op_date);
        }
        throw new RuntimeException("传入数据类型不一致");
    }


}
