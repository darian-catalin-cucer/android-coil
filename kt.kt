// Import the required dependencies for Coil library
import coil.Coil
import coil.ImageLoader
import coil.request.ImageRequest
import coil.size.Size
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation

// Create an instance of the Coil Image Loader
val imageLoader = Coil.imageLoader(this)

// Load an image into an ImageView
imageView.load("https://example.com/image.jpg") {
    // Request a specific size
    size(Size(100, 100))

    // Apply transformations
    transformations(CircleCropTransformation(), GrayscaleTransformation())

    // Apply additional parameters
    crossfade(true)
    placeholder(R.drawable.placeholder)
    error(R.drawable.error)
}

// Load an image and get a drawable result
val drawable = imageLoader.get("https://example.com/image.jpg") {
    // Request a specific size
    size(Size(100, 100))

    // Apply transformations
    transformations(CircleCropTransformation(), GrayscaleTransformation())
}

// Load an image and get a Bitmap result
val bitmap = imageLoader.get("https://example.com/image.jpg") {
    // Request a specific size
    size(Size(100, 100))

    // Apply transformations
    transformations(CircleCropTransformation(), GrayscaleTransformation())
}.bitmap

// Load an image into an ImageView using an ImageRequest
val imageRequest = ImageRequest.Builder("https://example.com/image.jpg")
    .size(Size(100, 100))
    .transforms(CircleCropTransformation(), GrayscaleTransformation())
    .build()

imageLoader.enqueue(imageRequest) { result ->
    // Handle the result
    when (result) {
        is Result.Success -> {
            // The request was successful
            imageView.setImageDrawable(result.drawable)
        }
        is Result.Error -> {
            // The request failed
            // Show an error message or fallback to a default image
        }
    }
}
