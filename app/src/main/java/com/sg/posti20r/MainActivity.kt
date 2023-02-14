package com.sg.posti20r

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.WindowManager
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.firestore.FirebaseFirestore

import com.sg.posti20r.adapter.PostViewPagerAdapter
import com.sg.posti20r.model.Post
import com.sg.posti20r.tools.Helper
import com.sg.posti20r.tools.POST_NUM
import com.sg.posti20r.tools.POST_REF
import com.wajahatkarim3.easyflipviewpager.CardFlipPageTransformer2
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val helper=Helper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        supportActionBar?.hide()

            downloadAllPost()
    }

    fun downloadAllPost(): ArrayList<Post> {
        var posts = ArrayList<Post>()
        val ranges = helper.getRanges()
        posts.addAll(downloadPostsForRanges(ranges))
        return posts
    }


    private fun downloadPostsForRanges(ranges: List<Pair<Int, Int>>): ArrayList<Post> {
        val posts = ArrayList<Post>()
        for (range in ranges) {
            FirebaseFirestore.getInstance().collection(POST_REF)
                .whereGreaterThanOrEqualTo(POST_NUM, range.first)
                .whereLessThanOrEqualTo(POST_NUM, range.second)
                .addSnapshotListener { value, error ->
                    if (value != null) {
                        for (doc in value.documents) {
                            val post = Helper().retrivePostFromFirestore(doc)
                            posts.add(post)
                        }

//                     createViewPager(posts)
//                       createViewPagerWithSuffel_1(posts)
//                       createViewPagerWithSuffel_2(posts)
                       createViewPagerWithSuffel_3(posts)
                    }
                }
        }
        return posts
    }

    private fun createViewPagerWithSuffel_3(posts: ArrayList<Post>) {
          val posts1 = posts.toMutableList()
                           posts1.shuffle(Random(System.currentTimeMillis()))
                           Handler().postDelayed({
                                   createViewPager(ArrayList(posts1))
                           },1000)
    }

    private fun createViewPagerWithSuffel_2(posts: ArrayList<Post>) {
          task1(posts){result->
                         createViewPager(ArrayList(result))
                       }
    }

    private fun createViewPagerWithSuffel_1(posts: ArrayList<Post>) {
        val posts1 = posts.toMutableList()
        posts1.shuffle(Random(System.currentTimeMillis()))
        Thread.sleep(300)
        createViewPager(ArrayList(posts1))
    }

    fun task1(posts: ArrayList<Post>, callback: (result: ArrayList<Post>) -> Unit) {
        val posts1 = posts.toMutableList()
        posts1.shuffle(Random(System.currentTimeMillis()))
        callback(ArrayList(posts1))
    }
    private fun createViewPager(posts: ArrayList<Post>) {
        val viewPager = findViewById<ViewPager2>(R.id.viewpager)
        viewPager.adapter = PostViewPagerAdapter(posts)
        //   viewPager.setPageTransformer(PostPageTransformer())

        val cardFlipPageTransformer = CardFlipPageTransformer2()
        cardFlipPageTransformer.setScalable(false)
        viewPager.setPageTransformer(cardFlipPageTransformer)

    }

    fun logi(message: String) {
        Log.i("gg", message)
    }

}



/*fun downloadAllPost(): ArrayList<Post> {
    var posts = ArrayList<Post>()
    val ranges = listOf(
        Pair(100, 103),
        //---------------------------
        Pair(29900, 29916),
        Pair(296, 299),
        //---------------------------
        Pair(3999000, 3999023),
        Pair(3970, 3999),
        //---------------------------
        Pair(4999013, 4999077),
        Pair(4940, 4999),
        //---------------------------
        Pair(5999000, 5999006),
        Pair(596, 599),
        //---------------------------
        Pair(648, 655),
        //---------------------------
        Pair(718, 719)
    )
  posts.addAll(downloadPostsForRanges(ranges))
  return posts
}*/


    /*
      private fun downloadPostsForRanges(ranges: List<Pair<Int, Int>>): ArrayList<Post> {
        val posts = ArrayList<Post>()
        for (range in ranges) {
            FirebaseFirestore.getInstance().collection(POST_REF)
                .whereGreaterThanOrEqualTo(POST_NUM, range.first)
                .whereLessThanOrEqualTo(POST_NUM, range.second)
                .addSnapshotListener { value, error ->
                    if (value != null) {
                        for (doc in value.documents) {
                            val post = Helper().retrivePostFromFirestore(doc)
                            posts.add(post)
                        }

                        GlobalScope.launch(Dispatchers.Default) {
                            val posts1 = manipulation(posts)
                            withContext(Dispatchers.Main) {
                                createViewPager(posts1)
                            }
                        }
                    }
                }
        }
        return posts
    }

    fun manipulation(posts: ArrayList<Post>): ArrayList<Post> {
        val posts1 = posts.toMutableList()
        posts1.shuffle(Random(System.currentTimeMillis()))
        return ArrayList(posts1)
    }

    suspend fun createViewPager(posts1: ArrayList<Post>) {
        createViewPager2(posts1)
    }

     */



   /* fun sufelList(posts: ArrayList<Post>,callback:(resul)):ArrayList<Post>{
        val posts1 = posts.toMutableList()
        posts1.shuffle(Random(System.currentTimeMillis()))
        return ArrayList(posts1)
    }*/











/*fun task1(callback: (result: String) -> Unit) {
    println("Task 1 started")
    // Perform task 1 here
    println("Task 1 finished")
    callback("Result from task 1")
}

fun task2(result: String) {
    println("Task 2 started with result: $result")
    // Perform task 2 here
    println("Task 2 finished")
}

fun main() {
    task1 { result ->
        task2(result)
    }
}
*/




/*  fun downloadAllPost(): ArrayList<Post> {
   var posts = ArrayList<Post>()

   val ranges = listOf(
//---------------------------
      Pair(100, 103),
//---------------------------
      Pair(29900, 29916),
       Pair(296, 299),
//---------------------------
     Pair(3999000, 3999023),
      Pair(3970, 3999),
//---------------------------
      Pair(4999013, 4999077),
      Pair(4940, 4999),
//---------------------------
      Pair(5999000, 5999006),
      Pair(596, 599),
//---------------------------
      Pair(648, 655),
//---------------------------
      Pair(718, 719)
//---------------------------
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
}*/
