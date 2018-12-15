package com.liuwill.kata.promise;

public class FutureTicket<T> implements Ticket<T> {
    public T resolve(T response) {
        return response;
    }

    public void reject(Exception exception) {

    }

}
