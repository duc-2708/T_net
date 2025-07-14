package net.utils;

import java.sql.*;

public class Auth {

    public static boolean DangNhap(String TenDangNhap, String MatKhau) {
        String sql = "SELECT * FROM NhanVien WHERE TenDangNhap = ? and MatKhau = ?";
        try (Connection con = XJdbc.openConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

            ps.setString(1, TenDangNhap);
            ps.setString(2, MatKhau);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GlobalState.VaiTro = rs.getBoolean("VaiTro");
                GlobalState.TenNV = rs.getString("TenNV");
                return true;
            }
            return false;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
