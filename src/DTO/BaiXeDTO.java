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
    private LocalDate ngayTra;
    private String gioTra;
    private int giaTien;

    public BaiXeDTO() {
    }

    public BaiXeDTO(String maVe, String bienSo, String loaiXe, String viTri, LocalDate ngayGui, String gioGui, LocalDate ngayTra, String gioTra, int giaTien) {
        this.maVe = maVe;
        this.bienSo = bienSo;
        this.loaiXe = loaiXe;
        this.viTri = viTri;
        this.ngayGui = ngayGui;
        this.gioGui = gioGui;
        this.ngayTra = ngayTra;
        this.gioTra = gioTra;
        this.giaTien = giaTien;
    }

    public BaiXeDTO(String maVe, String bienSo, String loaiXe, String viTri, LocalDate ngayGui, String gioGui) {
        this.maVe = maVe;
        this.bienSo = bienSo;
        this.loaiXe = loaiXe;
        this.viTri = viTri;
        this.ngayGui = ngayGui;
        this.gioGui = gioGui;
    }


    public BaiXeDTO(String maVe, String bienSo, String loaiXe, LocalDate ngayGui, String gioGui) {
        this.maVe = maVe;
        this.bienSo = bienSo;
        this.loaiXe = loaiXe;
        this.ngayGui = ngayGui;
        this.gioGui = gioGui;
    }
    
    

    public BaiXeDTO(LocalDate ngayTra, String gioTra, int giaTien) {
        this.ngayTra = ngayTra;
        this.gioTra = gioTra;
        this.giaTien = giaTien;
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

    public LocalDate getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(LocalDate ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getGioTra() {
        return gioTra;
    }

    public void setGioTra(String gioTra) {
        this.gioTra = gioTra;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }
    
    

    
}
