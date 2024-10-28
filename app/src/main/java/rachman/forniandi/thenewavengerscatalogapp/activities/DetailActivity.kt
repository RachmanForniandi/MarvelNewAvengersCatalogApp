package rachman.forniandi.thenewavengerscatalogapp.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import rachman.forniandi.marvelnewavengerscatalogapp.R
import rachman.forniandi.marvelnewavengerscatalogapp.databinding.ActivityDetailBinding
import rachman.forniandi.thenewavengerscatalogapp.activities.MainActivity.Companion.DETAIL_HERO
import rachman.forniandi.thenewavengerscatalogapp.models.HeroMember

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var detailData:HeroMember?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setContentView(binding.root)


        detailData = intent.getParcelableExtra<HeroMember>(DETAIL_HERO)

        detailData?.image?.let { binding.imgHeroDetail.setImageResource(it) }
        binding.tvHeroNameDetail.text = detailData?.name
        binding.tvAliasHeroName.text= detailData?.alias
        binding.tvSummaryHeroDetail.text = detailData?.description
        binding.tvPowerHeroDetail.text = detailData?.powers
        binding.tvAbilitiesHeroDetail.text = detailData?.abilities
    }

}