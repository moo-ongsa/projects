package test.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragListColors.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragListColors : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_list_colors, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callListColor(view)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragListColors.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragListColors().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun callListColor(view: View){
        val url = "https://reqres.in/api/unknown"
        val params: JSONObject = JSONObject()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView2)
        var list = ArrayList<Color>()
        val request = JsonObjectRequest(
            Request.Method.GET,url,null,
            Response.Listener {
                    response -> JSONObject()
                val jsonObj = response.getJSONArray("data")
                for(i in 0 until jsonObj.length()){
                    val colorLId = jsonObj.getJSONObject(i).getInt("id")
                    val colorLName = jsonObj.getJSONObject(i).getString("name")
                    val colorLYear = jsonObj.getJSONObject(i).getString("year")
                    val colorLColor = jsonObj.getJSONObject(i).getString("color")
                    val colorLPantone = jsonObj.getJSONObject(i).getString("pantone_value")
                    val data = Color(colorLId,colorLName,colorLYear,colorLColor,colorLPantone)
                    list.add(data)
                }
                recyclerView.adapter = ColorAdapter(list)
                recyclerView.layoutManager = LinearLayoutManager(activity)
            },
            Response.ErrorListener { response -> Toast.makeText(activity,"Response "+response.networkResponse.statusCode.toString() , Toast.LENGTH_SHORT).show() })
        val queue = Volley.newRequestQueue(activity)
        queue.add(request)
        //Toast.makeText(activity, "moo "+list.size.toString(), Toast.LENGTH_SHORT).show()
    }
}