package rachman.forniandi.thenewavengerscatalogapp.activities

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import rachman.forniandi.marvelnewavengerscatalogapp.R
import rachman.forniandi.marvelnewavengerscatalogapp.databinding.ActivityMainBinding
import rachman.forniandi.thenewavengerscatalogapp.adapters.CarrouselAdapter
import rachman.forniandi.thenewavengerscatalogapp.adapters.MemberAdapter
import rachman.forniandi.thenewavengerscatalogapp.models.HeroMember
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var data:ArrayList<HeroMember>?= null
    private var dataForCarrousel:ArrayList<HeroMember>?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setSupportActionBar(binding.toolbarMain)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setContentView(binding.root)


        data = ArrayList()
        dataForCarrousel = ArrayList()
        showHeroList()
        showHeroList2()
    }

    private fun showHeroList2() {
        binding.viewPagerCarrousel.apply {

            clipChildren = false
            clipToPadding = false
            offscreenPageLimit = 3
            (getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER
        }

        dataForCarrousel?.add(HeroMember(R.drawable.captain_america,"Captain America","Steve Rogers","The First Avenger helped the Allies win the war, but not before he was lost at sea and frozen in ice in a form of suspended animation for decades. He was thawed out in the modern age to continue the battle alongside his new allies the Avengers.","-Artificially Enhanced Physiology","- Master Tactician and Strategist, \n- Master Martial Artist,\n- Master Shield Fighter, \n- Master Acrobat, \n- Indomitable Will"))
        dataForCarrousel?.add(HeroMember(R.drawable.iron_man,"Iron-Man","Anthony Stark","a genius inventor and billionaire industrialist, \nwho suits up in his armor of cutting-edge technology \nto become the super hero Iron Man.","- None","- Super-Genius Intelligence ,\n- Master Engineer,\n- Master Tactician,\n- Multilingual"))
        dataForCarrousel?.add(HeroMember(R.drawable.thor,"Thor","Thor Odinson/ \nDonald Blake","The God of Thunder of Asgardians, a group of humanoid beings from the pocket dimension of Asgard.","-Godly Strength","- Master Combatant, \n- Above Normal Intelligence, \n- Telepathy Immunity, \n- Diplomatic Immunity"))
        dataForCarrousel?.add(HeroMember(R.drawable.black_widow,"Black Widow","Natasha Romanoff","She was a former Russian KGB agent and trained by the \"Red Room\" as part of the Black Widow Ops Program to be the ultimate \"Super-Spy\".\nLater she  defected to the United States of America \nfrom the Soviet Union to join S.H.I.E.L.D and finally The avengers.","- Artificially-Enhanced Physiology","- Master Martial Artist, \n- Master Acrobat,\n- Master Assassin,\n- Master Spy"))
        dataForCarrousel?.add(HeroMember(R.drawable.luke_cage,"Power Man","Lucas \"Luke\" Cage","Former volunteer which gave him unbreakable \nskin that almost unendurable from anything. \nThen he started as \"Heroes For Hire\", Some hero service \nthat help anyone who could meet his price and finally he joined as New Avengers ","-Burstein Process (various enhancement body process)","- Expert Combatant,\n- Skilled Athlete,\n- Extended Education,\n- Strong Speaker"))
        dataForCarrousel?.add(HeroMember(R.drawable.spider_man,"Spider-Man","Peter Parker","Bitten by RadioActive Spider gave Peter Parker ability to super agility, cling on the wall & \nBizarre sense like \"Spider sense\" make him aware \ndanger around him, Also With his intelligence & wise word about power & responsibility make him Hero Wannabe like Spider-man.Later, By the recommendation from his mentor Iron-Man, \nHe Joined as New Member of Avengers.","- Super Agility, \n- Wall Crawling, \n- Spider sense","- Gifted Intellect, \n- Expert Inventor/Engineer,\n- Skilled Photographer,\n- Master Acrobat"))
        dataForCarrousel?.add(HeroMember(R.drawable.spider_woman,"Spider-Woman","Jessica Drew","Bitten by RadioActive Spider, her father injected \nher with a spider-serum to cure her. As she grew up, she discovered that she had developed spider-like abilities. As soon she grew up,She was brainwashed by Hydra and work as Spy for US Government.\nAs for redemption,She Joined as New Member of Avengers.","- Venom Blasts,\n- Wall Crawling,\n- Pheromone Secretion","- Master Martial Artist,\n- Skilled Spy,\n- Skilled Acrobat,\n- Master Acrobat,\n- Skilled Investigator"))
        dataForCarrousel?.add(HeroMember(R.drawable.hulk,"Hulk","Dr. Bruce Banner","During saving young lad in the middle of live test gamma bomb,Bruce Banner mutated into a green behemoth, \nthe living personification of rage, fueled by pure physical strength \nnamed Hulk.","-Gamma Mutate Physiology, \n- Unlimited Strength, \n- Dynamic Durability, \n- Self-Regeneration Manipulation","- Super-Genius Intelligence, \n- Master Combatant, \n- Indomitable Will, \n- Powerful Leap"))
        dataForCarrousel?.add(HeroMember(R.drawable.sentry,"Sentry","Robert Reynolds","After being mutated by the Golden Sentry Serum,Robert Reynolds become the most powerful individual named the Sentry. ","- Chemically Enhanced Physiology, " +
                "\n- Super Strength, \n- Superhuman Senses,\n- Superhuman Stamina,\n- Photo-kinesis","-Genius Intelligence"))
        dataForCarrousel?.add(HeroMember(R.drawable.black_panther,"Black Panther","T'Challa","Using Wakanda's advanced Vibranium technology and his own abilities and fortune, he pledged his life to the service of all humankind.","- Super Agility, \n- Black Panther Knowledge, \n- Superhumanly Acute Senses,\n- Peak Human Strength,\n-Peak Human Stamina,\n- Peak human Speed,\n- Peak human reflexes","-Genius Intelligence, \n- Master Martial Artist, \n- Multilingual, \n- Expert Tracker & Hunter"))


        binding.viewPagerCarrousel.adapter = CarrouselAdapter(dataForCarrousel!!, object : CarrouselAdapter.OnItemCarrouselClickListener{
            override fun onClickItemCarrousel(position: Int, hero: HeroMember) {
                val toDetail = Intent(this@MainActivity,DetailActivity::class.java)
                toDetail.putExtra(DETAIL_HERO,hero)
                startActivity(toDetail)
            }
        })

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((40 * Resources.getSystem().displayMetrics.density).toInt()))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = (0.80f + r * 0.20f)
        }
        binding.viewPagerCarrousel.setPageTransformer(compositePageTransformer)
    }

    private fun showHeroList() {

        data?.add(HeroMember(R.drawable.captain_america,"Captain America","Steve Rogers","The First Avenger helped the Allies win the war, but not before he was lost at sea and frozen in ice in a form of suspended animation for decades. He was thawed out in the modern age to continue the battle alongside his new allies the Avengers.","-Artificially Enhanced Physiology","- Master Tactician and Strategist, \n- Master Martial Artist,\n- Master Shield Fighter, \n- Master Acrobat, \n- Indomitable Will"))
        data?.add(HeroMember(R.drawable.iron_man,"Iron-Man","Anthony Stark","a genius inventor and billionaire industrialist, \nwho suits up in his armor of cutting-edge technology \nto become the super hero Iron Man.","- None","- Super-Genius Intelligence ,\n- Master Engineer,\n- Master Tactician,\n- Multilingual"))
        data?.add(HeroMember(R.drawable.thor,"Thor","Thor Odinson/ \nDonald Blake","The God of Thunder of Asgardians, a group of humanoid beings from the pocket dimension of Asgard.","-Godly Strength","- Master Combatant, \n- Above Normal Intelligence, \n- Telepathy Immunity, \n- Diplomatic Immunity"))
        data?.add(HeroMember(R.drawable.black_widow,"Black Widow","Natasha Romanoff","She was a former Russian KGB agent and trained by the \"Red Room\" as part of the Black Widow Ops Program to be the ultimate \"Super-Spy\".\nLater she  defected to the United States of America \nfrom the Soviet Union to join S.H.I.E.L.D and finally The avengers.","- Artificially-Enhanced Physiology","- Master Martial Artist, \n- Master Acrobat,\n- Master Assassin,\n- Master Spy"))
        data?.add(HeroMember(R.drawable.luke_cage,"Power Man","Lucas \"Luke\" Cage","Former volunteer which gave him unbreakable \nskin that almost unendurable from anything. \nThen he started as \"Heroes For Hire\", Some hero service \nthat help anyone who could meet his price and finally he joined as New Avengers ","-Burstein Process (various enhancement body process)","- Expert Combatant,\n- Skilled Athlete,\n- Extended Education,\n- Strong Speaker"))
        data?.add(HeroMember(R.drawable.spider_man,"Spider-Man","Peter Parker","Bitten by RadioActive Spider gave Peter Parker ability to super agility, cling on the wall & \nBizarre sense like \"Spider sense\" make him aware \ndanger around him, Also With his intelligence & wise word about power & responsibility make him Hero Wannabe like Spider-man.Later, By the recommendation from his mentor Iron-Man, \nHe Joined as New Member of Avengers.","- Super Agility, \n- Wall Crawling, \n- Spider sense","- Gifted Intellect, \n- Expert Inventor/Engineer,\n- Skilled Photographer,\n- Master Acrobat"))
        data?.add(HeroMember(R.drawable.spider_woman,"Spider-Woman","Jessica Drew","Bitten by RadioActive Spider, her father injected \nher with a spider-serum to cure her. As she grew up, she discovered that she had developed spider-like abilities. As soon she grew up,She was brainwashed by Hydra and work as Spy for US Government.\nAs for redemption,She Joined as New Member of Avengers.","- Venom Blasts,\n- Wall Crawling,\n- Pheromone Secretion","- Master Martial Artist,\n- Skilled Spy,\n- Skilled Acrobat,\n- Master Acrobat,\n- Skilled Investigator"))
        data?.add(HeroMember(R.drawable.hulk,"Hulk","Dr. Bruce Banner","During saving young lad in the middle of live test gamma bomb,Bruce Banner mutated into a green behemoth, \nthe living personification of rage, fueled by pure physical strength \nnamed Hulk.","-Gamma Mutate Physiology, \n- Unlimited Strength, \n- Dynamic Durability, \n- Self-Regeneration Manipulation","- Super-Genius Intelligence, \n- Master Combatant, \n- Indomitable Will, \n- Powerful Leap"))
        data?.add(HeroMember(R.drawable.sentry,"Sentry","Robert Reynolds","After being mutated by the Golden Sentry Serum,Robert Reynolds become the most powerful individual named the Sentry. ","- Chemically Enhanced Physiology, " +
                "\n- Super Strength, \n- Superhuman Senses,\n- Superhuman Stamina,\n- Photo-kinesis","-Genius Intelligence"))
        data?.add(HeroMember(R.drawable.black_panther,"Black Panther","T'Challa","Using Wakanda's advanced Vibranium technology and his own abilities and fortune, he pledged his life to the service of all humankind.","- Super Agility, \n- Black Panther Knowledge, \n- Superhumanly Acute Senses,\n- Peak Human Strength,\n-Peak Human Stamina,\n- Peak human Speed,\n- Peak human reflexes","-Genius Intelligence, \n- Master Martial Artist, \n- Multilingual, \n- Expert Tracker & Hunter"))

        binding.listMember.adapter = MemberAdapter(data!!,object : MemberAdapter.OnItemClickListener{
            override fun onClick(position: Int, hero: HeroMember) {
                val toDetail = Intent(this@MainActivity,DetailActivity::class.java)
                toDetail.putExtra(DETAIL_HERO,hero)
                startActivity(toDetail)
            }
        })
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.exit))
            .setMessage(getString(R.string.are_you_sure_do_you_want_to_exit))
            .setNegativeButton(getString(R.string.no), null)
            .setPositiveButton(getString(R.string.yes), object : DialogInterface.OnClickListener {
                override fun onClick(arg0: DialogInterface?, arg1: Int) {
                    super@MainActivity.onBackPressed()
                }
            }).create().show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_profile->{
                val intentToProfile = Intent(this@MainActivity,AboutActivity::class.java)
                startActivity(intentToProfile)
                true
            }
            else ->super.onOptionsItemSelected(item)
        }

    }

    companion object{
        const val DETAIL_HERO="detail_hero"
    }
}