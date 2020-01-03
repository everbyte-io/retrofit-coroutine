package io.everbyte.apicoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import io.everbyte.apicoroutine.model.NetworkState
import io.everbyte.apicoroutine.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private var imageViews = arrayOf<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initViewModel()

        registerNetworkStateObserver()
        registerImageViewObserver()
    }

    private fun initViews() {
        imageViews = arrayOf(imageView1, imageView2, imageView3)
        button.setOnClickListener { viewModel.getData() }
    }

    private fun registerImageViewObserver() {
        viewModel.imageData.observe(this, Observer {
            imageViews.forEachIndexed { index, imageView ->
                Glide.with(this)
                    .load(it[index])
                    .into(imageView)
            }
        })
    }

    private fun registerNetworkStateObserver() {
        viewModel.networkState.observe(this, Observer {
            when (it) {
                is NetworkState.Loading -> button.isEnabled = false
                is NetworkState.Success -> button.isEnabled = true
                is NetworkState.Failed -> {
                    button.isEnabled = false
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }
}
