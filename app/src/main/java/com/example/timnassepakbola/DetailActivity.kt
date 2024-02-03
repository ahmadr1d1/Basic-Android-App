package com.example.timnassepakbola

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.timnassepakbola.databinding.ActivityDetail2Binding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetail2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetail2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataTimnas = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Timnas>("DETAIL", Timnas::class.java)

        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Timnas>("DETAIL")
        }
        Log.d("Detail Data", dataTimnas?.name.toString())

        if(dataTimnas != null){
            binding.tvItemName.text = dataTimnas.name
            binding.imgItemPhoto.setImageResource(dataTimnas.photo)
            binding.tvItemDescription.text = dataTimnas.description
            binding.tvFullname.text = dataTimnas.fullname
            binding.tvBorndate.text = dataTimnas.borndate
            binding.tvBornplace.text = dataTimnas.bornplace
            binding.tvHeightweight.text = dataTimnas.heighweight
            binding.tvClub.text = dataTimnas.club
            binding.tvPosition.text = dataTimnas.position

        }

        binding.backButtonDetail.setOnClickListener {
            val moveIntent = Intent(this, MainActivity::class.java)
            startActivity(moveIntent)
            finish()
        }
    }
}