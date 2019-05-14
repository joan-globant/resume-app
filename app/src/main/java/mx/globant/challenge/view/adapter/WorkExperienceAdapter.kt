package mx.globant.challenge.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_work.view.*
import mx.globant.challenge.R
import mx.globant.domain.model.WorkExperience


class WorkHistoryAdapter(
    private val items: List<WorkExperience>, private val context: Context?
): RecyclerView.Adapter<WorkHistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkHistoryViewHolder {
        return WorkHistoryViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_work, parent, false
            )
        )
    }

    override fun getItemCount(): Int =
        items.size

    override fun onBindViewHolder(holder: WorkHistoryViewHolder, position: Int) {
        val workExperience = items[position]

        holder.jobTitleText.text = workExperience.job
        holder.locationText.text = workExperience.location
        holder.periodText.text = workExperience.getPeriod()
        holder.companyText.text = workExperience.companyName
        holder.descriptionText.text = workExperience.description
    }
}

class WorkHistoryViewHolder(view: View): ViewHolder(view) {
    val jobTitleText: TextView = view.jobTitleText
    val companyText: TextView = view.companyText
    val locationText: TextView = view.locationText
    val periodText: TextView = view.periodText
    val descriptionText: TextView = view.descriptionText
}