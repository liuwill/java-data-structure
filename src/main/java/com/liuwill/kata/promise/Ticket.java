package com.liuwill.kata.promise;

public interface Ticket<T> {

    T resolve(T response);

    void reject(Exception exception);

}
