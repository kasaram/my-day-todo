package com.github.naz013.tasker.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.github.naz013.tasker.data.AppDb
import com.github.naz013.tasker.data.TaskGroup

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
class HomeViewModel(application: Application) : AndroidViewModel(application) {

    val data: LiveData<List<TaskGroup>> = AppDb.getInMemoryDatabase(application.applicationContext).groupDao().loadAll()
}