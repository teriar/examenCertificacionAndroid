package com.example.cl.examen_certifiacion.presentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.cl.examen_certifiacion.R
import com.example.cl.examen_certifiacion.databinding.FragmentDetalleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "id"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetalleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetalleFragment : Fragment() {

    lateinit var binding: FragmentDetalleBinding
    private val listVIewModel:ListViewModel by activityViewModels()

    // TODO: Rename and change types of parameters
    private var param1: Int? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetalleBinding.inflate(layoutInflater,container,false)
        val id  = param1
        var nombre = ""
        if(id != null) {
            listVIewModel.getDetailHero(id)

            listVIewModel.detailLiveData(id.toInt()).observe(viewLifecycleOwner){
                if(it !=null){
                    val ano = it.año_creacion.toString().toInt()
                    val poder = it.poder.toString()
                    val color = it.colo.toString()
                    nombre = it.nombre
                 binding.imgHero.load(it.imagenLink)
                 binding.txtSuperHero.text = it.nombre
                 binding.txtfecha.text = "Año de creacion $ano"
                 binding.txtPoder.text = "Poder: $poder"
                 binding.TxtColor.text = "color: $color"

                    if(it.traducion == true){
                        binding.txtTraduccion.text="Cuenta con traduccion"
                    }else{
                        binding.txtTraduccion.text = "No Cuenta con Traduccion"
                    }
                }
            }

        }


        crearCorreo(nombre)
        return binding.root
    }

    private fun crearCorreo(nombre: String) {
        val mensaje = "Hola " +
                "Quiero que el siguiente super héroes ${nombre}aparezca, en la nueva edición de\n" +
                "biografías animadas."
        binding.btnContactar.setOnClickListener{

            var intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(
                Intent.EXTRA_EMAIL,
                arrayOf("Comicconchile@hotmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Votacion $nombre")
            intent.putExtra(Intent.EXTRA_TEXT, mensaje)


            // Lanzo el selector de cliente de Correo
            startActivity(
                Intent
                    .createChooser(
                        intent,
                        "Elije un cliente de Correo:"
                    )
            )
        }
    }


}