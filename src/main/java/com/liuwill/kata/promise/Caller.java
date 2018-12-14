package com.liuwill.kata.promise;

public interface Caller<T> {

    T resolve(T response);

    T reject(Exception exception);
}
