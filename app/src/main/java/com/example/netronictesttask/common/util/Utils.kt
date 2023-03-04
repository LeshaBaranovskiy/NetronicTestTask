package com.example.netronictesttask.common.util

import android.content.Context
import android.graphics.Bitmap
import java.io.File
import java.io.FileOutputStream
import kotlin.streams.asSequence

class Utils {
    companion object {
        fun generateRandomString(): String {
            val source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            return java.util.Random().ints(10, 0, source.length)
                .asSequence()
                .map(source::get)
                .joinToString("")
        }

        fun saveImageToInternalStorage(bitmap: Bitmap, imageTitle: String, context: Context, packageName: String) {
            val directory: File = File(context.getExternalFilesDir(null), "images")
            if (!directory.exists()) {
                directory.mkdir()
            }
            val fname = "$imageTitle.jpg"
            val file = File(directory, fname)
            if (file.exists()) file.delete()
            try {
                val out = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out)
                out.flush()
                out.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun deleteAllImagesFromInternalStorage(context: Context) {
            val directory: File = File(context.getExternalFilesDir(null), "images")
            if (directory.exists()) {
                if (directory.isDirectory) {
                    val contents: Array<File>? = directory.listFiles()
                    if (contents != null) {
                        for (file in contents) {
                            file.delete()
                        }
                    }
                }
                directory.delete()
            }
        }
    }
}