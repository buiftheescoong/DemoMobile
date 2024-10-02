package com.example.demo43

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast



class AlertDialog: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set onClickListener cho nút (nếu có)
        findViewById<View>(R.id.show_alert_button).setOnClickListener {
            onClickShowAlert(it)
        }
    }

    // Phương thức để hiển thị AlertDialog
    private fun onClickShowAlert(view: View) {
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Wake up")
            .setMessage("Phuoc oi day di")
            .setPositiveButton("Yes") { dialog, which ->
                // Thực hiện hành động khi nhấn "Yes"
                // Ví dụ: Toast hoặc xử lý logic khác
                showToast("You clicked Yes")
            }
            .setNegativeButton("No") { dialog, which ->
                // Thực hiện hành động khi nhấn "No"
                showToast("You clicked No")
            }
            .setNeutralButton("Cancel") { dialog, which ->
                // Hành động khi nhấn "Cancel"
                showToast("You clicked Cancel")
            }
            .create() // Tạo AlertDialog

        alertDialog.show() // Hiển thị AlertDialog
    }

    // Phương thức hiển thị Toast
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}