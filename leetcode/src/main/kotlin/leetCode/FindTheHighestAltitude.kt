package leetCode

import kotlin.math.max

fun main() {
    largestAltitude(intArrayOf(-5, 1, 5, 0, -7))
}

fun largestAltitude(gain: IntArray): Int {
    var currentAltitude = 0
    // Highest altitude currently is 0.
    var highestPoint = currentAltitude

    for (altitudeGain in gain) {
        // Adding the gain in altitude to the current altitude.
        currentAltitude += altitudeGain
        // Update the highest altitude.
        highestPoint = max(highestPoint.toDouble(), currentAltitude.toDouble()).toInt()
    }

    return highestPoint
}