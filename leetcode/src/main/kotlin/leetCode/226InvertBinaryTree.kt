package leetCode

fun main() {


}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    fun print() {
        println(`val`)
        var current: TreeNode? = this
        while(current != null) {
            println(current.left?.`val`)
            println(current.right?.`val`)
            current = current.right ?: current.left
        }
    }
}

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class SolutionTreeNode {
    fun invertTree(root: TreeNode?): TreeNode? {
        val invertedNodes = mutableListOf<TreeNode?>()
        var currentNode = root
        if(root == null || (root.left == null && root.right == null)) return root

        while(currentNode != null) {
            var left = currentNode.left
            var right = currentNode.right
            print("left is ${currentNode.left} and value is ${currentNode.left?.`val`}\n")
            print("right is ${currentNode.right} and value is ${currentNode.right?.`val`}\\n")
            currentNode.left = right
            currentNode.right = left
            left = currentNode.left
            right = currentNode.right
            print("left is ${currentNode.left}\n")
            print("right is ${currentNode.right}\n")
            invertedNodes.addAll(listOf(left, right))
            //if(currentNode)
            if(left != null && right == null) {
                currentNode = left
            } else if (left == null && right != null) {
                currentNode = right
            } else if (left != null && right != null) {
                currentNode = left // ??
            } else if (left == null && right == null) {
                for(nodeIndex in invertedNodes.lastIndex downTo 0) {
                    val invertedNode = invertedNodes[nodeIndex]
                    if(invertedNode == null) {
                        continue
                    }
                    print("invertedNode is ${invertedNode?.`val`}")
                    if(
                        (invertedNodes.contains(invertedNode?.left) && invertedNodes.contains(invertedNode?.right)) ||
                        (invertedNode?.left == null && invertedNode?.right == null)
                    ) {
                        if(invertedNode == invertedNodes.first() || invertedNode == invertedNodes[1]) {
                            if(
                                invertedNodes.contains(invertedNodes.first()?.left) &&
                                invertedNodes.contains(invertedNodes.first()?.right) &&
                                invertedNodes.contains(invertedNodes[1]?.left) &&
                                invertedNodes.contains(invertedNodes[1]?.right)
                            ) {
                                return root
                            }
                        } else {
                            continue
                        }
                    } else {
                        currentNode = invertedNode
                        break
                    }
                }
            }
        }
        return currentNode
    }
}