package leetCode.graph

import leetCode.binaryTree.TreeNode
import kotlin.math.absoluteValue


fun main() {



}

fun getDepthV2(root: TreeNode?, previousDepth: Int = 0): Int {
    var currentDepth = 0
    if(root != null) {
        currentDepth = previousDepth + 1
    }
    return currentDepth
}

//TODO собран из костылей на литкоде работает долго 211мс против 1 мс ( так работает у 42% решал )
class BalancedBinaryTree {
    var balanced = false
    //var depth = 0
    var leftDepth = 0
    var rightDepth = 0
    var state: Boolean = true
    val depths = mutableListOf<Int>()
    fun isBalanced(root: TreeNode?): Boolean {
        if(root != null && state == true) {
            //depth = 1
            leftDepth = getDepth(root?.left, 0).max() // 2
            depths.clear()
            rightDepth = getDepth(root?.right, 0).max() // 3
            depths.clear()
            println(state)
            println("______")
            if((leftDepth - rightDepth).absoluteValue > 1) {
                state = false
                println("state set to $state, because leftDepth=$leftDepth, rightDepth=$rightDepth, currentNode=${root.`val`}")
            }
            else {
                state=true
            }
            if(state == true) {
                isBalanced(root?.left)
                isBalanced(root?.right)
            } else {
                return state
            }
        }
        return state
    }

    fun getDepth(currentNode: TreeNode?, currentDepth: Int): List<Int> {
        var depth = 0
        depths.add(depth)
        if(currentNode != null) {
            depth = currentDepth + 1
            depths.add(depth)
            println("evaluate getDepth of ${currentNode.`val`}")
            getDepth(currentNode?.left, depth)
            getDepth(currentNode?.right, depth)
        }
        return depths
    }
}