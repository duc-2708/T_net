package net.entity;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class HoaDonChiTiet {
    private String IDHDCT;
    private HoaDon hoaDon;
    private DichVu dichVu;
    private int SoLuong;
    private float Gia;
    private float ThanhTien;   
}
