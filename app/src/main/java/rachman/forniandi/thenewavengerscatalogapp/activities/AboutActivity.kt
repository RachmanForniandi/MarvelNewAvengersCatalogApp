package rachman.forniandi.thenewavengerscatalogapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import rachman.forniandi.marvelnewavengerscatalogapp.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAboutBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}