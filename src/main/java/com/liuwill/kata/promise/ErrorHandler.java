package com.liuwill.kata.promise;

public interface ErrorHandler<T> {

    void handler(Exception exception);

}
