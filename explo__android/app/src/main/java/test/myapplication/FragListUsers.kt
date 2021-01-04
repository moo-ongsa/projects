package test.myapplication

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_list_users.*
import kotlinx.android.synthetic.main.nav_header.*
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListUsers.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragListUsers : Fragment() {
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

    private fun callListUsers(view: View){
        val url = "https://reqres.in/api/users?page=2"
        val params: JSONObject = JSONObject()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        var list = ArrayList<Users>()
        val request = JsonObjectRequest(
            Request.Method.GET,url,null,
            Response.Listener {
                    response -> JSONObject()
                    val jsonObj = response.getJSONArray("data")
                for(i in 0 until jsonObj.length()){
                    val userLId = jsonObj.getJSONObject(i).getInt("id")
                    val userLEmail = jsonObj.getJSONObject(i).getString("email")
                    val userLFirstName = jsonObj.getJSONObject(i).getString("first_name")
                    val userLLastName = jsonObj.getJSONObject(i).getString("last_name")
                    val userLImage = jsonObj.getJSONObject(i).getString("avatar")
                    val data = Users(userLId,userLEmail,userLFirstName,userLLastName,userLImage)
                    list.add(data)
                }
                recyclerView.adapter = UserAdapter(list)
                recyclerView.layoutManager = LinearLayoutManager(activity)
            },
            Response.ErrorListener { response -> Toast.makeText(activity,"Response "+response.networkResponse.statusCode.toString() , Toast.LENGTH_SHORT).show() })
        val queue = Volley.newRequestQueue(activity)
        queue.add(request)
        //Toast.makeText(activity, "moo "+list.size.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        callListUsers(view)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListUsers.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragListUsers().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}