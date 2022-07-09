package com.gaur.cloudeqtask.repository

import com.gaur.cloudeqtask.common.ExtensionUtils
import com.gaur.cloudeqtask.first.model.FakeItem

class FirstRepository {

    fun getList():List<FakeItem> = ExtensionUtils.getlist()



}