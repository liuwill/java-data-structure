package com.liuwill.kata.promise;

public class FutureTicket<T> implements Ticket<T> {
    private Future future;
    private T data;

    public FutureTicket(Future future) {
        this.future = future;
    }

    public void resolve(T response) {
        this.data = response;
    }

    public void reject(Exception exception) {
        this.future.catchError(exception);
    }

    public T lastTicketData() {
        return this.data;
    }

}
