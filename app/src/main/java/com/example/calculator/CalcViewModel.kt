package com.example.calculator

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalcViewModel :ViewModel(){

    val answer = MutableLiveData<String>("0")
    var exp = ""
    var res = ""

    fun addText(x:String) {
        if(answer.value=="0"){
            answer.value=x
        }
        else{
            answer.value+=x
        }
    }

    fun clear(){
        answer.value = "0"
    }

    fun erase(){
        if(answer.value == "0"){
            answer.value = "0"
        }
        else if(answer.value?.length==1 && answer.value!="0"){
            answer.value="0"
        }
        else {
            answer.value =
                answer.value?.subSequence(0, answer.value!!.length - 1).toString()
        }
    }

    fun expression(x:String){
        exp=x
        res= answer.value.toString()
        answer.value="0"
    }

    fun calc(){
        var temp = mutableListOf<String>(res,answer.value.toString())
        var ans = 0.0
        if (exp=="+"){
            ans = temp[0].toDouble() + temp[1].toDouble()
            answer.value=ans.toString()
        }
        else if(exp=="-"){
            ans = temp[0].toDouble() - temp[1].toDouble()
            answer.value=ans.toString()
        }
        else if(exp=="*"){
            ans = temp[0].toDouble() * temp[1].toDouble()
            answer.value=ans.toString()
        }
        else if(exp=="/"){
            ans = temp[0].toDouble() / temp[1].toDouble()
            answer.value=ans.toString()
        }
        else if(exp=="%"){
            ans = temp[0].toDouble() % temp[1].toDouble()
            answer.value=ans.toString()
        }
    }

}