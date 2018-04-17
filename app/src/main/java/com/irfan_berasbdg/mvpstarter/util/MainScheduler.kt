package com.irfan_berasbdg.mvpstarter.util

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by isfaaghyth on 11/8/17.
 * github: @isfaaghyth
 */
class MainScheduler<T>: SchedulerTransformer<T>(Schedulers.io(), AndroidSchedulers.mainThread())