package com.example.utspamaplikasi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.utspamaplikasi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        adapter = RVAdapter(this@MainActivity, arrayListOf())

        binding.rvMain.adapter = adapter
        binding.rvMain.setHasFixedSize(true)

        remoteGetUsers()
    }
    private fun remoteGetUsers(){
        APIClient.apiServive.getUser().enqueue(object  : retrofit2.Callback<ArrayList<ResponseModel>>{
            override fun onResponse(
                call: Call<ArrayList<ResponseModel>>,
                response: Response<ArrayList<ResponseModel>>
            ) {
                if(response.isSuccessful){
                    val data = response.body()
                    setDataToAdapter(data!!)
                }
            }

            override fun onFailure(call: Call<ArrayList<ResponseModel>>, t: Throwable) {
                Log.d("Error", " " + t.stackTraceToString())
            }
        })
    }
    fun setDataToAdapter(data: ArrayList<ResponseModel>){
        adapter.setData(data)
    }
}