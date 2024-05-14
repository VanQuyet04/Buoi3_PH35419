package com.example.lab3_ph35419.bai7

class QLGV() {

    private val listGV = mutableListOf<CBGV>(
        CBGV("Nguyễn Văn A", 35, "Hà Nội", "GV001", 5000000f, 1000000f,200000f),
        CBGV("Trần Thị B", 40, "Hải Phòng", "GV002", 6000000f, 1500000f, 300000f)
    )

    fun getListGV() {
        listGV.forEach { gv ->
            println("Id: ${gv.id_gv},Tên gv: ${gv.hoTen}, Tuổi: ${gv.tuoi}, Quê quán: ${gv.queQuan}, Lương thục lĩnh: ${gv.luongThucLinh} ")
        }

    }

    fun themCBGV(cbgv: CBGV) {
        listGV.add(cbgv)
        println("Thêm thành công CBGV !")

    }

    fun xoaCBGV(id_gv: String) {
        listGV.remove(listGV.find { it.id_gv == id_gv })
        println("Xóa thành công CBGV !")
    }

}

fun main() {
    println("----------------MENU----------------")
    println("1.In danh sách")
    println("2.Thêm mới cán bộ gv")
    println("3.Xóa cán bộ gv theo id")
    println("------------------------------------")

    val QL = QLGV()

    do {
        println("Mời chọn chức năng")
        var choice = readLine()?.toIntOrNull()
        when (choice) {
            1 -> {
                println("Danh sách các cán bộ giáo viên:")
                QL.getListGV()
            }

            2 -> {
                println("Nhập thông tin mới cho cán bộ giáo viên:")
                print("Tên: ")
                val ten = readLine() ?: ""
                print("Tuổi: ")
                val tuoi = readLine()?.toIntOrNull() ?: 0
                print("Quê quán: ")
                val queQuan = readLine() ?: ""
                print("ID: ")
                val id = readLine() ?: ""
                print("Lương cứng: ")
                val luongCung = readLine()?.toFloatOrNull() ?: 0f
                print("Lương thưởng: ")
                val luongThuong = readLine()?.toFloatOrNull() ?: 0f
                print("Tiền phạt: ")
                val tienPhat = readLine()?.toFloatOrNull() ?: 0f
                val newGV = CBGV(ten, tuoi, queQuan, id, luongCung, luongThuong, tienPhat)
                newGV.tinhLuongThucLinh()
                QL.themCBGV(newGV)
            }

            3 -> {
                println("Nhập ID của cán bộ giáo viên cần xóa:")
                val id = readLine() ?: ""
                QL.xoaCBGV(id)
            }

            else -> println("Lựa chọn không hợp lệ!")
        }
    } while (true)


}