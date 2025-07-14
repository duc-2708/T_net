/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import net.dto.CategoryDichVu;
import net.entity.DichVu;
import net.entity.DichVuMay_Tam;
import net.entity.LoaiDichVu;
import net.utils.XJdbc;

public class DichVuDAO {

    public static List<LoaiDichVu> readLDV() {
        List<LoaiDichVu> loaiDichVuLst = new ArrayList<>();
        String sql = "select IDLoaiDV, TenLoaiDV\n"
                + "from LoaiDV";
        try (Connection con = XJdbc.openConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String IDLoaiDV = rs.getString("IDLoaiDV");
                String TenLoaiDV = rs.getString("TenLoaiDV");

                LoaiDichVu dichVu = new LoaiDichVu(IDLoaiDV, TenLoaiDV);
                loaiDichVuLst.add(dichVu);
            }
            return loaiDichVuLst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loaiDichVuLst;
    }

    public static List<DichVu> readDV(String IDLoaiDV) {
        String sql = "select  dv.IDDV, dv.TenDV, dv.gia\n"
                + "                from LoaiDV as LDV \n"
                + "                join DichVu as DV on ldv.IDLoaiDV = dv.IDLoaiDV\n"
                + "				where dv.IDLoaiDV = ?";
        List<DichVu> dichVuLst = new ArrayList<>();

        try (Connection con = XJdbc.openConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, IDLoaiDV);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String IDDV = rs.getString("IDDV");
                String TenDV = rs.getString("TenDV");
                float Gia = rs.getFloat("Gia");

                DichVu dichVu = new DichVu(IDDV, TenDV, Gia);
                dichVuLst.add(dichVu);
            }
            return dichVuLst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dichVuLst;
    }

    public static int orderDV(DichVuMay_Tam dvTam) {
        String sqlCheck = "SELECT * FROM DichVuMay_Tam WHERE IDDV = ? AND IDMay = ?";
        String sqlThem = "INSERT INTO DichVuMay_Tam VALUES (?, ?, ?, ?, ?, ?)";
        String sqlUpdate = "UPDATE DichVuMay_Tam SET SoLuong = SoLuong + ? WHERE IDDV = ? AND IDMay = ? ";

        try (Connection con = XJdbc.openConnection(); PreparedStatement psCheck = con.prepareStatement(sqlCheck);) {
            psCheck.setString(1, dvTam.getIdDV());
            psCheck.setString(2, dvTam.getIdMay());
            ResultSet rs = psCheck.executeQuery();

            if (rs.next()) {
                try (PreparedStatement psUpdate = con.prepareStatement(sqlUpdate);) {
                    psUpdate.setInt(1, dvTam.getSoLuong());
                    psUpdate.setString(2, dvTam.getIdDV());
                    psUpdate.setString(3, dvTam.getIdMay());
                                       
                    int ketQua = psUpdate.executeUpdate();
                    return ketQua;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try (PreparedStatement psThem = con.prepareStatement(sqlThem)) {
                    String IDTam = dvTam.getIdMay()+"_"+dvTam.getIdDV();
                    System.out.println("IDTam: " + IDTam);
System.out.println("IDLoaiDV: " + dvTam.getIdLoaiDV());
System.out.println("IDDV: " + dvTam.getIdDV());
System.out.println("IDMay: " + dvTam.getIdMay());
System.out.println("SoLuong: " + dvTam.getSoLuong());
System.out.println("Gia: " + dvTam.getGia());

                    psThem.setString(1, IDTam);
                    psThem.setString(2, dvTam.getIdLoaiDV());
                    psThem.setString(3, dvTam.getIdDV());
                    psThem.setString(4, dvTam.getIdMay());                                      
                    psThem.setInt(5, dvTam.getSoLuong());
                    psThem.setDouble(6, dvTam.getGia());
                    
                    int ketQua = psThem.executeUpdate();
                    return ketQua;
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
