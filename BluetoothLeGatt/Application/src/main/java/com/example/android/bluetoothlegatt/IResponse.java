package com.example.android.bluetoothlegatt;

public interface IResponse<T> {
    void success(T data);
    void fail();
}
