package com.example.cgv_clone.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cgv_clone.MovieInterface
import com.example.cgv_clone.R
import com.example.cgv_clone.RetrofitClient
import com.example.cgv_clone.adapter.ImageSliderAdapter
import com.example.cgv_clone.adapter.MovieAdapter
import com.example.cgv_clone.data.MovieResponse
import com.example.cgv_clone.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


val images = arrayOf(
    R.drawable.item_ad_1,
    R.drawable.item_ad_2,
    R.drawable.item_ad_3,
)

data class Movies(
    var img: String,
    var name: String,
    var egg_per: String,
    var ratio: String,
    var popular: String,
)

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private lateinit var imageSliderAdapter: ImageSliderAdapter

    private lateinit var movieAdapter: MovieAdapter

    var MoviesArrayList = ArrayList<Movies>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieAdapter = MovieAdapter(requireContext(), MoviesArrayList)
        binding.rvMovie.adapter = movieAdapter

//        binding.viewpagerAd.offscreenPageLimit = 1

//        imageSliderAdapter = ImageSliderAdapter(requireContext(), images)
//        binding.viewpagerAd.adapter = ImageSliderAdapter(requireContext(), images)
//        binding.viewpagerAd.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        getMovieData("139375030520de9f27d670cbfc5fdad9", "ko-KR", 1, "KR")
//

    }

    private fun getMovieData(api_key: String, language: String, page: Int, region: String) {

        val movieInterface = RetrofitClient.mRetrofit.create(MovieInterface::class.java)

        movieInterface.getNowPlaying(api_key, language, page, region).enqueue(object :
            Callback<MovieResponse> {

            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>,
            ) {
                if (response.isSuccessful) {

                    val result = response.body() as MovieResponse
                    for (i in 0..5) {
                        MoviesArrayList.add(
                            Movies(
                                result.results[i].poster_path,
                                result.results[i].title,
                                result.results[i].vote_average.toString(), // 퍙균평점
                                result.results[i].getFormatPercent(), // 임의로 만든 퍼센트
                                result.results[i].getFormatPopular(), // 인기도

                            )
                        )
                    }
                    movieAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d("test", t.message ?: "통신오류")
            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}