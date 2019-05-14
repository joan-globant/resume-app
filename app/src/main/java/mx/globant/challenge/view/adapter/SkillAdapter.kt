package mx.globant.challenge.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.item_skill.view.*
import mx.globant.challenge.R
import mx.globant.domain.model.Skill


class SkillAdapter(
    private val items: List<Skill>, private val context: Context?
): RecyclerView.Adapter<SkillViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        return SkillViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_skill, parent, false
            )
        )
    }

    override fun getItemCount(): Int =
        items.size

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        val skill = items[position]

        holder.skillText.text = skill.name
        holder.percentageText.text = context?.getString(R.string.skill_percentage_text, skill.percentage)
        holder.knowledgePercentageBar.progress = skill.percentage.toInt()
    }
}

class SkillViewHolder(view: View): ViewHolder(view) {
    val skillText: TextView = view.skillText
    val percentageText: TextView = view.percentageText
    val knowledgePercentageBar: ProgressBar = view.knowledgePercentageBar
}