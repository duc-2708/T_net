
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
public class DichVuMay_Tam {
    private String idMay;
    private String idDV;
    private String tenDV;
    private String idLoaiDV;
    private int soLuong;
    private double gia;

}
