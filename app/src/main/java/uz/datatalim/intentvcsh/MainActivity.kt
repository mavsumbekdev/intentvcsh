package uz.datatalim.intentvcsh

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val CHOOSE_IMAGE_CODE=1534
    lateinit var imgPicture:ImageView
    lateinit var uri:Uri


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initviews()
    }

    private fun initviews() {
        var btnShareText = findViewById<Button>(R.id.btn_share_text)
        var btnOpenGalery = findViewById<Button>(R.id.btn_open_galery)
        var btnShareImage = findViewById<Button>(R.id.btn_share_imagr)
        var btnShareTextImage = findViewById<Button>(R.id.btn_share_text_imagr)
        imgPicture=findViewById<ImageView>(R.id.img_picture)

        btnShareText.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type="text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,"Mavsumbek")
            intent.putExtra(Intent.EXTRA_STREAM,uri)
            startActivity(Intent.createChooser(intent,"Send via"))
        }
        btnOpenGalery.setOnClickListener {
            val intent=Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(Intent.createChooser(intent,"choose one"),CHOOSE_IMAGE_CODE)
        }
        btnShareImage.setOnClickListener {
            var intent = Intent(Intent.ACTION_SEND)
            intent.type="image/*"
            intent.putExtra(Intent.EXTRA_STREAM,uri)
            startActivity(Intent.createChooser(intent,"mavsumbek"))

        }
        btnShareTextImage.setOnClickListener{
            var intent = Intent(Intent.ACTION_SEND)
            intent.type="text/plam"
            intent.type="image/*"
            intent.putExtra(Intent.EXTRA_TEXT,"mavsumbek")
            intent.putExtra(Intent.EXTRA_STREAM,uri)
            startActivity(Intent.createChooser(intent,"send via"))
            startActivity(Intent.createChooser(intent,"mavsumbek"))
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==CHOOSE_IMAGE_CODE && resultCode== RESULT_OK){
            uri= data?.data!!
            imgPicture.setImageURI(uri)
        }

    }
}