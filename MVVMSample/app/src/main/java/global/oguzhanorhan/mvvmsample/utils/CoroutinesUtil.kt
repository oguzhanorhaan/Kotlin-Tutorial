package global.oguzhanorhan.mvvmsample.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object CoroutinesUtil{
    fun main(work: suspend(() -> Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            work()
        }
}
