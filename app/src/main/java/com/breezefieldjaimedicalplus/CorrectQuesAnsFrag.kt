package com.breezefieldjaimedicalplus

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.breezefieldjaimedicalplus.app.NetworkConstant
import com.breezefieldjaimedicalplus.app.Pref
import com.breezefieldjaimedicalplus.app.utils.AppUtils
import com.breezefieldjaimedicalplus.base.presentation.BaseActivity
import com.breezefieldjaimedicalplus.base.presentation.BaseFragment
import com.breezefieldjaimedicalplus.features.dashboard.presentation.DashboardActivity
import com.breezefieldjaimedicalplus.features.mylearning.ContentL
import com.breezefieldjaimedicalplus.features.mylearning.CorrectQuestionAnswer
import com.breezefieldjaimedicalplus.features.mylearning.MyTopicsWiseContents
import com.breezefieldjaimedicalplus.features.mylearning.Option
import com.breezefieldjaimedicalplus.features.mylearning.Question_answer_fetch_list
import com.breezefieldjaimedicalplus.features.mylearning.RetryCorrectQuestionAnswerAdapter
import com.breezefieldjaimedicalplus.features.mylearning.RetryIncorrectQuizFrag
import com.breezefieldjaimedicalplus.features.mylearning.TopicContentWiseAnswerListsFetchResponse
import com.breezefieldjaimedicalplus.features.mylearning.VideoTopicWiseResponse
import com.breezefieldjaimedicalplus.features.mylearning.apiCall.LMSRepoProvider
import com.pnikosis.materialishprogress.ProgressWheel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.ArrayList


class CorrectQuesAnsFrag : BaseFragment() , View.OnClickListener{

    private lateinit var correctAnswers: MutableList<String>
    private lateinit var incorrectAnswers: MutableList<String>
    private lateinit var recyclerView: RecyclerView
    private lateinit var no_crcct_answr: TextView
    private lateinit var content_name: TextView
    private lateinit var logo_of_crrct: ImageView
    private lateinit var iv_no_data_found_retry_: ImageView
    private lateinit var ll_root_correct: LinearLayout
    private lateinit var adapter: RetryCorrectQuestionAnswerAdapter
    private lateinit var mContext: Context
    lateinit var progress_wheel: ProgressWheel


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    companion object {
        var topicId: String = ""
        var storeContentId: String = ""

        fun getInstance(topicId: String, storeContentId: String): CorrectQuesAnsFrag {
            val fragment = CorrectQuesAnsFrag()
            this.topicId = topicId
            this.storeContentId = storeContentId
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_correct_ques_ans, container, false)
        initView(view)
        println("Topic ID: $topicId")
        println("Store Content ID: $storeContentId")
        return view
    }

    private fun initView(view: View) {
        recyclerView = view.findViewById(R.id.rv_correct_answer_tab)
        content_name = view.findViewById(R.id.content_name)
        logo_of_crrct = view.findViewById(R.id.logo_of_crrct)
        no_crcct_answr = view.findViewById(R.id.no_crcct_answr)
        progress_wheel = view.findViewById(R.id.crrct_progress_wheel)
        iv_no_data_found_retry_ = view.findViewById(R.id.iv_no_data_found_retry_)
        ll_root_correct = view.findViewById(R.id.ll_root_correct)

        recyclerView.layoutManager = LinearLayoutManager(mContext)

        getTopicContentWiseAnswerListsAPICalling()


    }

    private fun getTopicContentWiseAnswerListsAPICalling() {

        try {
            progress_wheel.visibility = View.VISIBLE
            Log.d("deleteImei call","" + AppUtils.getCurrentDateTime())
            val repository = LMSRepoProvider.getTopicList()
            BaseActivity.compositeDisposable.add(
                repository.getTopicContentWiseAnswerLists(Pref.user_id!!, topicId , storeContentId)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({ result ->
                        val response = result as TopicContentWiseAnswerListsFetchResponse
                        if (response.status == NetworkConstant.SUCCESS) {
                            progress_wheel.visibility = View.GONE

                            try {
                                content_name.setText("Content name : "+response.content_name)

                                if (response.question_answer_fetch_list != null && response.question_answer_fetch_list.isNotEmpty()) {
                                    // Filter list to get only the items with isCorrectAnswer set to false (incorrect answers)
                                    val incorrectAnswers = response.question_answer_fetch_list.filter { !it.isCorrectAnswer }
                                    println("Incorrect Answers: $incorrectAnswers")

                                    // Filter list to get only the items with isCorrectAnswer set to true (correct answers)
                                    val correctAnswers = response.question_answer_fetch_list.filter { it.isCorrectAnswer }
                                    println("Correct Answers: $correctAnswers")
                                    if (correctAnswers.size>0) {
                                        ll_root_correct.visibility =View.VISIBLE
                                        iv_no_data_found_retry_.visibility =View.GONE
                                        adapter = RetryCorrectQuestionAnswerAdapter(
                                            correctAnswers,
                                            mContext
                                        )
                                        recyclerView.adapter = adapter
                                    }else{
                                        ll_root_correct.visibility =View.GONE
                                        iv_no_data_found_retry_.visibility =View.VISIBLE
                                    }

                                } else {
                                    progress_wheel.visibility = View.GONE
                                    (mContext as DashboardActivity).showSnackMessage(getString(R.string.no_data_found))
                                }
                            } catch (ex: Exception) {
                                ex.printStackTrace()
                            }
                        } else {
                            progress_wheel.visibility = View.GONE
                            (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))

                        }
                    }, { error ->
                        println("errortopicwiselist"+error.message)
                        progress_wheel.visibility = View.GONE
                        (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
                    })
            )
        } catch (ex: Exception) {
            ex.printStackTrace()
            progress_wheel.visibility = View.GONE
            (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
        }

    }


    override fun onClick(v: View?) {


    }

}