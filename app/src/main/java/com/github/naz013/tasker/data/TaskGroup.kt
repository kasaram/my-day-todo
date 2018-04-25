package com.github.naz013.tasker.data

import android.arch.persistence.room.*

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
@Entity(indices = [Index("position"), Index("name")])
@TypeConverters(TasksConverter::class)
data class TaskGroup(
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        var color: String,
        var position: Int,
        var name: String,
        var tasks: MutableList<Task>,
        var active: Boolean = true
) {
    @Ignore
    constructor():this(0, "", 0, "", mutableListOf())
}