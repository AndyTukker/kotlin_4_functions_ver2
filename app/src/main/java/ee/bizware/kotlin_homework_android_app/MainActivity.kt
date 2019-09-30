package ee.bizware.kotlin_homework_android_app

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ee.bizware.kotlin_homework_android_app.dto.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var post: Post = Post()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        post = EventPost(
            author = "Братья Гамбс",
            content = "Этим полукреслом мастер Гамбс начинает новую партию мебели",
            createdTimeStamp = 1567770000,
            likedByMe = true,
            commentedByMe = true,
            sharedByMe = true,
            quantityOfLikes = 1,
            quantityOfComments = 1,
            quantityOfShares = 1,
            address = "Mulla 1, 10611 Tallinn",
            place = Coordinates(59.434988F, 24.717758F)
        )
/*
        post = VideoPost(
            author = "Собачка Лотте",
            content = "Новый трейлер",
            createdTimeStamp = 1567770000,
            commentedByMe = true,
            quantityOfLikes = 7,
            quantityOfComments = 12,
            videoUrl = "https://youtu.be/NApLB4AhaLM"
        )
*/
        setContentView(R.layout.activity_main)
        updatePost()

        //
        likeButton.setOnClickListener{
            post = post.copy(
                likedByMe = !post.likedByMe,
                quantityOfLikes = post.quantityOfLikes + ( if (post.likedByMe) -1 else 1 )
            )
            updatePost()
        }
        //
        commentButton.setOnClickListener{
            post = post.copy(
                commentedByMe = !post.commentedByMe,
                quantityOfComments = post.quantityOfComments + ( if (post.commentedByMe) -1 else 1 )
            )
            updatePost()
        }
        //
        shareButton.setOnClickListener{
            post = post.copy(
                sharedByMe = !post.sharedByMe,
                quantityOfShares = post.quantityOfShares + ( if (post.sharedByMe) -1 else 1 )
            )
            updatePost()
        }
        //
        locationButton.setOnClickListener{
            if ( post is EventPost) {
                val lat = post.place.lat
                val lng = post.place.lng
                val intent = Intent().apply {
                    action = Intent.ACTION_VIEW
                    data = Uri.parse("geo:$lat,$lng")
                }
                startActivity(intent)
            }
        }
        //
        videoLogo.setOnClickListener{
            if ( post is VideoPost ) {
                val videoUrl = post.videoUrl
                val intent = Intent().apply {
                    action = Intent.ACTION_VIEW
                    data = Uri.parse(videoUrl)
                }
                startActivity(intent)
            }
        }
    }

    private fun timeInSecondsToString(sec : Long = 0) : String {
        val oneMinute = 60
        val oneHour = oneMinute * 60
        val oneDay = oneHour * 24
        val oneMounth = oneDay * 30
        val oneYear = oneMounth * 12
        val publishedAgo: String = when {
            (sec > oneYear * 2) -> "Some years ago"
            (sec > oneYear) -> "One year ago"
            (sec >= oneMounth * 2) -> "" + (sec / oneMounth) + " months ago"
            (sec >= oneMounth) -> "One month ago"
            (sec >= oneDay * 2) -> "" + (sec / oneDay) + " days ago"
            (sec >= oneDay) -> "One day ago"
            (sec >= oneHour * 2) -> "" + (sec / oneHour) + " hours ago"
            (sec >= oneHour) -> "One hour ago"
            (sec >= oneMinute * 2) -> "" + (sec / oneMinute) + " minutes ago"
            (sec >= oneMinute) -> "One minute ago"
            else -> "less than a minute ago"
        }
        return publishedAgo
    }

    private fun updatePost(){
        likeButton.setImageResource(
            if (post.likedByMe) R.drawable.ic_favorite_active_24dp
            else R.drawable.ic_favorite_inactive_24dp
        )
        quantityOfLikes.setTextColor( if (post.likedByMe) Color.RED else Color.GRAY )
        if (post.quantityOfLikes == 0) {
            quantityOfLikes.visibility = View.GONE
        }
        else {
            quantityOfLikes.visibility = View.VISIBLE
            quantityOfLikes.text = post.quantityOfLikes.toString()
        }

        commentButton.setImageResource(
            if (post.commentedByMe) R.drawable.ic_comment_active_24dp
            else R.drawable.ic_comment_inactive_24dp
        )
        quantityOfComments.setTextColor( if (post.commentedByMe) Color.RED else Color.GRAY )
        if (post.quantityOfComments == 0) {
            quantityOfComments.visibility = View.GONE
        }
        else {
            quantityOfComments.visibility = View.VISIBLE
            quantityOfComments.text = post.quantityOfComments.toString()
        }

        shareButton.setImageResource(
            if (post.sharedByMe) R.drawable.ic_share_active_24dp
            else R.drawable.ic_share_inactive_24dp
        )
        quantityOfShares.setTextColor( if (post.sharedByMe) Color.RED else Color.GRAY )
        if (post.quantityOfShares == 0) {
            quantityOfShares.visibility = View.GONE
        }
        else {
            quantityOfShares.visibility = View.VISIBLE
            quantityOfShares.text = post.quantityOfShares.toString()
        }

        val currentMoment = System.currentTimeMillis()/1000
        created.text = timeInSecondsToString(currentMoment - post.createdTimeStamp)
        author.text = post.author
        content.text = post.content
        //
        locationButton.visibility = if ( (post is EventPost) && (post.address != "") ) View.VISIBLE else View.GONE
        //
        videoLogo.visibility = if ( (post is VideoPost) && ( post.videoUrl != "") ) View.VISIBLE else View.GONE
    }
}
