package leetCode.linkedList

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */


// черепаха и заяц. Вариант предложенный ИИ
// 192 ms
class LinkedListCycle {
    //slow 3 2 0 -4
    //fast 3 0 2 -4
    // если нет цикла то fast и slow станут null
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head

        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) {
                return true
            }
        }

        return false
    }
}



/*
// 256 ms
class Solution {
    var previousNodes = mutableListOf<ListNode>()
    var isCycled = false
    fun hasCycle(head: ListNode?): Boolean {
        var currentNode: ListNode? = head
        while(!isCycled) {
            if(currentNode?.next != null) {
                if(previousNodes.contains(currentNode?.next)) {
                    isCycled = true
                } else {
                    previousNodes.add(currentNode)
                    currentNode = currentNode?.next
                }
            } else {
                return false
            }
        }
        return isCycled
    }
}
 */

/*
291 ms
class Solution {
    val previousNodes = mutableListOf<ListNode>()
    var isCycled = false
    fun hasCycle(head: ListNode?): Boolean {
        if(head?.next != null) {
            if(previousNodes.contains(head?.next)){
                return true
            } else {
                previousNodes.add(head)
                isCycled = hasCycle(head?.next)
            }
        }
        return isCycled
    }
}

 */


/*
имеем список просмотренных нод
идем по списку и провряем есть next в списке просмотренных
если есть возвращаем true
если нет добавляем в просмотренные и идем дальше
 */