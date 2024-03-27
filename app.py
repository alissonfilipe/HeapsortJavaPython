from heap import Heap
from Heapsort import Heapsort

#implementação do Heapsort
array = [11, 16, 33, 8, 3, 9, 77, 14, 41]
heapsort = Heapsort(array)
print("Array original:")
heapsort.show()


heapsort.heapsort()
print("\nArray ordenado pelo Heapsort:")
heapsort.show()