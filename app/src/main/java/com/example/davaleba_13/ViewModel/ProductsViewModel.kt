package com.example.davaleba_13.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.davaleba_13.Model.Product
import com.example.davaleba_13.RetrofitProduct
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {

    private val _flow = MutableSharedFlow<Product>()
    val flow: SharedFlow<Product> get() = _flow

    //or xazs vwert radgan, gamoyeneba gviwevs mainactivityshi da iqidan rom ariyos shecva damateba
    //da ragaceebi, amitomac vwert orjer, vushvebt iq rom sheudzlebeli ikos garedan
    //chven monacemebze ragac zemoqmedebis moxdena
    //get() = arastatikurad vanichebt, meore flows roca gamoviyenebt da shevcvlit, is shecvliili
    //mova, meore cvlads ro gamovidzaxebt mag dros wava da miakitxavs da ra monacemic uchiravs
    //imas wamoigebs
    //ufalodavigale

    suspend fun infoGett(){
        viewModelScope.launch {
          val response = RetrofitProduct.getProducts().infoGet()
            val body:Product? = response.body()
            if(response.isSuccessful && body!=null){
                _flow.emit(body)
                Log.d("vai sacodao saqartvelo", body.toString())

                //emit funqcia, vacherinebt monacemebs, vawvdit obieqts, romelzec mere moaxdens dakvirvebas

            } else {
            val error = response.errorBody()
                Log.d("vai sacodao saqartvelo", body.toString())
            }
        }


    }
}