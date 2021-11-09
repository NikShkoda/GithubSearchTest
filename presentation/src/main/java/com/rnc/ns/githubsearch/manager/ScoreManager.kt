package com.rnc.ns.githubsearch.manager

import kotlin.properties.Delegates

/**
 * Simple class to get rating for [com.rnc.ns.domain.model.github.GithubRepoModelItem]
 */
object ScoreManager {
    private const val MAX_RATING = 5.0F
    private const val MIN_RATING = 0.5F

    private var maxScore: Int by Delegates.vetoable(0) { _, oldValue, newValue ->
        newValue > oldValue || newValue == 0
    }

    /**
     * Sets the new [maxScore] for the manager to use in [getRating] method
     * @param newMaxScore - new [maxScore] which would be used if bigger than existing
     */
    fun updateMaxScore(newMaxScore: Int) {
        maxScore = newMaxScore
    }

    /**
     * Resets [maxScore] for the new query of [com.rnc.ns.domain.model.github.GithubRepoModelItem]
     */
    fun resetMaxScore() {
        maxScore = 0
    }

    /**
     * Calculates rating of the [com.rnc.ns.domain.model.github.GithubRepoModelItem] avoiding
     * any potentials overflows or incorrect values for [android.widget.RatingBar]
     *
     * @param score - score of the [com.rnc.ns.domain.model.github.GithubRepoModelItem]
     * @return rating of the [com.rnc.ns.domain.model.github.GithubRepoModelItem]
     */
    fun getRating(score: Int): Float {
        return if(maxScore == 0) {
            0.0f
        } else {
            val result = (score.toFloat() / maxScore) * MAX_RATING
            if(result > MAX_RATING) MAX_RATING else if(result < MIN_RATING) MIN_RATING else result
        }
    }
}