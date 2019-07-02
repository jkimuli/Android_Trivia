package com.jkimuli.android.navigation

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.jkimuli.android.navigation.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding:FragmentTitleBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_title,
                                              container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        view.findViewById<Button>(R.id.playButton).setOnClickListener{
            findNavController().navigate(TitleFragmentDirections.destinationGame())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater?.inflate(R.menu.about_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){
            R.id.aboutFragment -> {
                findNavController().navigate(R.id.aboutFragment)
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }
}