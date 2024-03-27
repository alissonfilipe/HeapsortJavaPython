
// cria a classe Heap
public class Heap {
    //heap é um array de inteiros
    private int[] heap;
    //tail é do tipo inteiro 
    private int tail;

    // Método construtor para 
    //receber um array preenchido
    // e transformá-lo em heap
    public Heap(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length -1;
        this.buildHeap(); 
    }

    // Método construtor para 
    //receber a capacidade do heap
    public Heap(int capacidade) {
        this.heap = new int[capacidade];
        this.tail = -1;
    }

    // verificando se o heap está vazio
    public boolean isEmpty() {
        return this.tail == -1;
    }
    // índice do filho a esquerda
    public int left(int index) {
        return 2 * index + 1;
        //se o index for 1 o retorno será 
        //3, que é o indice do filho a 
        //esquerda
    }
    // índice do filho a direita
    public int right(int index) {
        return 2 * (index + 1);
    }
    
    // índice do pai
    public int parent(int index) {
        return (index - 1) / 2;
    }

    public void add(int n) {
        if (tail >= (heap.length - 1)){
            throw new RuntimeException("Cheia");
        }

        // um novo elemento vai ser inserindo, então incremento em 1 o índice do último elemento
        tail += 1;
        // colocando o novo elemento na primeira posição vaga
        this.heap[tail] = n;

        int i = tail;
        // partindo do novo elemento, caparamos ele com o seu pai. Enquanto ele for maior que seu pai e não chegou na primeira posição...
        while (i > 0 && this.heap[parent(i)] < this.heap[i]) {
            // trocamos o novo nó com seu pai
            swap(i, parent(i));
            // atualizamos o índice do novo nó
            i = parent(i);
        }
    }

    public int remove() {
        if (this.isEmpty()) throw new RuntimeException("Vazia");
        // guaradamos o elemento do ínicio
        int element = this.heap[0];
        // colocamos último elemento no ínicio
        this.heap[0] = this.heap[tail];
        // descretemos o índice que controla a posição do último elemento
        this.tail -= 1;
        // restabelecemos o heap
        this.heapify(0);
        // retornamos o elemento extraído
        return element;
    }

    private void heapify(int index) {
        if (isLeaf(index) || !isValidIndex(index)) 
            return;
        
        // comparamos index, left e right para descobrir o maior
        int index_max = max_index(index, left(index), right(index));
        
        //se o índice atual (index) não for maior que seus filhos, troca e continua. 
        if (index_max != index) {
                swap(index, index_max);
                heapify(index_max);
        }
    }  

    private int max_index(int index, int left, int right) {
        // Verificando se o indice atual é maior que o filho da esquerda
        if (this.heap[index] > this.heap[left]) {
            // existe filho a direita
            if (isValidIndex(right)) {
                // o indice atual é menor que o filho da direita
                if (this.heap[index] < this.heap[right])
                    return right;
            }
            // o indice atual é o maior
            return index;
        
        } else {
            // verificando se existe filho a direita
            if (isValidIndex(right)) {
                // verificando se o filho da direita é maior que o filho da esquerda
                if (this.heap[left] < this.heap[right])
                    return right;
            } 
            // o filho a esquerda é o maior
            return left;
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;
    }
    
    private boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail;
    } 
    
    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    private void buildHeap() {
        // partindo do pai do último elemento
        for (int i = parent(this.tail); i >= 0; i--)
            heapify(i); 
    }
}