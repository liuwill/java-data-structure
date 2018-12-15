package com.liuwill.kata.promise;

public class Future<T> {
    private Caller<T> caller;
    private Ticket<T> ticket;

    public Future(Caller<T> caller) {
        this.caller = caller;
        this.ticket = new FutureTicket<T>();
    }

    Future<T> then(Action<T> action) {
        return new Future<T>((tick) -> {
            try {
                T callResult = this.caller.next(this.ticket);
                return tick.resolve(action.done(callResult));
            } catch (Exception exception) {
                tick.reject(exception);
                return null;
            }
        });
    }
}
