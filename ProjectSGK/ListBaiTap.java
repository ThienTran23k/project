package ProjectSGK;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.Scanner;

public class ListBaiTap {
    public ArrayList<BaiTap> list2;
    BaiTap BT = new BaiTap();

    public ListBaiTap() {
        this.list2 = new ArrayList<BaiTap>();
    }

    public ListBaiTap(ArrayList<BaiTap> list2) {
        this.list2 = list2;

    }

    // 1.Thêm sách vào kho sách Bài Tập
    public void themSBT(BaiTap tvst){
        this.list2.add(tvst);
    }

    //2.In ra sách Bài tập
    public void inSBT() {
        for (BaiTap SachBT : list2) {
            System.out.println(SachBT);
        }
        
    }


    //3.Đếm số lượng sách bài tập 
    public int demSBT() {
        return this.list2.size();
    }

    //4.Tìm tên sách bài tập
    public void timSBT(String ten) {
        for (BaiTap SachBT : list2) {
            if (SachBT.getTenSach().contains(ten)) {
                System.out.println(SachBT);
            }
        }
    }

    //5.Sắp xếp lại sách bài tập
    public void sapXepSBT() {
        Collections.sort(this.list2, new Comparator<BaiTap>() {
            @Override
            public int compare(BaiTap sl1, BaiTap sl2) {
                if (sl1.getSoLuong() < sl2.getSoLuong()) {
                    return 1;
                } else if (sl1.getSoLuong() > sl2.getSoLuong()) {
                    return -1;

                } else {
                    return 0;
                }
            }
        });
    }

    //6.Sửa thông tin sách Bài tập
    public void suaSBT() {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------- SUA THONG TIN SACH  BAI TAP --------------");
        System.out.println("Ma Sach : ");
        String id = input.nextLine();

        for (int i = 0; i < list2.size(); i++) {
            if (id.equals(list2.get(i).getMaSach())) {
                System.out.println("-------------- BAT DAU --------------");
                System.out.print("Nhap ma sach : "); String ma = input.nextLine();
                System.out.print("Nhap ten sach : "); String ten = input.nextLine();
                System.out.print("Nhap nha xuat ban sach : "); String nhaXB = input.nextLine();
                System.out.print("Nhap nam xuat ban sach: "); int namXB = input.nextInt();
                if(namXB<0){
                    System.out.print(" Hay nhap lai nam xuat ban sach : ");
                    namXB = input.nextInt();    
                }
                System.out.println("-------------- NHAP KHO --------------");
                System.out.print("Ngay:"); int day = input.nextInt();
                System.out.print("Thang:"); int month = input.nextInt();
                System.out.print("Nam:"); int year = input.nextInt();
                BT.hien(day, month, year);
                System.out.print("Nhap so luong sach Bai Tap : "); int soLuong = input.nextInt();
                if(soLuong<0){
                    System.out.print(" Hay nhap lai so luong : ");
                    soLuong = input.nextInt();    
                }
                System.out.print("Nhap gia sach : "); double gia = input.nextDouble();
                if(gia<0){
                    System.out.print(" Hay nhap lai gia tien :  ");
                    gia = input.nextDouble();    
                }
                list2.get(i).setMaSach(ma);
                list2.get(i).setTenSach(ten);
                list2.get(i).setNhaXuatBan(nhaXB);
                list2.get(i).setNamXuatBan(namXB);
                list2.get(i).setSoLuong(soLuong);
                list2.get(i).setGiaSach(gia);
                list2.get(i).setNgayNhap(BT.getNgayNhap());

                
            }
        }
    }

    //7. Xóa sách Bài tập
    public void xoaSBT() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ma sach can xoa : ");
        String id = input.nextLine();

        int d = -1;
        boolean position = false;
        for (int i = 0; i < list2.size(); i++) {
            if (id.equals(list2.get(i).getMaSach())) {
                position = true;
                d = i;
                break;
            }
        }
        
        if (position == false) {
            System.out.println("----Khong tim thay----");
        } else {
            list2.remove(d);
            System.out.println("----Da Xoa Thanh Cong----\n");
        }
       
    }

    //8.Lưu
    public void luuSBT(File file) {
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (BaiTap SachBT : list2) {
                bw.newLine();
                bw.write(SachBT.toString());
                bw.newLine();
            }
            bw.close();
            System.out.println("------- Luu Thanh Cong -------\n");
        } catch (Exception e) {
        }
    }

    //9.Đọc
    public void docSBT(File file) {
        try {

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] info = line.split("[|]");
                String ma = info[0].trim();
                String ten = info[1].trim();
                String nhaXB = info[2].trim();
                int namXB = Integer.parseInt(info[4].trim());
                int soLuong = Integer.parseInt(info[5].trim());
                double gia = Double.parseDouble(info[6].trim());
                int day = Integer.parseInt(info[7].trim());
                int month = Integer.parseInt(info[8].trim());
                int year = Integer.parseInt(info[9].trim());

                
                list2.add(new BaiTap(ma, ten, namXB, nhaXB, soLuong,gia,BT.hien(day, month, year)));
            }

        } catch (Exception e) {
        }
    }
        //10."-------------- Xuất kho --------------"
       public void xuatSBT(){
        Scanner input = new Scanner(System.in);
        System.out.println("-------------- XUAT KHO --------------");
        System.out.println("Ma sach can xuat kho : ");
        String id =  input.nextLine();
        boolean position = false;
        int d=-1;
        for(int i = 0;i < list2.size();i++){
            if(id.equals(list2.get(i).getMaSach())){
            position = true;
            d=i;
            do{
                System.out.println("Nhap ngay xuat kho: ");
                System.out.print("Ngay:");  int day = input.nextInt();
                System.out.print("Thang:");  int month = input.nextInt();
                System.out.print("Nam:");  int year = input.nextInt();
                BT.xuat(day, month, year);
                if(list2.get(i).getNgayNhap().compareTo(BT.ngayXuat)>0){
                    System.out.println("Nhap lai:");
                }
           }while(list2.get(i).getNgayNhap().compareTo(BT.ngayXuat)>0);
                System.out.println("Nhap so sach Bai Tap  can xuat : ");
                int xKho = input.nextInt();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String nXuat = sdf.format(BT.ngayXuat);
                String ngayNhapBT = sdf.format(list2.get(i).getNgayNhap());
                System.out.println("Ma sach : "+ id +", Nhap ngay : "+ngayNhapBT+", Xuat ngay :"+nXuat+", So luong xuat kho : "+xKho+", Sach bai tap con lai :"+(list2.get(i).getSoLuong()-xKho)+", So tien sach : "+xKho*0.8*list2.get(i).getGiaSach());
                list2.get(i).setSoLuong(list2.get(i).getSoLuong()-xKho);
                            try {
            FileWriter fw = new FileWriter("Xuat_Sach_BT.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Ma sach : "+ id +", Ngay nhap: "+ngayNhapBT+", Ngay xuat : "+nXuat+", So luong xuat : "+xKho+", Con lai : "+(list2.get(i).getSoLuong()-xKho)+", so tien hang: "+xKho*0.8*list2.get(i).getGiaSach());
            bw.newLine();
            bw.close();
           } catch (Exception e) {
           }
           }    
       }if(position==false){
                System.out.println("---------------Khong Tim Thay---------------");}
       else if(list2.get(d).getSoLuong()==0){
           list2.remove(d);
       }
    }
}
