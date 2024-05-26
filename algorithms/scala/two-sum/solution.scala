//> using scala "3.3.1"

package twoSum

import scala.util.boundary
import scala.util.boundary.break
import scala.collection.mutable.HashMap

/**
  * @tag Array; Hash Table
  ***************************************************************************
  * Given an array of integers, find two nums such that they add up to a
  * specific target number. The function twoSum should return indices of the
  * two nums such that they add up to the target, where the first must be
  * less than the second.
  *
  * You may assume that each input would have exactly one solution.
  * 
  * Input: nums = (2,7,11,15), target = 9
  * Output: (0,1)
  * Explanation: Because nums(0) + nums(1) == 9, we return (0,1)
  * 
  * Input: nums = (3,2,4), target = 6
  * Output: (1,2)
  * 
  * Input: nums = (3,3), target = 6
  * Output: (0,1)
  *
  * Follow-up: Can you come up with an algorithm that is less than O(n2) time
  * complexity?
  ***************************************************************************
  * { @link https://leetcode.com/problems/two-sum/ }
  */

object Solution {
  // Brute Force - O(n^2) time and O(1) space
  // Using nested loops to find the two nums
  def twoSumNestedLoops(nums: Array[Int], target: Int): Array[Int] = {
    boundary[Array[Int]] {
      for (i <- nums.indices) {
        for (j <- Range(i + 1, nums.size)) {
          if (nums(i) + nums(j) == target) break(Array(i, j))
        }
      }

      Array.empty
    }
  }

  // Hash Table - O(n) time and O(n) space
  // Iterate and get the remaining value using the current number and the target value,
  // if exist save it with the index
  def twoSumHashMap(nums: Array[Int], target: Int): Array[Int] = {
    val hashMap = new HashMap[Int, Int]()

    nums.zipWithIndex.find((number, index) =>
      hashMap.get(target - number) match
        case Some(_) => true
        case None    => hashMap.put(number, index); false
    ) match {
      case Some(number, index) => Array(hashMap(target - number), index)
      case None                => Array.empty
    }
  }
}
