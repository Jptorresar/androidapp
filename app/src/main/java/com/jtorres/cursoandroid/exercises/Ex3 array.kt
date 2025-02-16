package com.jtorres.cursoandroid.exercises

fun main() {
    inmutableList()
}

fun arrays(){
    //Arrays
    val weekDays = arrayOf("Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo")
    for (i in weekDays){
        println("$i")
    }

    for ((pos,value) in weekDays.withIndex()){
        println("Pos: $pos Val: $value")
    }
}

fun inmutableList(){
    //List
    val readOnly:List<String> = listOf("Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo")
    println(readOnly)
    println(readOnly[0])
}