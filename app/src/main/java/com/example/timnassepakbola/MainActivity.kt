package com.example.timnassepakbola

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.timnassepakbola.databinding.ActivityMainBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvTimnas: RecyclerView
    private val list = ArrayList<Timnas>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.action_about -> {
                    val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                    startActivity(moveIntent)
                }
                R.id.action_settings -> {
                    val moveIntent = Intent(this@MainActivity, SettingsActivity::class.java)
                    startActivity(moveIntent)
                }
            }

            true
        }

        rvTimnas = findViewById(R.id.rv_timnas)
        rvTimnas.setHasFixedSize(true)

        list.addAll(getListTimnas())
        showRecyclerList()
    }

    private fun getListTimnas(): ArrayList<Timnas> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataFullName = resources.getStringArray(R.array.data_fullname)
        val dataBornDate = resources.getStringArray(R.array.data_borndate)
        val dataBornPlace = resources.getStringArray(R.array.data_bornplace)
        val dataHeightWeight = resources.getStringArray(R.array.data_heightweight)
        val dataClub = resources.getStringArray(R.array.data_nowclub)
        val dataPosition = resources.getStringArray(R.array.data_position)

        val listTimnas = ArrayList<Timnas>()
        for (i in dataName.indices) {
            val timnas = Timnas(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataFullName[i],
                dataBornDate[i], dataBornPlace[i], dataHeightWeight[i], dataClub[i], dataPosition[i])
            listTimnas.add(timnas)
        }
        return listTimnas
    }

    private fun showRecyclerList() {
        rvTimnas.layoutManager = LinearLayoutManager(this)
        val listTimnasAdapter = ListTimnasAdapter(list)
        rvTimnas.adapter = listTimnasAdapter

        listTimnasAdapter.setOnItemClickCallback(object : ListTimnasAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Timnas) {
                val intentDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentDetail.putExtra("DETAIL", data)
                showSelectedTimnas(data)
                startActivity(intentDetail)
            }
        })
    }

    private fun showSelectedTimnas(data: Timnas) {
        Toast.makeText(this, "Kamu memilih " + data.name, Toast.LENGTH_SHORT).show()
    }

}