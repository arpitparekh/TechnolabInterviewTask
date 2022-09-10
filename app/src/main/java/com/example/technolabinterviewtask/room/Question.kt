package com.example.technolabinterviewtask.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Question(
    @ColumnInfo(name = "question")
    val question : String,
    @ColumnInfo(name = "op1")
    val op1 : String,
    @ColumnInfo(name = "op2")
    val op2 : String,
    @ColumnInfo(name = "op3")
    val op3 : String,
    @ColumnInfo(name = "op4")
    val op4 : String,
    @ColumnInfo(name = "answer")
    val answer : Int,
    @ColumnInfo(name="answered")
    var answered : Boolean,
    @ColumnInfo(name="userAnswer")
    var userAnswer : Int,
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0
)