package com.dt.anh.husttree.model;

/**
 * Created by trunganh on 4/27/18.
 */

public class Tree {
    private String idTree;
    private String loai;
    private String nuoc_htai;
    private String nuoc_max;
    private String ten;
    private String x;
    private String y;


    public Tree(String loai, String nuoc_htai, String nuoc_max, String ten, String x, String y) {
        this.loai = loai;
        this.nuoc_htai = nuoc_htai;
        this.nuoc_max = nuoc_max;
        this.ten = ten;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "loai: " + loai + "\n" +
                "nuoc_htai: " + nuoc_htai + "\n" +
                "nuoc_max: " + nuoc_max + "\n" +
                "ten: " + ten + "\n" +
                "x: " + x + "\n" +
                "y: " + y + "\n" + "" +
                "==============" + "\n";
    }

    public String getIdTree() {
        return idTree;
    }

    public void setIdTree(String idTree) {
        this.idTree = idTree;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getNuoc_htai() {
        return nuoc_htai;
    }

    public void setNuoc_htai(String nuoc_htai) {
        this.nuoc_htai = nuoc_htai;
    }

    public String getNuoc_max() {
        return nuoc_max;
    }

    public void setNuoc_max(String nuoc_max) {
        this.nuoc_max = nuoc_max;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}
