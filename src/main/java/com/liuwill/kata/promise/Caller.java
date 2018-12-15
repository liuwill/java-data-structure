package com.liuwill.kata.promise;

public interface Caller<T> {

    T next(Ticket<T> tick);

}
