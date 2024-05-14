package com.example.lab3_ph35419.bai8

import com.example.lab3_ph35419.bai7.CBGV

class QLMuonTra() {
    private val listTheMuon = mutableListOf<TheMuon>(
        TheMuon(
            "T01",
            10, 15, "HS5674",
            "Dương Đình Nam",
            16,
            "MD18301"
        ),
        TheMuon(
            "T02",
            12, 17, "HS5675",
            "Nguyễn Như Hiếu",
            18,
            "MD18306"
        )

    )

    fun getListTheMuon() {
        listTheMuon.forEach { tm ->
            println(
                "Id: ${tm.id_theMuon},tên: ${tm.hoTen},lớp: ${tm.lop},ngày mượn: ${tm.ngayMuon},ngày trả: ${tm.ngayTra},số hiệu : ${tm.soHieuSach}"
            )
        }
    }

    fun themTheMuon(theMuon: TheMuon) {
        listTheMuon.add(theMuon)
        println("Đã thêm thành công thẻ mượn !")
    }

    fun xoaTheMuon(id_The: String) {
        var found = false
        listTheMuon.find { it.id_theMuon == id_The }?.let {
            listTheMuon.remove(it)
            found = true
        }

        if (found) {
            println("Đã xóa thành công thẻ mượn!")
        } else {
            println("Không tìm thấy thẻ mượn với ID $id_The để xóa.")
        }
    }

}

fun main() {
    val QlThe = QLMuonTra()

    println("----------------MENU--------------")
    println("1.In danh sách")
    println("2.Thêm mới thẻ mượn")
    println("3.Xóa thẻ theo id")
    println("-----------------------------------")

    do {
        println("Mời chọn chức năng: ")

        var choice = readLine()?.toIntOrNull()
        when (choice) {
            1 -> {
                QlThe.getListTheMuon()
            }

            2 -> {
                println("Nhập thông tin mới cho thẻ mượn:")

                print("Id thẻ: ")
                val id_the = readLine() ?: "T000"
                print("Tên: ")
                val ten = readLine() ?: ""
                print("Tuổi: ")
                val tuoi = readLine()?.toIntOrNull() ?: 0
                print("Ngày mượn: ")
                val ngayMuon = readLine()?.toIntOrNull() ?: 10
                print("Ngày trả: ")
                val ngayTra = readLine()?.toIntOrNull() ?: 10
                print("Số hiệu: ")
                val soHieu = readLine() ?: "SH1000"

                print("Lớp: ")
                val lop = readLine() ?: "MD18300"

                val newTheMuon = TheMuon(id_the, ngayMuon, ngayTra, soHieu, ten, tuoi, lop)
                QlThe.themTheMuon(newTheMuon)

            }

            3 -> {
                println("Mời nhập mã thẻ muốn xóa: ")
                var id_the = readLine() ?: "fail"

                QlThe.xoaTheMuon(id_the)
            }

            else -> {
                "Lựa chọn ko hợp lệ, hãy nhập lại:"
            }
        }
    } while (true)
}