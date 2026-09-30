package com.example.apptwoscreens

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.apptwoscreens.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LIFECYCLE", "EditActivity: onCreate()")

        // Khoi tao ViewBinding
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Lấy dữ liệu gửi sang từ MainActivity (nếu có)
        val currentName = intent.getStringExtra("KEY_NAME") ?: ""
        binding.edtName.setText(currentName)

        // Sự kiện bấm nút "Lưu & Quay lại"
        binding.btnSave.setOnClickListener {
            // Đóng gói kết quả gửi ngược lại cho MainActivity
            val resultIntent = Intent().apply {
                putExtra("KEY_NAME", binding.edtName.text.toString())
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish() // Đóng EditActivity để quay về màn hình trước
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE", "EditActivity: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE", "EditActivity: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE", "EditActivity: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE", "EditActivity: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE", "EditActivity: onDestroy()")
    }
}