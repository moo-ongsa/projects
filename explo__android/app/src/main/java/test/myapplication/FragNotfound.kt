package test.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
 * Use the [FragNotfound.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragNotfound : Fragment() {
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
        return inflater.inflate(R.layout.fragment_frag_notfound, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callNotfound(view)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragNotfound.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragNotfound().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun callNotfound(view: View){
        val url = "https://reqres.in/api/users/23"
        val textFragnotfound = view.findViewById<TextView>(R.id.textFragNotfound)
        val request = JsonObjectRequest(
            Request.Method.GET,url,null,
            Response.Listener {
                    response ->
                textFragnotfound.text = "Response : "+response.toString()
            },
            Response.ErrorListener { response -> Toast.makeText(activity,"Response "+response.networkResponse.statusCode.toString() , Toast.LENGTH_SHORT).show()
                textFragnotfound.text = "Response : "+response.networkResponse.statusCode.toString()
                })
        val queue = Volley.newRequestQueue(activity)
        queue.add(request)
        //Toast.makeText(activity, "moo "+list.size.toString(), Toast.LENGTH_SHORT).show()
    }
}