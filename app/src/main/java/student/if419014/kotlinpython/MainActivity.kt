package student.if419014.kotlinpython

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {
    lateinit var python: Python
    lateinit var pyObject: PyObject
    lateinit var pyObject2: PyObject
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val plafform : AndroidPlatform = AndroidPlatform(applicationContext)
        Python.start(plafform)
        python = Python.getInstance()
        pyObject = python.getModule("scripts")
        val tvShow = findViewById<TextView>(R.id.tvShow)
        pyObject2 = pyObject.callAttr("main", "1", "2")

        tvShow.text = pyObject2.toString()

        Log.i("Python", pyObject2.toString())

    }
}