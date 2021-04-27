package com.mudassir.data.local

import com.mudassir.data.local.dao.WealthParkDao
import com.mudassir.data.local.models.DataEntityLocal
import io.reactivex.rxjava3.core.Single

class WealthParkLocalDataSource constructor(private val wealthParkDao: WealthParkDao) {

    fun getData(): Single<DataEntityLocal> =
        wealthParkDao.getData().toSingle()

    fun insertData(dataEntityLocal: DataEntityLocal) =
        wealthParkDao.insert(dataEntityLocal)

    fun deleteAllData() = wealthParkDao.deleteAllData()
}