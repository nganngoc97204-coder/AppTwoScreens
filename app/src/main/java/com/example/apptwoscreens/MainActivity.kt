package com.example.apptwoscreens

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.apptwoscreens.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // 1. Đăng ký Launcher với Activity Result API để nhận dữ liệu phản hồi
    private val editLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // Lấy dữ liệu trả về từ EditActivity
            val newName = result.data?.getStringExtra("KEY_NAME") ?: ""
            binding.tvProfileName.text = "Họ tên: $newName"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LIFECYCLE", "MainActivity: onCreate()")

        // Khoi tao ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Sự kiện khi bấm nút "Chỉnh sửa thông tin"
        binding.btnEdit.setOnClickListener {
            // Tạo Explicit Intent mở EditActivity
            val intent = Intent(this, EditActivity::class.java).apply {
                putExtra("KEY_NAME", binding.tvProfileName.text.toString())
            }
            // Kích hoạt mở màn hình con
            editLauncher.launch(intent)
        }
    }

    // Các hàm vòng đời để theo dõi trên Logcat theo yêu cầu bài học
    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE", "MainActivity: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE", "MainActivity: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE", "MainActivity: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE", "MainActivity: onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LIFECYCLE", "MainActivity: onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE", "MainActivity: onDestroy()")
    }
}