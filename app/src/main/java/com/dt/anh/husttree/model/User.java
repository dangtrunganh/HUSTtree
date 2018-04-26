package com.dt.anh.husttree.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by trunganh on 4/27/18.
 */

public class User implements Parcelable{
    private String id;
    private String gioi_tinh;
    private String role;
    private String name;
    private String mat_khau;
    private DetailUser detailUser;


//    public User(String id, String gioi_tinh, String role, String name, String mat_khau, DetailUser detailUser) {
//        this.id = id;
//        this.gioi_tinh = gioi_tinh;
//        this.role = role;
//        this.name = name;
//        this.mat_khau = mat_khau;
//        this.detailUser = detailUser;
//    }

    public User(String gioi_tinh, String role, String name, String mat_khau) {
        this.gioi_tinh = gioi_tinh;
        this.role = role;
        this.name = name;
        this.mat_khau = mat_khau;
    }

    public User() {
    }

    protected User(Parcel in) {
        id = in.readString();
        gioi_tinh = in.readString();
        role = in.readString();
        name = in.readString();
        mat_khau = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(String gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMat_khau() {
        return mat_khau;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }

    public DetailUser getDetailUser() {
        return detailUser;
    }

    public void setDetailUser(DetailUser detailUser) {
        this.detailUser = detailUser;
    }

    @Override
    public String toString() {
        return "id_user: " + id + "\n" +
                "gioi_tinh: " + gioi_tinh + "\n" +
                "role: " + role + "\n" +
                "name: " + name + "\n" +
                "mat_khau: " + mat_khau + "\n" +
//                "detail_user: " + detailUser.toString() + "\n" +
                "===================" + "\n";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(gioi_tinh);
        dest.writeString(role);
        dest.writeString(name);
        dest.writeString(mat_khau);
    }
}
