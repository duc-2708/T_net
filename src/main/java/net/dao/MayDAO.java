
package net.dao;
 import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import net.entity.may;
import net.utils.XJdbc;

public class MayDAO {
    public static List<may> ReadMay(){
        String sql = "SELECT * FROM May";
        List<may> mayLst = new ArrayList<>();
        try (Connection con = XJdbc.openConnection();
                PreparedStatement ps = con.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String IDMay = rs.getString("IDMay");
                boolean TrangThai = rs.getBoolean("TrangThai");
                float Gia = rs.getFloat("Gia");
                
                may may = new may(IDMay, TrangThai, Gia);
                mayLst.add(may);
            }
            return mayLst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mayLst;
    }
}
