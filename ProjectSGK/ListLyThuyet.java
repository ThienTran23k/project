
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


public class ListLyThuyet {
    LyThuyet lt = new LyThuyet();
    private ArrayList<LyThuyet> list1;
    
    public ListLyThuyet() {
        this.list1 = new ArrayList<LyThuyet>();

    }

    public ListLyThuyet(ArrayList<LyThuyet> list1) {
        this.list1 = list1;

    }
    //1.Thêm sách vào kho Sách Lý Thuyết
    public void themSLT(LyThuyet sachLT){
        this.list1.add(sachLT);

    }
    //2.  In ra số lượng sách lý thuyết
    public void inSLT(){
        for(LyThuyet SachLT : list1){
            System.out.println(SachLT+"\n");   
    }
    }
    //3.Đếm số lượng sách lý thuyết
    public int demSLT(){
        
        return this.list1.size();
        
    }
    //4.Tìm kiếm sách lý thuyết
    public void timSLT(String tenSach){
        for(LyThuyet SachLT : list1){
            if(SachLT.getTenSach().contains(tenSach)){
               System.out.println(SachLT);
            }
        }
    }
    //5.Sắp xếp lại sách lý thuyết
     public void SXSLT(){
        Collections.sort(this.list1, new Comparator<LyThuyet>(){
            @Override
            public int compare(LyThuyet sl1, LyThuyet sl2) {
                if(sl1.getSoLuong()<sl2.getSoLuong()){
                    return 1;
                }else if(sl1.getSoLuong()>sl2.getSoLuong()){
                    return -1;
                    
                }else {
                    return 0;
                }          
            }   
    });
    }
     //6.Sửa thông tin sách lý thuyết
    public void suaSLT(){
        Scanner input = new Scanner(System.in);
        System.out.println("-------------- SUA THONG TIN SACH LY THUYET --------------");
        System.out.println("Ma Sach : ");
        String ma =  input.nextLine();

        for(int i = 0;i < list1.size();i++){
            if(ma.equals(list1.get(i).getMaSach())){
                System.out.println("-------------- BAT DAU --------------");
                System.out.print("Nhap ma sach moi :"); String masach = input.nextLine();
                System.out.print("Nhap ten sach : "); String tenSach = input.nextLine();
                System.out.print("Nhap nha xuat ban sach : "); String nhaXuatBan = input.nextLine();               
                System.out.print("Nhap nam xuat ban sach : "); int namXuatBan = input.nextInt();
                if(namXuatBan<0){
                    System.out.print(" Hay nhap lai nam xuat ban : ");
                    namXuatBan = input.nextInt();    
                }
                System.out.println("-------------- NHAP KHO --------------");
                System.out.print("ngay:"); int day = input.nextInt();
                System.out.print("thang:"); int month = input.nextInt();
                System.out.print("nam:"); int year = input.nextInt();
                lt.hien(day, month, year);
                System.out.print("Nhap so luong sach ly thuyet : "); int soLuong = input.nextInt();
                if(soLuong<0){
                    System.out.print(" Hay nhap lai so luong sach ly thuyet");
                    soLuong = input.nextInt();    
                }
                System.out.print("Nhap gia tien sach ly thuyet : "); double giaSach = input.nextDouble();
                if(giaSach<0){
                    System.out.print("Nhap lai gia tien cua sach ly thuyet: ");
                    giaSach = input.nextDouble();    
                }

                list1.get(i).setMaSach(masach);
                list1.get(i).setTenSach(tenSach);
                list1.get(i).setNhaXuatBan(nhaXuatBan);
                list1.get(i).setNamXuatBan(namXuatBan);
                list1.get(i).setSoLuong(soLuong);
                list1.get(i).setGiaSach(giaSach);
                list1.get(i).setNgayNhap(lt.getNgayNhap());


            }
        }
    }
    //7. Xóa sách lý thuyết
    public void xoaSLT(){
        Scanner input = new Scanner(System.in);
        System.out.println("nhap vao Ma Sach can xoa : ");
        String maSach =  input.nextLine();
        int d=-1;
        boolean position = false;
        for(int i = 0;i < list1.size();i++){
            if(maSach.equals(list1.get(i).getMaSach())){
                position = true;
                d = i;
                break;                 
        }
        }
        if(position==false) System.out.println("khong tim thay Ma Sach ");
        else{
            list1.remove(d);
            System.out.println("Xoa thanh cong");
        }
    }
       //8.Lưu file
        public void luuSLT(File file){
        try{
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
        for(LyThuyet SachLT : list1){
            bw.newLine();
            bw.write(SachLT.toString());
            bw.newLine();
        }   
        bw.close();
        System.out.println("Xuat file hoan tat");
    }catch (Exception e){
    }
    }
    //9.Đọc file
       public void docSLT(File file){
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while(true){
                String line = br.readLine();
                if(line == null) break;
                String[] info = line.split("[|]");
                String maSach = info[0].trim();
                String tenSach = info[1].trim();
                String nhaXuatBan = info[2].trim();                        
                int namXuatBan = Integer.parseInt(info[3].trim());
                int soLuong = Integer.parseInt(info[4].trim());
                double giaSach = Double.parseDouble(info[5].trim());
                int year = Integer.parseInt(info[6].trim());
                int month = Integer.parseInt(info[7].trim());
                int day = Integer.parseInt(info[8].trim());
                list1.add(new LyThuyet(maSach,tenSach,nhaXuatBan,namXuatBan,soLuong,giaSach,lt.hien(year, month, day)));
            }
    }catch (Exception e){
    }
    }
    //10."-------------- Xuất kho --------------"

       public void xuatSLT(){
        Scanner input = new Scanner(System.in);
        System.out.println("-------------- XUAT KHO --------------");
        System.out.println("Ma sach can xuat kho : ");
        String maSach =  input.nextLine();
        boolean position = false;
        int d=-1;
        for(int i = 0;i < list1.size();i++){
            if(maSach.equals(list1.get(i).getMaSach())){
            position = true;
            d=i;
            do{
                System.out.println("Nhap ngay xuat kho : ");
                System.out.print("Ngay:");  int day = input.nextInt();
                System.out.print("Thang:");  int month = input.nextInt();
                System.out.print("Nam:");  int year = input.nextInt();
                lt.xuat(day, month, year);
                if(list1.get(i).getNgayNhap().compareTo(lt.ngayXuat)>0){
                    System.out.println("Nhap lai :");
                }
           }while(list1.get(i).getNgayNhap().compareTo(lt.ngayXuat)>0);
                System.out.println("Nhap -so sach- can xuat kho");
                int xKho = input.nextInt();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String nXuat = sdf.format(lt.ngayXuat);
                String ngayNhapLT = sdf.format(list1.get(i).getNgayNhap());
                System.out.println("Ma sach ="+ maSach +", Ngay nhap="+ngayNhapLT+", Ngay xuat="+nXuat+", so luong xuat kho: "+xKho+", so luong hang con lai:"+(list1.get(i).getSoLuong()-xKho)+", so tien hang: "+(double)(xKho*0.8*list1.get(i).getGiaSach()));
                list1.get(i).setSoLuong(list1.get(i).getSoLuong()-xKho);
            try {
            FileWriter fw = new FileWriter("Xuat_Sach_Ly_Thuyet.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Ma sach ly thuyet = "+ maSach +", Ngay nhap="+ngayNhapLT+", Ngay xuat="+nXuat+", so luong xuat kho: "+xKho+", so luong hang con lai:"+(list1.get(i).getSoLuong()-xKho)+", so tien hang: "+(double)(xKho*0.8*list1.get(i).getGiaSach()));
            bw.newLine();
            bw.close();
           } catch (Exception e) {
           }
           }    
       }if(position==false){
                System.out.println("---------------Khong Tim Thay---------------");}
       else if(list1.get(d).getSoLuong()==0){
           list1.remove(d);
       }
           
       
    }     

}
