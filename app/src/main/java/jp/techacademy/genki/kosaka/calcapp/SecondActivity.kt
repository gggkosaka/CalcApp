package jp.techacademy.genki.kosaka.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //mainから値を受け取る
        val value1 = intent.getStringExtra("VALUE1")

        //末尾の".0・・"を消して表示
        val regex = Regex(".0+\$")
        textView.text = regex.replace(value1, "")
    }
}
