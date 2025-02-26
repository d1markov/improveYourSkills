package leetCode.seventy5

fun main() {
    val list1 = ListNode(2)
    list1.next = ListNode(4)
    list1.next?.next = ListNode(5)
    list1.next?.next?.next = ListNode(19)
    //insertNumber(1, list1)
    mergeTwoLists(list1, list1)
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var merged: ListNode? = list2
    if(list1 != null && list2 != null) {
        var currentNode = list1
        while(currentNode!=null) {
            val number = currentNode.`val`
            merged = insertNumber(number, merged)
            currentNode=currentNode?.next
        }
    } else {
        merged =  list1 ?: list2
    }
    return merged
}

fun insertNumber(insertNumber: Int, list: ListNode?): ListNode? {
    var currentNode = list
    var merged: ListNode? = null
    var head: ListNode? = null
    while (currentNode != null) {
        val currentNumber = currentNode.`val`
        val nextNumber = currentNode.next?.`val`
        val nextNode = currentNode.next
        if (insertNumber <= currentNumber) {
            merged = ListNode(insertNumber)
            merged.next = list
            if (head == null) head = merged
            break
        } else if (nextNumber != null && insertNumber <= nextNumber) {
            merged = currentNode
            merged.next = ListNode(insertNumber)
            merged.next?.next = nextNode
            if (head == null) head = merged
            break
        } else if(nextNumber!=null && insertNumber > nextNumber ) {
            if (head == null) head = currentNode
            currentNode = currentNode.next
        } else if (nextNumber == null) {
            currentNode.next = ListNode(insertNumber)
            break
        }
    }
    return head
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
    fun print() {
        println(this.`val`)
        var current = next
        while (current != null) {
            println(current.`val`)
            current = current.next
        }
    }
}


fun mergeTwoLists2(list1: ListNode?, list2: ListNode?): ListNode? {
    var headOfMerged: ListNode? = null
    var currentMerged: ListNode? = null
    var currentNode1: ListNode? = list1
    var currentNode2: ListNode? = list2
    do {
        if (currentNode1 != null && currentNode2 != null) {
            if (currentNode1.`val` >= currentNode2.`val`) {
                if (headOfMerged == null) {
                    headOfMerged = ListNode(currentNode2.`val`)
                    headOfMerged?.next = ListNode(currentNode1.`val`)
                    currentMerged = headOfMerged?.next
                } else {
                    currentMerged?.next = ListNode(currentNode2.`val`)
                    currentMerged?.next?.next = ListNode(currentNode1.`val`)
                    currentMerged = currentMerged?.next?.next
                }
            } else {
                if (headOfMerged == null) {
                    headOfMerged = ListNode(currentNode1.`val`)
                    headOfMerged.next = ListNode(currentNode2.`val`)
                    currentMerged = headOfMerged.next
                } else {
                    currentMerged?.next = ListNode(currentNode1.`val`)
                    currentMerged?.next?.next = ListNode(currentNode2.`val`)
                    currentMerged = currentMerged?.next?.next
                }
            }
            currentNode1 = currentNode1.next
            currentNode2 = currentNode2.next
        } else {
            headOfMerged = currentNode1 ?: currentNode2
        }
    } while (currentNode1 != null && currentNode2 != null)
    return headOfMerged
}
