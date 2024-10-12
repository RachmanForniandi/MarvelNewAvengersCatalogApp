package rachman.forniandi.thenewavengerscatalogapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import rachman.forniandi.marvelnewavengerscatalogapp.R
import java.util.Timer
import kotlin.concurrent.schedule

class SplashScreenActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Timer("splashGone", true).schedule(3000) {
            val intentToList = Intent(this@SplashScreenActivity,MainActivity::class.java)
            startActivity(intentToList)
            finish()
        }
    }
}