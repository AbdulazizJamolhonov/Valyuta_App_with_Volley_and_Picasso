package developer.abdulaziz.myvalyuta

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import developer.abdulaziz.myvalyuta.databinding.ItemRv2Binding

class MyAdapter2(
    private val context: Context,
    private val list: List<User2>
) :
    RecyclerView.Adapter<MyAdapter2.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemRv2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(user: User2, position: Int) {
            loadImage(binding.image, user.avatar_url, context)
//            Picasso.get().load(user.avatar_url).into(binding.image)
            binding.text.text = user.login
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemRv2Binding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(hol: ViewHolder, pos: Int) = hol.onBind(list[pos], pos)
    override fun getItemCount(): Int = list.size
}