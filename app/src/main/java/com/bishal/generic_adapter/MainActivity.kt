package com.bishal.generic_adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.bishal.generic_adapter.adapter.UserAdapter
import com.bishal.generic_adapter.databinding.ActivityMainBinding
import com.bishal.generic_adapter.model.User

class MainActivity : AppCompatActivity(){
    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        userAdapter = UserAdapter()

        dataBinding.rv.adapter = userAdapter

        val users = listOf(User("Bishal Adhikari","Parsa"), User("Binita","Chitwan"))

        (dataBinding.rv.adapter as UserAdapter).submitFilterableList(users)

        dataBinding.edEditText.addTextChangedListener {
            userAdapter.filter.filter(it)
        }

    }

}