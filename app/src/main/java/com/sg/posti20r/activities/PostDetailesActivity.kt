package com.sg.posti20r.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sg.posti20r.databinding.ActivityPostDetailesBinding
import com.sg.posti20r.model.Post
import com.sg.posti20r.tools.*
import java.lang.reflect.Type

class PostDetailesActivity : AppCompatActivity() {
    lateinit var binding: ActivityPostDetailesBinding
    lateinit var pref: SharedPreferences
    lateinit var currentPost: Post
    /*
      var util = UtilityPost()
    var currentUser: User? = null
    var textViewArray = ArrayList<TextView>()
    lateinit var commentsRV: RecyclerView
    lateinit var commentAdapter: CommentAdapter
    var comments = ArrayList<Comment>()
    var message = ""
    lateinit var newUtil1: NewUtilities
  */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPostDetailesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = getSharedPreferences(SHARPREF_ALMA, Context.MODE_PRIVATE)
        currentPost = loadCurrentPost()
        pref.edit().putInt(SHARPREF_CURRENT_POST_NUM, currentPost.postNum).apply()
        val moving = pref.getString(SHARPREF_MOVING_BACKGROUND, TRUE)
        binding.movingModeBtn.isChecked = moving == TRUE

        drawHeadline()
        btnSetting()

    }

    private fun btnSetting() {
        binding.movingModeBtn.setOnClickListener {
//           logi("PostDetailActivity 182    befor  btn.isChecked=${btn.isChecked}     ")
            if (binding.movingModeBtn.isChecked == true) {
                pref.edit().putString(SHARPREF_MOVING_BACKGROUND, TRUE).apply()
//                binding.movingModeBtn.isChecked =false
//                logi("PostDetailActivity 185    after  btn.isChecked=${binding.movingModeBtn.isChecked}     ")
                startActivity(Intent(this, MainActivity::class.java))
                finish()

            } else {
                pref.edit().putString(SHARPREF_MOVING_BACKGROUND, FALSE).apply()
//                binding.movingModeBtn.isChecked =true
//                logi("PostDetailActivity 189    after  btn.isChecked=${binding.movingModeBtn.isChecked}     ")
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

    }

    fun loadCurrentPost(): Post {
        val gson = Gson()
        val json: String? = pref.getString(SHARPREF_CURRENT_POST, null)
        val type: Type = object : TypeToken<Post>() {}.type
        val post: Post = gson.fromJson(json, type)
        return post
    }
    private fun drawHeadline() {
//        val st = "  פוסט מספר: " + currentPost.postNum.toString()
        val st = " מספר: " + currentPost.postNum.toString()
        binding.postNumber.text = st
        // logi("PostDetailsActivity  233  post=$currentPost    \n post.postText.size= ${currentPost.postText.size}")
        drawPostText()
    }
    private fun drawPostText() {
        if (currentPost.postText.size == 1) {
            binding.tvPost1.visibility = View.VISIBLE
            binding.tvPost1.text = currentPost.postText[0]
        }
        if (currentPost.postText.size == 2) {
            binding.tvPost1.visibility = View.VISIBLE
            binding.tvPost2.visibility = View.VISIBLE
            binding.tvPost1.text = currentPost.postText[0]
            binding.tvPost2.text = currentPost.postText[1]
        }
        if (currentPost.postText.size == 3) {
            binding.tvPost1.visibility = View.VISIBLE
            binding.tvPost2.visibility = View.VISIBLE
            binding.tvPost3.visibility = View.VISIBLE
            binding.tvPost1.text = currentPost.postText[0]
            binding.tvPost2.text = currentPost.postText[1]
            binding.tvPost3.text = currentPost.postText[2]
        }
        if (currentPost.postText.size == 4) {
            binding.tvPost1.visibility = View.VISIBLE
            binding.tvPost2.visibility = View.VISIBLE
            binding.tvPost3.visibility = View.VISIBLE
            binding.tvPost4.visibility = View.VISIBLE
            binding.tvPost1.text = currentPost.postText[0]
            binding.tvPost2.text = currentPost.postText[1]
            binding.tvPost3.text = currentPost.postText[2]
            binding.tvPost4.text = currentPost.postText[3]
        }
        if (currentPost.postText.size == 5) {
            binding.tvPost1.visibility = View.VISIBLE
            binding.tvPost2.visibility = View.VISIBLE
            binding.tvPost3.visibility = View.VISIBLE
            binding.tvPost4.visibility = View.VISIBLE
            binding.tvPost5.visibility = View.VISIBLE
            binding.tvPost1.text = currentPost.postText[0]
            binding.tvPost2.text = currentPost.postText[1]
            binding.tvPost3.text = currentPost.postText[2]
            binding.tvPost4.text = currentPost.postText[3]
            binding.tvPost5.text = currentPost.postText[4]
        }
        if (currentPost.postText.size == 6) {
            binding.tvPost1.visibility = View.VISIBLE
            binding.tvPost2.visibility = View.VISIBLE
            binding.tvPost3.visibility = View.VISIBLE
            binding.tvPost4.visibility = View.VISIBLE
            binding.tvPost5.visibility = View.VISIBLE
            binding.tvPost6.visibility = View.VISIBLE
            binding.tvPost1.text = currentPost.postText[0]
            binding.tvPost2.text = currentPost.postText[1]
            binding.tvPost3.text = currentPost.postText[2]
            binding.tvPost4.text = currentPost.postText[3]
            binding.tvPost5.text = currentPost.postText[4]
            binding.tvPost6.text = currentPost.postText[5]
        }
        if (currentPost.postText.size == 7) {
            binding.tvPost1.visibility = View.VISIBLE
            binding.tvPost2.visibility = View.VISIBLE
            binding.tvPost3.visibility = View.VISIBLE
            binding.tvPost4.visibility = View.VISIBLE
            binding.tvPost5.visibility = View.VISIBLE
            binding.tvPost6.visibility = View.VISIBLE
            binding.tvPost7.visibility = View.VISIBLE
            binding.tvPost1.text = currentPost.postText[0]
            binding.tvPost2.text = currentPost.postText[1]
            binding.tvPost3.text = currentPost.postText[2]
            binding.tvPost4.text = currentPost.postText[3]
            binding.tvPost5.text = currentPost.postText[4]
            binding.tvPost6.text = currentPost.postText[5]
            binding.tvPost7.text = currentPost.postText[6]
        }
        if (currentPost.postText.size == 8) {
            binding.tvPost1.visibility = View.VISIBLE
            binding.tvPost2.visibility = View.VISIBLE
            binding.tvPost3.visibility = View.VISIBLE
            binding.tvPost4.visibility = View.VISIBLE
            binding.tvPost5.visibility = View.VISIBLE
            binding.tvPost6.visibility = View.VISIBLE
            binding.tvPost7.visibility = View.VISIBLE
            binding.tvPost8.visibility = View.VISIBLE
            binding.tvPost1.text = currentPost.postText[0]
            binding.tvPost2.text = currentPost.postText[1]
            binding.tvPost3.text = currentPost.postText[2]
            binding.tvPost4.text = currentPost.postText[3]
            binding.tvPost5.text = currentPost.postText[4]
            binding.tvPost6.text = currentPost.postText[5]
            binding.tvPost7.text = currentPost.postText[6]
            binding.tvPost8.text = currentPost.postText[7]
        }
        if (currentPost.postText.size == 9) {
            binding.tvPost1.visibility = View.VISIBLE
            binding.tvPost2.visibility = View.VISIBLE
            binding.tvPost3.visibility = View.VISIBLE
            binding.tvPost4.visibility = View.VISIBLE
            binding.tvPost5.visibility = View.VISIBLE
            binding.tvPost6.visibility = View.VISIBLE
            binding.tvPost7.visibility = View.VISIBLE
            binding.tvPost8.visibility = View.VISIBLE
            binding.tvPost9.visibility = View.VISIBLE
            binding.tvPost1.text = currentPost.postText[0]
            binding.tvPost2.text = currentPost.postText[1]
            binding.tvPost3.text = currentPost.postText[2]
            binding.tvPost4.text = currentPost.postText[3]
            binding.tvPost5.text = currentPost.postText[4]
            binding.tvPost6.text = currentPost.postText[5]
            binding.tvPost7.text = currentPost.postText[6]
            binding.tvPost8.text = currentPost.postText[7]
            binding.tvPost9.text = currentPost.postText[8]
        }
    }
}