package ccom.seleznov.randome.remote

import androidx.paging.DataSource
import com.seleznov.randome.remote.ApiService
import com.seleznov.randome.remote.PersonDataSource
import com.seleznov.randome.remote.dto.PersonModel

class DataSourceFactory(private val api: ApiService) : DataSource.Factory<Int, PersonModel>() {

    private lateinit var personDataSource: PersonDataSource

    override fun create(): DataSource<Int, PersonModel> {
        personDataSource = PersonDataSource(api)
        return personDataSource
    }

    fun clear() = personDataSource.clear()

}