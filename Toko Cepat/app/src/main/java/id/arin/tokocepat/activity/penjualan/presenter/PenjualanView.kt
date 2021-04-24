package id.arin.tokocepat.activity.penjualan.presenter

import id.arin.tokocepat.model.Barang
import id.arin.tokocepat.model.Keranjang

interface PenjualanView {
    fun onSuccessGetKeranjang(keranjang: List<Keranjang?>?)
    fun onFailedGetKeranjang(msg: String?)

    fun onSuccessSearchItem(barangs: List<Barang?>?)
    fun onFailedSearchItem(msg : String?)

    fun onSuccessAddItemToKeranjang(msg: String?)
    fun onFailedAddItemToKeranjang(msg: String?)

    fun onSuccessDeleteItemKeranjang(msg: String?)
    fun onFailedDeleteItemKeranjang(msg: String?)

    fun onSuccessJualBarang(msg: String?)
    fun onFailedJualBarang(msg: String?)

    fun onSuccessAddKeranjang(msg: String?)
    fun onFailedAddKeranjang(msg: String?)
}