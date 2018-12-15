package com.liuwill.kata.promise;

public interface Caller<T> {

    void next(Ticket<T> tick);

}
