package com.kangzayd.paxabayapi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import com.kangzayd.paxabayapi.model.ResponsePixabay
import com.kangzayd.paxabayapi.networking.ApiCall
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    fun toast(pesan: String) = Toast.makeText(applicationContext, pesan, Toast.LENGTH_SHORT).show()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiKey = "3407707-97e4b76c46b23b5ee909960e7"
        val q = "yellow+flowers"
        val img_type = "photo"
        val api = ApiCall()
        api.create().getData(apiKey, q, img_type)
                .enqueue(object : Callback<ResponsePixabay> {
                    override fun onFailure(call: Call<ResponsePixabay>?, t: Throwable?) {
                        toast("fail ${t!!.message!!}")
                        Log.i("autolog", "t!!.message!!: " + t!!.message!!)
                        textMain.text = "fail ${t!!.message!!}"
                    }

                    override fun onResponse(call: Call<ResponsePixabay>?, response: Response<ResponsePixabay>?) {
                        if (response!!.isSuccessful) {
                            toast("Total data ${response.body()!!.total}")
                            textMain.text = "Total data ${response.body()!!.total}"

                            val mAdapter = MainAdapter(response.body()!!.hits)
                            val mLayout = LinearLayoutManager(this@MainActivity, LinearLayout.VERTICAL,false)
                            recyclerMain.apply {
                                layoutManager = mLayout
                                itemAnimator = DefaultItemAnimator()
                                adapter = mAdapter
                            }
                        } else {
                            toast(response.message())
                            textMain.text = response.message()
                        }
                    }
                })
    }
}
