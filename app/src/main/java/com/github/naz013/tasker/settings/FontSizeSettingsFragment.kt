package com.github.naz013.tasker.settings

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.github.naz013.tasker.R
import com.github.naz013.tasker.arch.BaseFragment
import com.github.naz013.tasker.utils.Prefs
import com.mcxiaoke.koi.ext.onClick
import kotlinx.android.synthetic.main.fragment_font_size.*

/**
 * Copyright 2018 Nazar Suhovich
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
class FontSizeSettingsFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_font_size, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateShowcase(Prefs.getInstance(context!!).getFontSize())

        fab.onClick { findNavController().navigateUp() }
        slider.value = Prefs.getInstance(context!!).getFontSize()
    }

    private fun updateShowcase(points: Int) {
        showCase.setTextSize(TypedValue.COMPLEX_UNIT_SP, points.toFloat())
    }

    override fun onStop() {
        super.onStop()
        Prefs.getInstance(context!!).setFontSize(slider.value)
    }
}