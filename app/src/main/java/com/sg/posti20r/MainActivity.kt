package com.sg.posti20r

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.firestore.FirebaseFirestore

import com.sg.posti20r.adapter.PostViewPagerAdapter
import com.sg.posti20r.model.Post
import com.sg.posti20r.tools.Helper
import com.sg.posti20r.tools.POST_NUM
import com.sg.posti20r.tools.POST_REF

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        supportActionBar?.hide()

        downloadAllPost()
    }
    fun downloadAllPost(): ArrayList<Post> {
        var posts = ArrayList<Post>()

        val ranges = listOf(
           Pair(100, 103),
    Pair(29900, 29916),Pair(296, 299),
          Pair(3999000, 3999022),
//           Pair(3970, 3999),                                        //0.k.
//           Pair(4999013, 4999077),
//           Pair(5999000, 5999006), Pair(596, 599),
//           Pair(648, 655),
//           Pair(718, 719)
        )
        for (range in ranges) {
            FirebaseFirestore.getInstance().collection(POST_REF)
                .whereGreaterThanOrEqualTo(POST_NUM, range.first)
                .whereLessThanOrEqualTo(POST_NUM, range.second)
                .addSnapshotListener { value, error ->
                    if (value != null) {
                        for (doc in value.documents) {
                            val post = Helper().retrivePostFromFirestore(doc)
                            //post.textLocation[2]=0
                            posts.add(post)
                        }
//                        createRecyclerView(posts)
                        createViewPager2(posts)
                    }
                }
        }
        return posts
    }
    private fun createViewPager2(posts: ArrayList<Post>) {
        val viewPager = findViewById<ViewPager2>(R.id.viewpager)
        viewPager.adapter = PostViewPagerAdapter(posts)
     //   viewPager.setPageTransformer(PostPageTransformer())

        viewPager.setPageTransformer(FlipCardTransformer())


    }
    fun logi(message: String) {
        Log.i("gg", message)
    }

}