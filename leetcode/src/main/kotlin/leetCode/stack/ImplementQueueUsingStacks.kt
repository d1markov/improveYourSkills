package leetCode.stack

//232. Implement Queue using Stacks

class ImplementQueueUsingStacks {

    var queue = mutableListOf<Int>()

    fun push(x: Int) {
        queue.add(x)
    }

    fun pop(): Int {
        val newQueue = mutableListOf<Int>()
        val firstElement = queue.first()
        for(index in 1..queue.lastIndex) { // если ненужен последний использую until
            newQueue.add(queue[index])
        }
        queue = newQueue
        return firstElement
    }

    fun peek(): Int =  queue.first()

    fun empty() =  queue.size == 0

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */

/*
стэк и очередь
стэк - первым пришел, последним ушел т е элементы кладутся сверху и смещают остальные вниз
фифо или ПППУ - первым пришел первым ушел. Классический стэк но наоборот то есть кладем элементы снизу
peek (заглунуть) - возвращает элемент из начала очереди
empty - проверяет очередь на пустоту

Алгоритм
- - push (поставить) - кладет элемент в конец очереди
Берем изменяемый список интов и просто добавляем в него элементы

- - pop (извлечь) - удаляет элемент из начала очереди и возвращает его
можно сделать через котлиновский ремув
или ЛУЧШЕ ( т к подойдет для любого языка ) написать свою функцию которая берет первый эелемент и создает новую коллекцию начиная соследующего в итоге возращает удаленный из очереди элемент

- - peek (заглунуть) - возвращает элемент из начала очереди
просто выдать первый элемент ( проверить на пустоту )

- - empty - проверяет очередь на пустоту
использовать котлиновский isEmpty или сравнить размеры с 0





*/