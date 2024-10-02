package com.example.demo43

import android.app.Activity
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.Toast

class Popup: Activity() {
    private lateinit var popupMenuButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        popupMenuButton = findViewById(R.id.popup_menu_button)

        // Thiết lập onClickListener cho ImageButton
        popupMenuButton.setOnClickListener { view ->
            showPopupMenu(view)
        }
    }

    // Hàm hiển thị popup menu
    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        val inflater: MenuInflater = popupMenu.menuInflater
        inflater.inflate(R.menu.popup, popupMenu.menu)

        // Thiết lập listener cho các mục menu
        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            onMenuItemClick(item)
        }

        popupMenu.show() // Hiển thị menu
    }

    // Xử lý các sự kiện click cho menu item
    private fun onMenuItemClick(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_edit -> {
                performAction("Edit")
                true
            }
            R.id.action_delete -> {
                performAction("Delete")
                true
            }
            else -> false
        }
    }

    // Phương thức thực hiện hành động cho từng mục trong menu
    private fun performAction(action: String) {
        Toast.makeText(this, "$action selected", Toast.LENGTH_SHORT).show()
    }
}