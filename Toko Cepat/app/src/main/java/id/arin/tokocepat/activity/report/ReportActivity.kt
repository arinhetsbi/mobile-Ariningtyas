package id.arin.tokocepat.activity.report

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import id.arin.tokocepat.R
import id.arin.tokocepat.activity.report.adapter.ReportAdapter
import id.arin.tokocepat.activity.report.detail.DetailReportFragment
import id.arin.tokocepat.activity.report.presenter.ReportPresenter
import id.arin.tokocepat.activity.report.presenter.ReportView
import id.arin.tokocepat.base.BaseActivity
import id.arin.tokocepat.model.Keranjang
import id.arin.tokocepat.model.KeranjangStatus
import id.arin.tokocepat.model.Penjualan
import kotlinx.android.synthetic.main.activity_report.*
import org.jetbrains.anko.toast

class ReportActivity : BaseActivity(), ReportView {
//    override fun onListFragmentInteraction(item: Penjualan?) {
//
//    }

    private lateinit var presenter: ReportPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        cekSesi(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        presenter = ReportPresenter(this)
        presenter.getReportAll(user?.idUser)
    }

    override fun onSuccessReport(keranjang: List<Keranjang?>?) {
        rvReport.adapter = ReportAdapter(keranjang, object : ReportAdapter.OnClick {
            override fun click(keranjang: Keranjang?, position: Int) {
                val bundle = Bundle()
                bundle.putSerializable("penjualan", keranjang)

                val detailReportFragment = DetailReportFragment()
                detailReportFragment.arguments = bundle

                detailReportFragment.show(supportFragmentManager, "Report")
            }

            override fun restore(keranjang: Keranjang?) {
                presenter.restoreStatus(user?.idUser, Integer.parseInt(keranjang?.idKeranjang),
                    KeranjangStatus.PENDING.status, Integer.parseInt(keranjang?.qty), keranjang?.totalHarga)
            }
        })
    }

    override fun onFailedReport(localizedMessage: String?) {
        d("ReportActivity", localizedMessage)
    }

    override fun onSuccessRestore(msg: String?) {
        toast("Berhasil membatalkan penjualan").show()
        presenter.getReportAll(user?.idUser)
    }

    override fun onFailedRestore(msg: String?) {
        d("ReportActivity", msg)
    }

}
