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
public class HoaDon {
    private String IDHD;
    private LocalTime GioBatDau;
    private LocalTime GioKetThuc;
    private float TongGio;
    private float TongTien;
    private boolean TrangThai;
    private may may;
    private User user;
}
