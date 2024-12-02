/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDate;


/**
 *
 * @author ASUS
 */
public class BaiXeDTO {
    private String maVe;
    private String bienSo;
    private String loaiXe;
    private String viTri;
    private LocalDate ngayGui;
    private String gioGui;

    public BaiXeDTO() {
    }

    public BaiXeDTO(String maVe, String bienSo, String loaiXe, String viTri, LocalDate ngayGui, String gioGui) {
        this.maVe = maVe;
        this.bienSo = bienSo;
        this.loaiXe = loaiXe;
        this.viTri = viTri;
        this.ngayGui = ngayGui;
        this.gioGui = gioGui;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public LocalDate getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(LocalDate ngayGui) {
        this.ngayGui = ngayGui;
    }

    public String getGioGui() {
        return gioGui;
    }

    public void setGioGui(String gioGui) {
        this.gioGui = gioGui;
    }

    
}
