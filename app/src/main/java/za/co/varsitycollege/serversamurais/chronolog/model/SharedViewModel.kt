import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import za.co.varsitycollege.serversamurais.chronolog.Helpers.FirebaseHelper
import za.co.varsitycollege.serversamurais.chronolog.model.NotificationItem

class SharedViewModel : ViewModel() {
    val data: MutableLiveData<MutableList<NotificationItem>> = MutableLiveData(mutableListOf())
    val adapter = MutableLiveData<RecyclerAdapter>()

    init {
        loadData()
    }

    private fun loadData() {
        // This is just a placeholder. Replace this with your actual data loading logic.
        val items = mutableListOf(
            NotificationItem("Title 1", "Date 1"),
            NotificationItem("Title 2", "Date 2"),
            // Add more items...
        )
        data.value = items
    }

    fun setNotifications(notifications: List<NotificationItem>) {
        data.value = notifications.toMutableList()
        adapter.value?.notifyDataSetChanged()
    }

    fun clearAllNotifications() {
        data.value?.clear()
        adapter.value?.notifyDataSetChanged()
    }
}


