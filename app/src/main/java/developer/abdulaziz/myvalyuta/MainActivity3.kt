package developer.abdulaziz.myvalyuta

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.VolleyLog
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import developer.abdulaziz.myvalyuta.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    private lateinit var rvAdapter: MyAdapter2
    private lateinit var request: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        request = Volley.newRequestQueue(binding.root.context)
        VolleyLog.DEBUG = true

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET,
            "https://api.github.com/users", null,
            {
                val type = object : TypeToken<List<User2>>() {}.type
                val list = Gson().fromJson<List<User2>>(it.toString(), type)
                rvAdapter = MyAdapter2(this, list)
                binding.rv.adapter = rvAdapter
            }) {
            Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()
        }

        request.add(jsonArrayRequest)
    }
}