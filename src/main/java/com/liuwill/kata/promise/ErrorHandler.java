package com.liuwill.kata.promise;

public interface ErrorHandler<T> {

    void handle(Exception exception);

}
