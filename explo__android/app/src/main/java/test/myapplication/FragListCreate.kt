package test.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
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
var list = ArrayList<Create>()
/**
 * A simple [Fragment] subclass.
 * Use the [FragListUpdate.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragListCreate : Fragment() {
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
        return inflater.inflate(R.layout.fragment_frag_list_create, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonFragCreate = view.findViewById<Button>(R.id.buttonFragCreate)

        buttonFragCreate.setOnClickListener{
            callListUpdate(view)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragListUpdate.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragListCreate().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun callListUpdate(view: View){
        val url = "https://reqres.in/api/users"
        val params: JSONObject = JSONObject()
        val createName = view.findViewById<EditText>(R.id.editFragCreateName)
        val createJob = view.findViewById<EditText>(R.id.editFragCreateJob)
        params.put("createName",createName.text)
        params.put("createJob",createJob.text)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewCreate)
        val request = JsonObjectRequest(
            Request.Method.POST,url,params,
            Response.Listener {
                    response -> JSONObject()
                    val createID = response.getString("id")
                    val CreateAt = response.getString("createdAt")
                    val createName = params.getString("createName")
                    val CreateJob = params.getString("createJob")
                    val data = Create(createID,createName,CreateJob,CreateAt)
                    list.add(data)
                recyclerView.adapter = CreateAdapter(list)
                recyclerView.layoutManager = LinearLayoutManager(activity)
            },
            Response.ErrorListener { response -> Toast.makeText(activity,"Response "+response.networkResponse.statusCode.toString() , Toast.LENGTH_SHORT).show() })
        val queue = Volley.newRequestQueue(activity)
        queue.add(request)
        //Toast.makeText(activity, "moo "+list.size.toString(), Toast.LENGTH_SHORT).show()
    }
}