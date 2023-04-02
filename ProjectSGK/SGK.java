
package ProjectSGK;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SGK implements Serializable {
    public String maSach;
    public String tenSach;
    public int namXuatBan;
    public String nhaXuatBan;
    public int soLuong;
    public double giaSach;
    public Date ngayNhap,ngayXuat;


    public SGK() {
    }   
    public SGK(String maSach, String tenSach, int namXuatBan, String nhaXuatBan, int soLuong,double giaSach,Date ngayNhap) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.namXuatBan = namXuatBan;
        this.nhaXuatBan = nhaXuatBan;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
        this.giaSach = giaSach;
        
    }
    public String getMaSach() {
        return maSach;
    }
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
    public double getGiaSach() {
        return giaSach;
    }
    public void setGiaSach(double giaSach) {
        this.giaSach = giaSach;
    }
    public String getTenSach() {
        return tenSach;
    }
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
    public int getNamXuatBan() {
        return namXuatBan;
    }
    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }
    public String getNhaXuatBan() {
        return nhaXuatBan;
    }
    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }
    public Date getNgayNhap() {
        return ngayNhap;
    }
    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
  
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String ngayNhapLT = sdf.format(ngayNhap);
        return "Sach Ly Thuyet : " + "maSach=" + maSach + ", tenSach=" + tenSach + ", namXuatBan=" + namXuatBan + ", nhaXuatBan=" + nhaXuatBan + ", soLuong=" + soLuong+", don gia="+giaSach+", ngay nhap kho="+ngayNhapLT ;
    }
    public Date hien(int day,int month,int year){
        return this.ngayNhap;
    }
    public Date xuat(int day,int month,int year){
        return this.ngayXuat;
    }
    


}
