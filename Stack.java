public class Stack<T> {
    private int top = -1;
    private T[] data;

    public Stack(int size) {
        this.data = (T[]) new Object[size];
    }

    public void push(T data) {
        if (isFull()) {
            throw new StackOverflowError("Pilha cheia");
        }
        this.data[++top] = data;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }
        return this.data[top--];
    }

    public void clear() {
        top = -1;
    }

    public boolean isFull() {
        return top == this.data.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
