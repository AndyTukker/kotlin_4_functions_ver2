package ee.bizware.kotlin_homework_android_app.dto

interface Post {
    val author: String
    val content: String
    val createdTimeStamp: Int
    //
    val likedByMe: Boolean
    val commentedByMe: Boolean
    val sharedByMe: Boolean
    //
    val quantityOfLikes: Int
    val quantityOfComments: Int
    val quantityOfShares: Int
}

fun Post.toggleLikes(): Post = when (this) {
    is SimplePost -> copy (
        likedByMe = !likedByMe,
        quantityOfLikes = quantityOfLikes + ( if (likedByMe) -1 else 1 )
    )
    is EventPost -> copy (
        likedByMe = !likedByMe,
        quantityOfLikes = quantityOfLikes + ( if (likedByMe) -1 else 1 )
    )
    is VideoPost -> copy (
        likedByMe = !likedByMe,
        quantityOfLikes = quantityOfLikes + ( if (likedByMe) -1 else 1 )
    )
    else -> this
}

fun Post.toggleComments(): Post = when (this) {
    is SimplePost -> copy (
        commentedByMe = !commentedByMe,
        quantityOfComments = quantityOfComments + ( if (commentedByMe) -1 else 1 )
    )
    is EventPost -> copy (
        commentedByMe = !commentedByMe,
        quantityOfComments = quantityOfComments + ( if (commentedByMe) -1 else 1 )
    )
    is VideoPost -> copy (
        commentedByMe = !commentedByMe,
        quantityOfComments = quantityOfComments + ( if (commentedByMe) -1 else 1 )
    )
    else -> this
}

fun Post.toggleShares(): Post = when (this) {
    is SimplePost -> copy (
        sharedByMe = !sharedByMe,
        quantityOfShares = quantityOfShares + ( if (sharedByMe) -1 else 1 )
    )
    is EventPost -> copy (
        sharedByMe = !sharedByMe,
        quantityOfShares = quantityOfShares + ( if (sharedByMe) -1 else 1 )
    )
    is VideoPost -> copy (
        sharedByMe = !sharedByMe,
        quantityOfShares = quantityOfShares + ( if (sharedByMe) -1 else 1 )
    )
    else -> this
}

data class Coordinates(
    val lat: Float = 0F,
    val lng: Float = 0F
)

data class SimplePost(
    override val author: String = "",
    override val content: String = "",
    override val createdTimeStamp: Int = 0,
    override val likedByMe: Boolean = false,
    override val commentedByMe: Boolean = false,
    override val sharedByMe: Boolean = false,
    override val quantityOfLikes: Int = 0,
    override val quantityOfComments: Int = 0,
    override val quantityOfShares: Int = 0
): Post

data class EventPost(
    override val author: String = "",
    override val content: String = "",
    override val createdTimeStamp: Int = 0,
    override val likedByMe: Boolean = false,
    override val commentedByMe: Boolean = false,
    override val sharedByMe: Boolean = false,
    override val quantityOfLikes: Int = 0,
    override val quantityOfComments: Int = 0,
    override val quantityOfShares: Int = 0,
    val address: String,
    val place: Coordinates
): Post

data class VideoPost(
    override val author: String = "",
    override val content: String = "",
    override val createdTimeStamp: Int = 0,
    override val likedByMe: Boolean = false,
    override val commentedByMe: Boolean = false,
    override val sharedByMe: Boolean = false,
    override val quantityOfLikes: Int = 0,
    override val quantityOfComments: Int = 0,
    override val quantityOfShares: Int = 0,
    val videoUrl: String
): Post