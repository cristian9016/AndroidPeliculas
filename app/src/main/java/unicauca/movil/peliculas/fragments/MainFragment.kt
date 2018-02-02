package unicauca.movil.peliculas.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import org.jetbrains.anko.support.v4.startActivity
import unicauca.movil.peliculas.DetailActivity
import unicauca.movil.peliculas.R
import unicauca.movil.peliculas.adapters.PeliculaAdapter
import unicauca.movil.peliculas.util.Data


class MainFragment : Fragment() {

    val adapter:PeliculaAdapter = PeliculaAdapter(this::movieSelected)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onResume() {
        super.onResume()
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(activity)
        adapter.data = Data.peliculas
    }

    fun movieSelected(pos:Int){
        startActivity<DetailActivity>("pos" to pos)
    }

    companion object {
        fun instance():MainFragment = MainFragment()
    }

}
