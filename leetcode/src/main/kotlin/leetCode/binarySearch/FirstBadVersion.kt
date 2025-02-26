package leetCode.binarySearch

/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

// ии вариант 257 мс
class FirstBadVersion : VersionControl(firstBadVersion = 4) {
    var first = 0
    override fun firstBadVersion(n: Int): Int {
        var left = 1
        var right = n

        while (left < right) {
            val mid = left + (right - left) / 2

            if (isBadVersion(mid)) {
                right = mid  // the first bad version is at mid or to the left
            } else {
                left = mid + 1  // the first bad version is to the right
            }
        }

        // When the loop ends, left is the first bad version
        return left
    }
}

abstract class VersionControl(private val firstBadVersion: Int) {

    fun isBadVersion(version: Int) = version >= firstBadVersion

    abstract fun firstBadVersion(n: Int): Int
}

/*
рекурсия 371
class Solution: VersionControl() {
    var first = 0
    override fun firstBadVersion(n: Int) : Int {
        return fbv(1, n)
    }

    private fun fbv(min: Int, max: Int): Int {
        if(isBadVersion(min)) {
                return min
            }
            if( max - min <= 1 ) {
                    if(isBadVersion(max)) {
                    return max
                } else {
                    return min
                }
            }
        val center = min + ((max - min) / 2)
        if(isBadVersion(center)){
                first = fbv(min, center)
            } else {
                first = fbv(center +1, max)
            }
        return first
    }
}
*/

/*
385 ms
class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var first = 0
        var min = 0
        var max = n
        while(first == 0) {
            val center = min + ((max - min) / 2)
            if(isBadVersion(center)){
                max = center
            } else {
                min = center
            }
            if( max - min <= 1 ) {
                    if(isBadVersion(max)) {
                    first = max
                } else {
                    first = min
                }
            }
            if(isBadVersion(min)) {
                first = min
            }
        }
        return first
	}
}

 */