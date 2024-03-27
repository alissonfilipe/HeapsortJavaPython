class Heap:
    def __init__(self, heap):
        self.heap = heap
        self.tail = len(self.heap) - 1
        self.buildHeap()

    def isEmpty(self):
        return self.tail == -1

    def left(self, index):
        return 2 * index + 1

    def right(self, index):
        return 2 * (index + 1)

    def parent(self, index):
        return (index - 1) // 2

    def add(self, n):
        if self.tail >= len(self.heap) - 1:
            raise RuntimeError("Cheia")

        self.tail += 1
        self.heap[self.tail] = n

        i = self.tail
        while i > 0 and self.heap[self.parent(i)] > self.heap[i]:
            self.swap(i, self.parent(i))
            i = self.parent(i)

    def remove(self):
        if self.isEmpty():
            raise RuntimeError("Vazia")

        element = self.heap[0]
        self.heap[0] = self.heap[self.tail]
        self.tail -= 1
        self.heapify(0)
        return element

    def heapify(self, index):
        if self.isLeaf(index) or not self.isValidIndex(index):
            return

        index_min = self.min_index(index, self.left(index), self.right(index))

        if index_min != index:
            self.swap(index, index_min)
            self.heapify(index_min)

    def min_index(self, index, left, right):
        if self.heap[index] < self.heap[left]:
            if self.isValidIndex(right):
                if self.heap[index] > self.heap[right]:
                    return right
            return index
        else:
            if self.isValidIndex(right):
                if self.heap[left] > self.heap[right]:
                    return right
            return left

    def isValidIndex(self, index):
        return index >= 0 and index <= self.tail

    def isLeaf(self, index):
        return index >= self.parent(self.tail) and index <= self.tail

    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    def buildHeap(self):
        for i in range(self.parent(self.tail), -1, -1):
            self.heapify(i)
