package leetCode.graph

import leetCode.TreeNode

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class LowestCommonAncestorofaBinarySearchTree {
    var commonAncestor: TreeNode? = null
    var currentNode: TreeNode? = null
    val routes = mutableListOf<List<TreeNode>>()
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        findRoute(root, p)
        findRoute(root, q)
        val routeToP = routes.find { it.last() == p } ?: mutableListOf()
        val routeToQ = routes.find { it.last() == q } ?: mutableListOf()
        println(routeToP.last().`val`)
        println(routeToQ.last().`val`)
        val maxRoute = if(routeToP.size > routeToQ.size) routeToP else routeToQ
        for(i in maxRoute.lastIndex downTo 0) {
            val node = maxRoute[i]
            if(routeToP.contains(node) && routeToQ.contains(node)){
                commonAncestor = node
                break
            }
        }
        return commonAncestor
    }

    fun findRoute(currentNode: TreeNode?, endNode: TreeNode?, currentRoute: List<TreeNode>? = null): List<TreeNode> {
        val route = currentRoute?.toMutableList() ?: mutableListOf()
        if(currentNode != null && !route.contains(endNode)) {
            route.add(currentNode)
            if(currentNode != endNode) {
                findRoute(currentNode?.left, endNode, route)
                findRoute(currentNode?.right, endNode, route)
            }
        }
        routes.add(route.toList())
        return route.toList()
    }
}
