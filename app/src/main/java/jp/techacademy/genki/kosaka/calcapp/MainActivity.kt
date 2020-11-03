package jp.techacademy.genki.kosaka.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

import android.util.Log
import android.view.View
import android.content.Intent
import android.support.design.widget.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val tasu = 1
    val hiku = 2
    val kakeru = 3
    val waru = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_tasu.setOnClickListener(this)
        btn_hiku.setOnClickListener(this)
        btn_kakeru.setOnClickListener(this)
        btn_waru.setOnClickListener(this)
    }


    override fun onClick(v: View) {

        Log.d("kotlintest", (editText1.text.toString()))
        Log.d("kotlintest", (editText2.text.toString()))

        // 値のチェック
        if(editText1.text.toString().isEmpty() ||editText2.text.toString().isEmpty() ||
            editText1.text.toString().equals(".") || editText2.text.toString().equals(".")){
            Snackbar.make(rootLayout, "値は数値形式で入力してください。", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show()
            return
        }

        var rslt:String = ""

        when(v.id){
            R.id.btn_tasu -> rslt = calc(tasu)
            R.id.btn_hiku -> rslt = calc(hiku)
            R.id.btn_kakeru -> rslt = calc(kakeru)
            R.id.btn_waru -> rslt = calc(waru)
        }

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("VALUE1", rslt)
        startActivity(intent)
    }

    fun calc(kind: Int): String{
        
        //Log.d("kotlintest", (editText1.text.toString().toDouble() + editText2.text.toString().toDouble()).toString())

        val val1 = editText1.text.toString().toDouble()
        val val2 = editText2.text.toString().toDouble()
        var rtn: String = ""

        when(kind){
            tasu -> rtn = (val1 + val2).toString()
            hiku -> rtn = (val1 - val2).toString()
            kakeru -> rtn = (val1 * val2).toString()
            waru -> rtn = (val1 / val2).toString()
        }

        return rtn

    }
}
