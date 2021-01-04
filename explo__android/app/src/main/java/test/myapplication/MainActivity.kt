package test.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreference =  getSharedPreferences("USERS", Context.MODE_PRIVATE)
        val checkToken = sharedPreference.getString("token",null)
        if(checkToken != null){
            startActivity(Intent(this, HomePage::class.java))
            finish()
        }
        //declare
        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb)
        val stb = AnimationUtils.loadAnimation(this,R.anim.stb)
        val headerTitle = findViewById<TextView>(R.id.title)
        val icon = findViewById<ImageView>(R.id.icon)
        val textUserId = findViewById<EditText>(R.id.userId)
        val textUserIdPassword = findViewById<EditText>(R.id.userPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        //val textCreate = findViewById<TextView>(R.id.textCreate)

        //set
        //headerTitle.isClickable=true
        headerTitle.movementMethod = LinkMovementMethod.getInstance()
        headerTitle.text = HtmlCompat.fromHtml("<b>Hello</b> <font color=\"#fafafa\"> lalala </font> <a href='http://www.google.com'> google </a>",
            HtmlCompat.FROM_HTML_MODE_COMPACT)

        //animation
        headerTitle.startAnimation(ttb)
        icon.startAnimation(stb)

        //
        textUserId.setOnClickListener{
            headerTitle.text = textUserId.text.toString()
            Log.d("moo","mooooooo")
        }
        buttonLogin.setOnClickListener{

            //headerTitle.text = textUserId.text.toString()
            //Toast.makeText(applicationContext, textUserId.text.toString(), Toast.LENGTH_LONG).show()
            //เก็บค่าจาก view ใน xml มาใส่ตัวแปร
            val userId  = textUserId.text.toString()
            val userPassword  = textUserIdPassword.text.toString()
            val loginSuccess : Boolean = false
            callLogin(userId,userPassword)
            //startActivity(Intent(this,HomePage::class.java))
        }
    }
    fun sendGet() {
        val list = ArrayList<Users>()
        try {
            //val url  = "http://www.google.com/"
            //Toast.makeText(applicationContext, url, Toast.LENGTH_LONG).show()
            //callLogin()
        }
            catch (e : IOException){
            Toast.makeText(applicationContext, "error "+ e.toString(), Toast.LENGTH_LONG).show()
        }
    }
    private fun callLogin(userId : String,userPassword : String) {
        val url = "https://reqres.in/api/login"
        val params: JSONObject = JSONObject()
        params.put("email",userId)
        params.put("password",userPassword)

        val request = JsonObjectRequest(
            Request.Method.POST,url,params,
            Response.Listener {
                //val jsonObj:JSONObject=JSONObject()
                //
                    response -> val jsonObj: JSONObject = JSONObject()
                //for(i in 0 until it.length()){
                //textView.text = "Response: %s".format(response.toString())

                //val data2 = jsonObj.getString("data")
                //val ad2 = jsonObj.getString("ad")
                //val name = jsonObj.getString("name")
                //val description = jsonObj.getString("description")
                //val rating = jsonObj.getString("Rating")
                //val category = jsonObj.getString("categorie")
                //val studio = jsonObj.getString("studio")
                //val img = jsonObj.getString("img")

                //val data = Users(name,description,rating,category,studio,img)
                //list.add(data)

                //create adapter
                //Toast.makeText(this, response.getString("token"), Toast.LENGTH_SHORT).show()
                //Toast.makeText(this, name+" and "+description, Toast.LENGTH_SHORT).show()
                //}
                val sharedPreference =  getSharedPreferences("USERS", Context.MODE_PRIVATE)
                var editor = sharedPreference.edit()
                editor.putString("token",response.getString("token"))
                editor.commit()
                startActivity(Intent(this, HomePage::class.java))
                finish()
            },
            Response.ErrorListener {Toast.makeText(this, "Invalid email or password.", Toast.LENGTH_SHORT).show() })
        val queue = Volley.newRequestQueue(this)
        queue.add(request)
    }
}