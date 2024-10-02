package com.example.demo43

import android.app.Activity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

class FloatingContextMenu: Activity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text_view)
        registerForContextMenu(textView) // Đăng ký menu ngữ cảnh cho TextView
    }

    override fun onCreateContextMenu(contextMenu: ContextMenu, view: View
                                     , contextMenuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo)
        menuInflater.inflate(R.menu.menu, contextMenu) // Inflate menu
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                showToast("About selected")
                true
            }
            R.id.action_settings -> {
                showToast("Setting selected")
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    // Phương thức để hiển thị Toast
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}