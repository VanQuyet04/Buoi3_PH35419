package com.example.lab3_ph35419.bai7

class CBGV(
    hoten: String, tuoi: Int, quequan: String, id_gv: String,
    val luongCung: Float, val luongThuong: Float, val tienPhat: Float
) :
    Nguoi(hoten, tuoi, quequan, id_gv) {
    var luongThucLinh: Float = 0f


    fun tinhLuongThucLinh() {
        luongThucLinh = luongCung + luongThuong - tienPhat
    }


}