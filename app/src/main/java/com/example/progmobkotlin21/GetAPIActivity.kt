package com.example.progmobkotlin21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progmobkotlin21.adapter.UsersAdapter
import com.example.progmobkotlin21.model.ResponseUsersItem
import com.example.progmobkotlin21.model.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetAPIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_apiactivity)

        lateinit var rvUser : RecyclerView

        rvUser = findViewById(R.id.rvUserAPI)
        NetworkConfig().getService()
            .getUsers()
            .enqueue(object : Callback<List<ResponseUsersItem>> {
                override fun onFailure(call: Call<List<ResponseUsersItem>>, t:
                Throwable) {
                    Toast.makeText(this@GetAPIActivity, t.localizedMessage,
                        Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(
                    call: Call<List<ResponseUsersItem>>,
                    response: Response<List<ResponseUsersItem>>
                ) {
                    rvUser.apply{
                        layoutManager = LinearLayoutManager(this@GetAPIActivity)
                        adapter = UsersAdapter(response.body())
                    }
                }
            })
    }
}