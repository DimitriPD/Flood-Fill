public class StaticQueue {
    private int top = -1;
    private int base = 0;
    private int[] data;


    StaticQueue(int size){
        this.data = new int[size];
    }

    public void add(int date){
        if (isFull()) {
            throw new StackOverflowError("Fila cheia");
        }
        this.data[++top] = date;
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        int removedElement = this.data[base];


        for (int i = 0; i < top; i++) {
            this.data[i] = this.data[i + 1];
        }

        top--;
        return removedElement;
    }

    public void clear(){
        top = -1;
        base = 0;
    }

    public boolean isFull(){
        return top == this.data.length - 1;
    }

    public boolean isEmpty(){
        return top < base;
    }

}