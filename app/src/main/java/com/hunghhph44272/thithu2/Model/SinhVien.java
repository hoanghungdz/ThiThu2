package com.hunghhph44272.thithu2.Model;

import java.util.Date;

public class SinhVien {
    String  _id,ma_sinh_vien,ten,gioi_tinh,ngay_sinh,khoa_hoc,lop;

    public SinhVien() {
    }

    public SinhVien( String ma_sinh_vien, String ten, String gioi_tinh, String ngay_sinh, String khoa_hoc, String lop) {

        this.ma_sinh_vien = ma_sinh_vien;
        this.ten = ten;
        this.gioi_tinh = gioi_tinh;
        this.ngay_sinh = ngay_sinh;
        this.khoa_hoc = khoa_hoc;
        this.lop = lop;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getMa_sinh_vien() {
        return ma_sinh_vien;
    }

    public void setMa_sinh_vien(String ma_sinh_vien) {
        this.ma_sinh_vien = ma_sinh_vien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(String gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getKhoa_hoc() {
        return khoa_hoc;
    }

    public void setKhoa_hoc(String khoa_hoc) {
        this.khoa_hoc = khoa_hoc;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
