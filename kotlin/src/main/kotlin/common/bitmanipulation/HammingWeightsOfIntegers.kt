package common.bitmanipulation

class HammingWeightsOfIntegers {

    fun solution(n :Int): List<Int> {
        return (1..n).map { countSetBit(it) }
    }

    fun solution2(n:Int): List<Int> {
        return (1..n).map { countSetBitOptimize(it) }
    }

    private fun countSetBit(n: Int): Int {
        var x = n
        var count = 0
        // Count each set bit of 'x' until 'x' equals 0.
        while (x != 0) {
            // Increment the count if the LSB is 1.
            count += x.and(1)
            // Right shift 'x' to shift the next bit to the LSB position.
            x = x.shr(1)
        }
        return count
    }

    private fun countSetBitOptimize(n: Int): Int {
        var x = n
        var count = 0
        // Count each set bit of 'x' until 'x' equals 0.
        while (x != 0) {
            // Instead of counting LSB by AND 1 - Subtract by 1 for flip bit intention
            // and count how many this operation perform (Brian Kernighan's Algorithm)
            // Example 1 - 16 - 10000 => 16 & 15 = 10000 & 01111 => x = 0
            x = x.and(x - 1)
            count++
        }
        return count
    }
}