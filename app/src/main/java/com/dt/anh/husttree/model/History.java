package com.dt.anh.husttree.model;

/**
 * Created by trunganh on 4/27/18.
 */

public class History {
    private String idHistory;
    private String status;
    private String time;
    private String tree_id;
    private String user_id;
    private String water;

    public History(String status, String time, String tree_id, String user_id, String water) {
        this.status = status;
        this.time = time;
        this.tree_id = tree_id;
        this.user_id = user_id;
        this.water = water;
    }

    @Override
    public String toString() {
        return "idHistory: " + idHistory + "\n" +
                "status: " + status + "\n" +
                "time: " + time + "\n" +
                "tree_id: " + tree_id + "\n" +
                "user_id: " + user_id + "\n" +
                "water: " + water + "\n" +
                "===================" + "\n";
    }

    public String getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(String idHistory) {
        this.idHistory = idHistory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTree_id() {
        return tree_id;
    }

    public void setTree_id(String tree_id) {
        this.tree_id = tree_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }
}
