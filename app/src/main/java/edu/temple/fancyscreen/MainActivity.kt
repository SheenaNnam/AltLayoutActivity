package edu.temple.fancyscreen

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.profile_photo).setImageResource(R.drawable.istockphoto)

        findViewById<TextView>(R.id.name).setText(getString(R.string.michelle_townsend))
        findViewById<TextView>(R.id.emailLabel).setText(getString(R.string.emailLabel))
        findViewById<TextView>(R.id.supervisorLabel).setText(getString(R.string.supervisorLabel))
        findViewById<TextView>(R.id.departmentLabel).setText(getString(R.string.departmentLabel))
        findViewById<TextView>(R.id.directReportsLabel).setText(getString(R.string.directReportsLabel))
        findViewById<TextView>(R.id.extensionLabel).setText(getString(R.string.extensionLabel))


        with(findViewById<TextView>(R.id.email)) {
            text = context.getString(R.string.mt_ourcompany_com)
            setTextColor(Color.BLUE)
        }

        findViewById<TextView>(R.id.extension).text = getString(R.string._2253)

        findViewById<TextView>(R.id.department).text = getString(R.string.design)

        findViewById<TextView>(R.id.supervisor).text = getString(R.string.gail_davers)

        with (findViewById<RecyclerView>(R.id.directReportsRecyclerView)) {
            adapter = RecyclerViewAdapter(
                arrayOf(
                    context.getString(R.string.kate_sacloff),
                    context.getString(R.string.andrew_klein),
                    context.getString(R.string.maria_ortega),
                    context.getString(R.string.brent_stevenson),
                    context.getString(R.string.daniel_cho),
                    context.getString(R.string.jorge_gomez)
                )
            )
            layoutManager = LinearLayoutManager(this@MainActivity)
        }


    }
}

class RecyclerViewAdapter (private val staffList: Array<String>) : RecyclerView.Adapter<RecyclerViewAdapter.StaffListViewHolder>() {
    class StaffListViewHolder(val textView: TextView) : ViewHolder(textView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffListViewHolder {
        return StaffListViewHolder(
            TextView(parent.context).apply {
                textSize = 22f
                setTextColor(Color.BLUE)
                setPadding(50,8,0,8)
            }
        )
    }

    override fun getItemCount() = staffList.size

    override fun onBindViewHolder(holder: StaffListViewHolder, position: Int) {
        holder.textView.text = staffList[position]
    }


}