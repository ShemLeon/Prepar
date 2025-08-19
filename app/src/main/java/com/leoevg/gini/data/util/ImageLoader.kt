package com.leoevg.gini.data.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File

object ImageLoader {
    fun saveImage(context: Context, bitmap: Bitmap, id: Int): String {
        val filesDir = context.filesDir
        val imageFile = File(filesDir, "image-$id.jpg")
        imageFile.outputStream().use { outputStream ->
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outputStream)
        }
        return imageFile.absolutePath
    }

    fun loadImage(context: Context, fileName: String): Bitmap? {
        val imageFile = File(context.filesDir, "$fileName.jpg")
        return if (imageFile.exists()) {
            BitmapFactory.decodeFile(imageFile.absolutePath)
        } else {
            null
        }
    }
}