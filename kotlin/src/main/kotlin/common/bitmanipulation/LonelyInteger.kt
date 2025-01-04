package common.bitmanipulation

class LonelyInteger {

    fun solution(nums: List<Int>): Int {
        var res = 0
        // XOR each element of the array so that duplicate values will
        // cancel each other out (x ^ x == 0).
        for (n in nums) {
            res = res.xor(n)
        }
        // 'res' will store the lonely integer because it would not have
        // been canceled out by any duplicate.
        return res
    }
}