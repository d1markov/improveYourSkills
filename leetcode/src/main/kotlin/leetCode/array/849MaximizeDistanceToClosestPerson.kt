package leetCode.array

fun main() {
    println(1f%2f)
}

class Solution {
    fun maxDistToClosest(seats: IntArray): Int {
        var lastAvailableIndex = 0
        var lastOccupiedIndex: Int? = null
        var nextOccupiedIndex = 0
        var maximumDistance = 0
        var availableCount = 0
        var maximumDistanceToClosestPerson = 0

        for(seatIndex in seats.indices) {

            if(seats[seatIndex] == 1 ) {
                lastOccupiedIndex = seatIndex
                nextOccupiedIndex = 0
                maximumDistanceToClosestPerson = 0
                availableCount = 0
                for(seatIndex2 in (seatIndex + 1)..seats.lastIndex) {
                    if(seats[seatIndex2] == 1) {
                        nextOccupiedIndex = seatIndex2
                        break
                    }
                }

                val distanceBetween = nextOccupiedIndex - lastOccupiedIndex
                if(distanceBetween>1) {
                    maximumDistanceToClosestPerson = distanceBetween / 2
                }
                if(nextOccupiedIndex == 0 && lastOccupiedIndex >= 0 ) {
                    maximumDistanceToClosestPerson = seats.lastIndex - lastOccupiedIndex
                }
            } else {
                if(lastOccupiedIndex == null) {
                    availableCount ++
                }
            }
            maximumDistance = if(maximumDistanceToClosestPerson > maximumDistance) maximumDistanceToClosestPerson else maximumDistance
            maximumDistance = if (availableCount > maximumDistance) availableCount else maximumDistance
        }
        return maximumDistance
    }
}

// [1,0,0,0,0,1]
// if place = 0 currentPlace=i
// lastAvailablePlaceIndex=0
// maximumDistance = 0
//

// loop1 goes throught Array
// loop2 fings place that not available