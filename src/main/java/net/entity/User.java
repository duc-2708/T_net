package net.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class User {
    private String TenNV;
    private String TenDangNhap;
    private String MatKhau;
    private boolean VaiTro;
}
