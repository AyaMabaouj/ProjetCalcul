package com.example.puzzle

import android.graphics.BitmapFactory
import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.util.Collections
import java.util.Random
var pieces : ArrayList<PuzzlePiece>? = null
var mCurrentPhotoPath : String? = null
var mCurrentPhotoUri: String? = null
class PuzzleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        val layout = findViewById<ImageView>(R.id.imageView)

        val imageView = findViewById<ImageView>(R.id.imageView6)

        val intent = intent
        val assetName = intent.getStringExtra("assetName")
        mCurrentPhotoPath = intent.getStringExtra("mCurrentPhotoPath")
        mCurrentPhotoUri = intent.getStringExtra("mCurrentPhotoUri")

        imageView.post{
            if(assetName != null){
                setPicFromAsset(assetName,imageView)
            }
            else if (mCurrentPhotoPath != null){
                setPicFromPhotoPath(mCurrentPhotoPath,imageView)
            }
            else if (mCurrentPhotoUri != null){
                imageView.setImageURI(Uri.parse(mCurrentPhotoUri))
            }
            pieces = splitImage()
            val touchListener = TouchListener(this@PuzzleActivity)
            Collections.shuffle(pieces)
            for(piece in pieces!!){
                piece.setOnTouchListener(touchListener)
                layout.addView(piece)

                val lParams = piece.layoutParams as RelativeLayout.LayoutParams
                        lParams.leftMargin = Random.nextInt(
                            layout.width - piece.pieceWith
                )
                lParams.topMargin = layout.height - piece.pieceHeight
                piece.layoutParams = lParams
            }

        }
    }

    private fun setPicFromAsset(assetName: String, imageView: ImageView?) {

        val targetW = imageView!!.width
        val targetH = imageView!!.height
        val am = assets
        try {

            val `is` = am.open("img/$assetName")
            val bmOption = BitmapFactory.Options()
            BitmapFactory.decodeStream(
                `is`, Rect(-1,-1,-1,-1),bmOption
            )
            val photoW = bmOption.outWidth
            val photoH = bmOption.outHeight

            val scalFactor = Math.min(
                photoW/targetW,photoH/targetH
            )

            bmOption.inJustDecodeBounds = false
            bmOption.inSampleSize = scalFactor
            bmOption.inPurgeable = true
           val bitmap = BitmapFactory.decodeStream(
                `is`, Rect(-1,-1,-1,-1),bmOption
            )

        }catch (e:IOException){
            e.printStackTrace()
            Toast.makeText(this@PuzzleActivity,e.localizedMessage,Toast.LENGTH_SHORT).show()
        }


    }
}