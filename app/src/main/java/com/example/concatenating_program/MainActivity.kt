package com.example.concatenating_program

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() ,
        SingleDialogFragment.NoticeDialogListener {
    private var inputItemName : String = ""
    private var inputUUID     : String = ""
    private var inputMajor    : String = ""
    private var inputMinor    : String = ""
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            floatingActionButtonOnToast("登録したいデバイスを選択してください")
        }
        
    }
    
    private fun floatingActionButtonOnToast(str: String) {
        toastDisplay(str)
        SingleDialogFragment().show(supportFragmentManager, "missiles")
    }
    
    override fun toastDisplay(str: String) {
        Toast.makeText(applicationContext, str, Toast.LENGTH_LONG).show()
    }
    
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
        
    }
    
    override fun onDialogPositiveClick(dialog: DialogFragment) {
        Log.d("mainActivity", "onDialogPositiveClick")
        val dialogView: Dialog = dialog.dialog ?: run {
            Log.d("err", "dialogView is error")
            return
        }
    
        val itemNameEt = dialogView.findViewById(R.id.itemName) as EditText? ?: run {
            Log.d("err", "itemNameDialogView is error")
            return
        }
    
        val uuidEt = dialogView.findViewById(R.id.UUID) as EditText? ?: run {
            Log.d("err", "itemNameDialogView is error")
            return
        }
    
        val majorEt = dialogView.findViewById(R.id.major) as EditText? ?: run {
            Log.d("err", "itemNameDialogView is error")
            return
        }
    
        val minorEt = dialogView.findViewById(R.id.minor) as EditText? ?: run {
            Log.d("err", "itemNameDialogView is error")
            return
        }
    
        inputItemName = itemNameEt.text.toString()
        inputUUID     = uuidEt.text.toString()
        inputMajor    = majorEt.text.toString()
        inputMinor    = minorEt.text.toString()
        
        Log.d("normally", " itemName: $inputItemName UUID: $inputUUID " +
                "major: $inputMajor minor: $inputMinor")
        
        nznCode(inputItemName, inputUUID, inputMajor, inputMinor)
    }
    
    fun nznCode(name: String, uuid: String, major: String, minor: String) {
        //nzn氏の書いたコードを記述する
    }
    
    override fun onDialogNegativeClick(dialog: DialogFragment) {
        Log.d("mainActivity", "onDialogNegativeClick")
    }
    
}