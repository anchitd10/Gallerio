package com.example.gallerio

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ImageAdapter(private var context: Context,private var imagesList:ArrayList<Image>):RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {


    class ImageViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var image: ImageView?=null

        init{
            image=itemView?.findViewById(R.id.row_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.row_custom_recycler_item,parent,false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currentImage=imagesList[position]
        Glide.with(context)
            .load(currentImage.imagePath)
            .apply(RequestOptions().centerCrop())
            .into(holder.image!!)

        holder.image?.setOnClickListener{
            val intent= Intent(context,ImageFullActivity::class.java)
            intent.putExtra("path",currentImage.imagePath)
            intent.putExtra("name",currentImage.imageName)
            context.startActivity(intent)
        }


    }
}