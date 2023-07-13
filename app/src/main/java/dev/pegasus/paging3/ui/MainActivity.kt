package dev.pegasus.paging3.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.pegasus.paging3.adapter.AdapterData
import dev.pegasus.paging3.adapter.StateAdapter
import dev.pegasus.paging3.databinding.ActivityMainBinding
import dev.pegasus.paging3.viewModels.DataViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: DataViewModel by viewModel()
    private val adapter by lazy { AdapterData() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()
        initObserver()
    }

    private fun initRecyclerView() {
        binding.rvList.adapter = adapter.withLoadStateFooter(footer = StateAdapter())
    }

    private fun initObserver() {
        viewModel.list.observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }
}