package ee.bizware.kotlin_homework_android_app.dto

open class Post(
    val author: String = "",
    val content: String = "",
    val createdTimeStamp: Int = 0,
    //
    val likedByMe: Boolean = false,
    val commentedByMe: Boolean = false,
    val sharedByMe: Boolean = false,
    //
    val quantityOfLikes: Int = 0,
    val quantityOfComments: Int = 0,
    val quantityOfShares: Int = 0
){
    fun copy(
        author: String = this.author,
        content: String = this.content,
        createdTimeStamp: Int = this.createdTimeStamp,
        likedByMe: Boolean = this.likedByMe,
        commentedByMe: Boolean = this.commentedByMe,
        sharedByMe: Boolean = this.sharedByMe,
        quantityOfLikes: Int = this.quantityOfLikes,
        quantityOfComments: Int = this.quantityOfComments,
        quantityOfShares: Int = this.quantityOfShares
    ): Post{
        return Post(author, content, createdTimeStamp, likedByMe, commentedByMe, sharedByMe, quantityOfLikes, quantityOfComments, quantityOfShares)
    }
}

data class Coordinates(
    val lat: Float = 0F,
    val lng: Float = 0F
)

class EventPost(
    author: String = "",
    content: String = "",
    createdTimeStamp: Int = 0,
    likedByMe: Boolean = false,
    commentedByMe: Boolean = false,
    sharedByMe: Boolean = false,
    quantityOfLikes: Int = 0,
    quantityOfComments: Int = 0,
    quantityOfShares: Int = 0,
    address: String = "",
    place: Coordinates = Coordinates(0F, 0F)
): Post(author, content, createdTimeStamp, likedByMe, commentedByMe, sharedByMe, quantityOfLikes, quantityOfComments, quantityOfShares){
    val address = address
    val place = place
    fun copy(
        author: String = this.author,
        content: String = this.content,
        createdTimeStamp: Int = this.createdTimeStamp,
        likedByMe: Boolean = this.likedByMe,
        commentedByMe: Boolean = this.commentedByMe,
        sharedByMe: Boolean = this.sharedByMe,
        quantityOfLikes: Int = this.quantityOfLikes,
        quantityOfComments: Int = this.quantityOfComments,
        quantityOfShares: Int = this.quantityOfShares,
        address: String = this.address,
        place: Coordinates = this.place
    ): EventPost{
        return EventPost(author, content, createdTimeStamp, likedByMe, commentedByMe, sharedByMe, quantityOfLikes, quantityOfComments, quantityOfShares, address, place)
    }
}

class VideoPost(
    author: String,
    content: String,
    createdTimeStamp: Int,
    likedByMe: Boolean,
    commentedByMe: Boolean,
    sharedByMe: Boolean,
    quantityOfLikes: Int,
    quantityOfComments: Int,
    quantityOfShares: Int,
    videoUrl: String
): Post(author, content, createdTimeStamp, likedByMe, commentedByMe, sharedByMe, quantityOfLikes, quantityOfComments, quantityOfShares){
    val videoUrl = videoUrl
    fun copy(
        author: String = this.author,
        content: String = this.content,
        createdTimeStamp: Int = this.createdTimeStamp,
        likedByMe: Boolean = this.likedByMe,
        commentedByMe: Boolean = this.commentedByMe,
        sharedByMe: Boolean = this.sharedByMe,
        quantityOfLikes: Int = this.quantityOfLikes,
        quantityOfComments: Int = this.quantityOfComments,
        quantityOfShares: Int = this.quantityOfShares,
        videoUrl: String = this.videoUrl
    ): VideoPost{
        return VideoPost(author, content, createdTimeStamp, likedByMe, commentedByMe, sharedByMe, quantityOfLikes, quantityOfComments, quantityOfShares, videoUrl)
    }
}
