package com.example.healthhub.presentation.workout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.api.load
import com.example.healthhub.data.Workout
import com.example.healthhub.databinding.ItemWorkoutBinding
import com.example.healthhub.util.extension.ItemDiffCallback

class WorkoutAdapter : ListAdapter<Workout, WorkoutAdapter.WorkoutViewHolder>(
    ItemDiffCallback<Workout>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old == new })
) {
    class WorkoutViewHolder(private val binding: ItemWorkoutBinding) : ViewHolder(binding.root) {
        fun onBind(data: Workout) {
            binding.ivWorkout.load(data.image)
            binding.tvWorkoutText.text = data.workout
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val binding = ItemWorkoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WorkoutViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}