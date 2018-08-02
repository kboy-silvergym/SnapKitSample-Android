package net.kboy.snapkitclient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity: AppCompatActivity() {

    lateinit var adapter: ArrayAdapter<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val list = listOf<Category>(
                Category("swift"),
                Category("kotlin"),
                Category("python"),
                Category("swift"),
                Category("kotlin"),
                Category("python"),
                Category("swift"),
                Category("kotlin"),
                Category("python")
        )
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter
    }

    inner class Category(val name: String) {
        override fun toString(): String {
            return name
        }
    }

}
