package com.breezefieldjaimedicalplus.features.document.presentation

import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.breezefieldjaimedicalplus.CustomStatic
import com.breezefieldjaimedicalplus.R
import com.breezefieldjaimedicalplus.app.AppDatabase
import com.breezefieldjaimedicalplus.app.NetworkConstant
import com.breezefieldjaimedicalplus.app.Pref
import com.breezefieldjaimedicalplus.app.domain.DocumentypeEntity
import com.breezefieldjaimedicalplus.app.types.FragType
import com.breezefieldjaimedicalplus.app.utils.AppUtils
import com.breezefieldjaimedicalplus.base.presentation.BaseActivity
import com.breezefieldjaimedicalplus.base.presentation.BaseFragment
import com.breezefieldjaimedicalplus.features.dashboard.presentation.DashboardActivity
import com.breezefieldjaimedicalplus.features.document.api.DocumentRepoProvider
import com.breezefieldjaimedicalplus.features.document.model.DocumentTypeResponseModel
import com.breezefieldjaimedicalplus.features.dymanicSection.api.DynamicRepoProvider
import com.breezefieldjaimedicalplus.features.dymanicSection.model.DynamicListResponseModel
import com.breezefieldjaimedicalplus.widgets.AppCustomTextView

import com.pnikosis.materialishprogress.ProgressWheel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import timber.log.Timber

class DocumentTypeListFragment : BaseFragment() {

    private lateinit var mContext: Context

    private lateinit var rv_doc_type_list: RecyclerView
    private lateinit var tv_no_data_available: AppCustomTextView
    private lateinit var progress_wheel: ProgressWheel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_document_type_list, container, false)

        initView(view)

        val own = AppDatabase.getDBInstance()?.documentTypeDao()?.getOwnList()
        if (own != null && own.isNotEmpty())
            initAdapter(own)
        //else
            //getDocumentTypeApi()

        return view
    }

    private fun initView(view: View) {
        view.apply {
            rv_doc_type_list = findViewById(R.id.rv_doc_type_list)
            tv_no_data_available = findViewById(R.id.tv_no_data_available)
            progress_wheel = findViewById(R.id.progress_wheel)
        }

        progress_wheel.stopSpinning()
        rv_doc_type_list.layoutManager = GridLayoutManager(mContext, 2) as RecyclerView.LayoutManager?
    }

    private fun getDocumentTypeApi() {
        if (!AppUtils.isOnline(mContext)) {
            (mContext as DashboardActivity).showSnackMessage(getString(R.string.no_internet))
            return
        }

        val repository = DocumentRepoProvider.documentRepoProvider()
        progress_wheel.spin()
        BaseActivity.compositeDisposable.add(
                repository.getDocType()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({ result ->
                            val response = result as DocumentTypeResponseModel
                            Timber.d("DOCUMENT TYPE LIST RESPONSE=======> " + response.status)

                            if (response.status == NetworkConstant.SUCCESS) {
                                if (response.type_list != null && response.type_list!!.size > 0) {

                                    doAsync {
                                        response.type_list?.forEach {
                                            val docTypeEntity = DocumentypeEntity()
                                            AppDatabase.getDBInstance()?.documentTypeDao()?.insert(docTypeEntity.apply {
                                                type_id = it.id
                                                type_name = it.type
                                                image = it.image
                                                IsForOrganization= it.IsForOrganization
                                                IsForOwn = it.IsForOwn
                                            })
                                        }

                                        uiThread {
                                            progress_wheel.stopSpinning()
                                            initAdapter(AppDatabase.getDBInstance()?.documentTypeDao()?.getAll())
                                        }
                                    }

                                } else {
                                    progress_wheel.stopSpinning()
                                    tv_no_data_available.visibility = View.VISIBLE
                                    (mContext as DashboardActivity).showSnackMessage(response.message!!)
                                }
                            } else {
                                progress_wheel.stopSpinning()
                                tv_no_data_available.visibility = View.VISIBLE
                                (mContext as DashboardActivity).showSnackMessage(response.message!!)
                            }

                        }, { error ->
                            error.printStackTrace()
                            progress_wheel.stopSpinning()
                            tv_no_data_available.visibility = View.VISIBLE
                            (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
                            Timber.d("DOCUMENT TYPE LIST ERROR=======> " + error.localizedMessage)
                        })
        )
    }

    private fun initAdapter(docTypeList:  List<DocumentypeEntity>?) {
        tv_no_data_available.visibility = View.GONE
        rv_doc_type_list.adapter = DocumentTypeAdapter(mContext, docTypeList as ArrayList<DocumentypeEntity>, {
            (mContext as DashboardActivity).loadFragment(FragType.DocumentListFragment, true, it.type_id!!)
        })
    }
}