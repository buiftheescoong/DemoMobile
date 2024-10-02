package com.example.demo43

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import android.view.ActionMode

class ActionMode: Activity() {
    private lateinit var textView: TextView
    private var actionMode: ActionMode? = null

    // Callback cho ActionMode
    private val actionModeCallback = object : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            // Inflate menu ngữ cảnh
            mode?.menuInflater?.inflate(R.menu.menu, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return false // Không cần chuẩn bị gì
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            return when (item?.itemId) {
                R.id.action_settings -> {
                    performAction("Setting")
                    mode?.finish() // Kết thúc ActionMode
                    true
                }
                R.id.action_about -> {
                    performAction("About")
                    mode?.finish() // Kết thúc ActionMode
                    true
                }
                else -> false
            }
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
            actionMode = null // Đặt lại ActionMode khi bị hủy
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text_view)

        // Thiết lập OnLongClickListener để kích hoạt ActionMode
        textView.setOnLongClickListener {
            if (actionMode != null) {
                return@setOnLongClickListener false
            }
            actionMode = startActionMode(actionModeCallback)
            true
        }
    }

    // Phương thức thực hiện hành động cho từng mục trong menu
    private fun performAction(action: String) {
        Toast.makeText(this, "$action selected", Toast.LENGTH_SHORT).show()
    }
}