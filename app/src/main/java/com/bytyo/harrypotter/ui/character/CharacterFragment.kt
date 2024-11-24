package com.bytyo.harrypotter.ui.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bytyo.harrypotter.CharacterAdapter
import com.bytyo.harrypotter.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {

    private var _binding: FragmentCharacterBinding? = null

    private val binding get() = _binding!!

    private lateinit var adapter: CharacterAdapter
    private lateinit var recyclerView: RecyclerView
    //
    private lateinit var characterViewModel: CharacterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val characterViewModel =
            ViewModelProvider(this).get(CharacterViewModel::class.java)

        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        characterViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }


        //


        // Inisialisai RecycleView dan Adapter
        recyclerView = binding.rvCharacter
        adapter = CharacterAdapter(emptyList())
        recyclerView.adapter = adapter

        // Observasi data character dari ViewModel
        characterViewModel.getCharacters().observe(viewLifecycleOwner) {
            characters ->
            adapter = CharacterAdapter(characters)
            recyclerView.adapter = adapter
        }


        //

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}