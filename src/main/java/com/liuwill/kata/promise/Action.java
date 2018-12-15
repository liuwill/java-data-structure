package com.liuwill.kata.promise;

public interface Action<T> {

    T done(T source) throws Exception;

}
