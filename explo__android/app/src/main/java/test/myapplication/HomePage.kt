package test.myapplication

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView
import org.json.JSONObject
import test.myapplication.FragListUsers
import java.io.InputStream
import java.net.URL


class HomePage : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        callProfile()


        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_users -> {
                Toast.makeText(this, "List users clicked", Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.contentContainer, FragListUsers.newInstance("MOO1","MOO2"))
                    .commitNow()
            }
            R.id.nav_color -> {
                Toast.makeText(this, "List colors clicked", Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.contentContainer, FragListColors.newInstance("MOO1","MOO2"))
                    .commitNow()
            }
            R.id.nav_notfound -> {
                Toast.makeText(this, "Not found clicked", Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.contentContainer,FragNotfound.newInstance("moo1","moo2"))
                    .commit()
            }
            R.id.nav_create -> {
                Toast.makeText(this, "Update clicked", Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.contentContainer,FragListCreate.newInstance("moo1","moo2"))
                    .commit()
            }
            R.id.nav_logout -> {
                Toast.makeText(this, "Logout clicked", Toast.LENGTH_SHORT).show()
                val sharedPreference =  getSharedPreferences("USERS", Context.MODE_PRIVATE)
                var editor = sharedPreference.edit()
                editor.clear()
                editor.remove("token")
                editor.commit()
                startActivity(Intent(this, MainActivity::class.java))

            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    private fun callProfile() {
        val url = "https://reqres.in/api/users/2"
        val params: JSONObject = JSONObject()
        //params.put("email",userId)
        //params.put("password",userPassword)
       // val userName = findViewById<TextView>(R.id.userName)
        val request = JsonObjectRequest(
            Request.Method.GET,url,null,
            Response.Listener {
                    response -> JSONObject()
                navView = findViewById(R.id.nav_view)
                val headerView = navView.getHeaderView(0)
                val userName = headerView.findViewById<TextView>(R.id.userName)
                val imageProfile = headerView.findViewById<ImageView>(R.id.imageProfile)
                val userEmail = headerView.findViewById<TextView>(R.id.userEmail)
                Glide.with(this@HomePage).load(response.getJSONObject("data").getString("avatar")).into(imageProfile)
                userName.text = response.getJSONObject("data").getString("first_name")+" "+response.getJSONObject("data").getString("last_name")
                userEmail.text = response.getJSONObject("data").getString("email")
            },
            Response.ErrorListener { response -> Toast.makeText(this,"Response "+response.networkResponse.statusCode.toString() , Toast.LENGTH_SHORT).show() })
        val queue = Volley.newRequestQueue(this)
        queue.add(request)
    }
}


