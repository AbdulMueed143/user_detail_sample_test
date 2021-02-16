package au.com.userdetailsampletest

import android.os.Bundle
import android.view.View
import au.com.userdetailsampletest.fragments.AlbumListFragment
import au.com.userdetailsampletest.models.entitymodels.Album
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_album.*

class ActivityAlbum : DaggerAppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        btnBack.setOnClickListener(this)

        val userId = intent.extras?.get(Album.COL_ALBUM_ID) as Int?
        (albumListFramgmentHolder as AlbumListFragment).setUserId(userId!!)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btnBack -> {
                finish()
            }
        }
    }
}