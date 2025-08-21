package com.leoevg.gini.presentation.ui.util

import android.content.Context
import coil.ImageLoader
import coil.disk.DiskCache
import coil.request.CachePolicy

object PixabayLoader {
    fun create(context: Context): ImageLoader {
        return ImageLoader.Builder(context)
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCache {
                DiskCache.Builder()
                    .directory(
                        context.cacheDir.resolve("image_cache")
                    ).maxSizeBytes(5L * 1024 * 1024)
                    .build()
            }
            .respectCacheHeaders(false)
            .networkCachePolicy(CachePolicy.ENABLED)
            .build()
    }
}

