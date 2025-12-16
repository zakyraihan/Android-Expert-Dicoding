package com.zaky.androidexpertdicoding.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.zaky.androidexpertdicoding.R
import com.zaky.androidexpertdicoding.core.data.Resource
import com.zaky.androidexpertdicoding.core.ui.TeamsAdapter
import com.zaky.androidexpertdicoding.databinding.FragmentHomeBinding
import com.zaky.androidexpertdicoding.detail.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TAG", "onViewCreated: initialied")

        val teamsAdapter = TeamsAdapter()
        teamsAdapter.onItemClick = { selectedData ->
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        homeViewModel.teams.observe(viewLifecycleOwner) { teams ->
            Log.d("HomeFragment", "Teams observe: $teams")
            if (teams != null) {
                when (teams) {
                    is Resource.Loading -> {
                        binding.pbHome.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        binding.pbHome.visibility = View.GONE
                        teamsAdapter.setData(teams.data)
                        Log.d("TAG", "Success get data: " + teams.data)
                    }
                    is Resource.Error -> binding.pbHome.visibility = View.GONE

                }
            } else {
                Log.d("TAG", "Datanya kosong")
            }
        }

        with(binding.rvTeams) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = teamsAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}