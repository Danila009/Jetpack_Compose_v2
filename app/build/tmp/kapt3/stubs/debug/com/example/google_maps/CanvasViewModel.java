package com.example.google_maps;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/google_maps/CanvasViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_second", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "sec", "Landroidx/lifecycle/LiveData;", "getSec", "()Landroidx/lifecycle/LiveData;", "second", "timer", "Landroid/os/CountDownTimer;", "countDown", "", "totalSec", "", "app_debug"})
public final class CanvasViewModel extends androidx.lifecycle.ViewModel {
    private android.os.CountDownTimer timer;
    private int second = 30;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _second = null;
    
    public CanvasViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getSec() {
        return null;
    }
    
    public final void countDown(long totalSec) {
    }
}