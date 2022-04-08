package com.example.contactdetails

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactdetails.Models.Contact
import com.example.contactdetails.databinding.FragmentFirstBinding
import org.jetbrains.annotations.NotNull

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = NameAdapter(requireActivity(), ContactList())
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

   private fun ContactList(): List<Contact> {
        return listOf(
            Contact("Adam", R.drawable.a, "202-555-0173"),
            Contact("Augustus", R.drawable.b, "202-555-0169"),
            Contact("Caspian", R.drawable.c, "202-555-0141"),
            Contact("Charlie", R.drawable.d, "202-555-0191"),
            Contact("Dante", R.drawable.e, "202-555-0179"),
            Contact("Edward", R.drawable.f, "202-555-0180"),
            Contact("Emmett", R.drawable.g, "510-555-0199"),
            Contact("Everett", R.drawable.i, "510-555-0147"),
            Contact("Ian", R.drawable.j, "510-555-0105"),
            Contact("Jonathan", R.drawable.k, "510-555-0146"),
            Contact("Kane", R.drawable.l, "510-555-0117"),
            Contact("Magnus", R.drawable.m, "510-555-0135"),
            Contact("Kian", R.drawable.n, "410-555-0176"),
            Contact("Maverick", R.drawable.aa, "410-555-0159"),
            Contact("Rhett", R.drawable.bb, "410-555-0190"),
            Contact("Winston", R.drawable.cc, "410-555-0113"),
            Contact("Xander", R.drawable.dd, "410-555-0154"),
            Contact("Raj MAurya", R.drawable.ee, "410-555-0183"),
            Contact("Abhishek", R.drawable.ff, "704-555-0129"),
            Contact("Ajay kumar", R.drawable.gg, "704-555-0104"),
            Contact("Vijay singh", R.drawable.hh, "704-555-0182"),
            Contact("Raghav singh", R.drawable.h, "704-555-0151")
        )
    }

    class NameAdapter( val context: Context,  val contacts: List<Contact>) :
        RecyclerView.Adapter<NameAdapter.NameHolder>() {
        class NameHolder(private val view: View) : RecyclerView.ViewHolder(view) {
            val textPerson: TextView = view.findViewById(R.id.textPerson)
            val textContact: TextView = view.findViewById(R.id.textContact)
            val img: ImageView = view.findViewById(R.id.img)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameHolder {
            val layout = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false)
            return NameHolder(layout)
        }

        override fun onBindViewHolder(holder: NameHolder, position: Int) {
            val name = contacts[position]
            holder.textPerson.text = name.name
            holder.textContact.text = name.contact
            holder.img.setImageResource(name.image)
        }

        override fun getItemCount(): Int {
           return contacts.size
        }
    }
}