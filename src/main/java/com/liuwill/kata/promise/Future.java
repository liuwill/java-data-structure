package com.liuwill.kata.promise;

public class Future<T> {
    private Caller<T> caller;

    public Future(Caller<T> caller) {
        this.caller = caller;
    }

    Future<T> then(Caller<T> caller) {
        return null;
    }
}
