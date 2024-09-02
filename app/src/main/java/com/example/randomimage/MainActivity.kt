package com.example.randomimage

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.example.randomimage.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val imageUrls = listOf(
        "https://images.unsplash.com/photo-1506748686214-e9df14d4d9d0",
        "https://images.unsplash.com/photo-1519337265831-281ec6cc8514",
        "https://images.unsplash.com/photo-1495567720989-cebdbdd97913",
        "https://images.unsplash.com/photo-1472214103451-9374bd1c798e",
        "https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d",
        "https://images.unsplash.com/photo-1516110833967-214a01a98028",
        "https://images.unsplash.com/photo-1517817748491-31d1eb7b0e73",
        "https://images.unsplash.com/photo-1517948430545-d3b92eac6c15",
        "https://images.unsplash.com/photo-1518073891098-cb5bdb4b2491",
        "https://images.unsplash.com/photo-1499951360447-b19be8fe80f5",
        "https://images.unsplash.com/photo-1517495306984-1a43ea63fad3",
        "https://images.unsplash.com/photo-1531177077037-b3f97a7d35a7",
        "https://images.unsplash.com/photo-1534975680042-9fbd9d6a1f90",
        "https://images.unsplash.com/photo-1516651029879-d3a89b2b7e78",
        "https://images.unsplash.com/photo-1475823678248-624fc6f85785",
        "https://images.unsplash.com/photo-1518837695005-2083093ee35b",
        "https://images.unsplash.com/photo-1542281286-9e0a16bb7366",
        "https://images.unsplash.com/photo-1535223289827-42f1e9919769",
        "https://images.unsplash.com/photo-1540206395-68808572332f",
        "https://images.unsplash.com/photo-1541009178411-47a1be6c69f7",
        "https://images.unsplash.com/photo-1549880186-7e5d15cd3c20",
        "https://images.unsplash.com/photo-1541339907198-e08756dedf3f",
        "https://images.unsplash.com/photo-1506748687452-1eaf36250a35",
        "https://images.unsplash.com/photo-1541823709867-1a9fe3c9f0a6",
        "https://images.unsplash.com/photo-1541698444083-023c97d3f4b6",
        "https://images.unsplash.com/photo-1541781774459-4f5a2f85e80a",
        "https://images.unsplash.com/photo-1524504388940-b1c1722653e1",
        "https://images.unsplash.com/photo-1533587851505-15ce70e1e8a3",
        "https://images.unsplash.com/photo-1504302514234-20a3b61a0653",
        "https://images.unsplash.com/photo-1534681942027-e4293d2f3b43",
        "https://images.unsplash.com/photo-1541544181074-e6f038240d9b",
        "https://images.unsplash.com/photo-1551326412-6dc7d9e88b56",
        "https://images.unsplash.com/photo-1561841953-4e70a4f7cb2d",
        "https://images.unsplash.com/photo-1563986768599-1013b2b7e482",
        "https://images.unsplash.com/photo-1542206395-9fbd9d6a1f90",
        "https://images.unsplash.com/photo-1574169208507-843761748fd6",
        "https://images.unsplash.com/photo-1585421514285-efb77d66a97e",
        "https://images.unsplash.com/photo-1593642634367-d91a135587b5",
        "https://images.unsplash.com/photo-1611996495757-d2cbf7f16763",
        "https://images.unsplash.com/photo-1600596329211-cb04c78468e9",
        "https://images.unsplash.com/photo-1600375462888-55f3e0f31cc2",
        "https://images.unsplash.com/photo-1602233698387-a9755d90614e",
        "https://images.unsplash.com/photo-1621337201423-98a8d784d7f0",
        "https://images.unsplash.com/photo-1621337200962-0b2ae068d203",
        "https://images.unsplash.com/photo-1611095785385-07e7e118f040",
        "https://images.unsplash.com/photo-1606923486851-f6b3fcb119bb",
        "https://images.unsplash.com/photo-1602233698555-e0a4240a9518",
        "https://images.unsplash.com/photo-1611095784543-f5d041cf54fd",
        "https://images.unsplash.com/photo-1595260285450-0c95c5c2cb0d",
        "https://images.unsplash.com/photo-1595260284236-d36d5ad04993"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("CicloDeVida", "onCreate called")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadRandomImage()

        binding.getRandomImage.setOnClickListener {
            loadRandomImage()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("CicloDeVida", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CicloDeVida", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CicloDeVida", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CicloDeVida", "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CicloDeVida", "onDestroy called")
    }

    private fun loadRandomImage() {
        binding.randomImage.setImageDrawable(null)
        binding.progressBar.visibility = View.VISIBLE

        val randomUrl = getRandomImage()

        Glide.with(this)
            .load(randomUrl)
            .apply(RequestOptions()
                .placeholder(R.drawable.placeholder_error)
                .error(R.drawable.placeholder_error)
                .override(800, 800)
            )
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    binding.randomImage.setImageDrawable(resource)
                    binding.errorText.text = ""

                    binding.progressBar.visibility = View.GONE
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    binding.progressBar.visibility = View.GONE
                }

                override fun onLoadFailed(errorDrawable: Drawable?) {
                    binding.randomImage.setImageDrawable(null)
                    binding.errorText.text = "Imagem não encontrada"

                    binding.progressBar.visibility = View.GONE
                }
            })
    }

    private fun getRandomImage() : String {
        val randomNumber = Random.nextInt(0, imageUrls.size - 1)
        return imageUrls[randomNumber]
    }
}
