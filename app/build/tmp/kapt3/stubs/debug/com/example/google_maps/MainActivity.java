package com.example.google_maps;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0012H\u0007JA\u0010\u0017\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\u0006\u0010\u0019\u001a\u00020\u001a2!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00120\u001cH\u0007J=\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00142!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00120\u001c2\b\b\u0002\u0010#\u001a\u00020$H\u0003J\b\u0010%\u001a\u00020\tH\u0003J\b\u0010&\u001a\u00020\u0006H\u0002J\b\u0010\'\u001a\u00020\u0012H\u0003J\u0012\u0010(\u001a\u00020\u00122\b\u0010)\u001a\u0004\u0018\u00010*H\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r\u00a8\u0006+"}, d2 = {"Lcom/example/google_maps/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "authenticationCallback", "Landroid/hardware/biometrics/BiometricPrompt$AuthenticationCallback;", "cancellationSignal", "Landroid/os/CancellationSignal;", "ch", "Landroidx/compose/runtime/MutableState;", "", "getCh", "()Landroidx/compose/runtime/MutableState;", "setCh", "(Landroidx/compose/runtime/MutableState;)V", "chAlert", "getChAlert", "setChAlert", "ComposeButton", "", "text", "", "intent", "Landroid/content/Intent;", "CustomKeyboard", "input", "scrollState", "Landroidx/compose/foundation/ScrollState;", "onClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "digit", "NumberButton", "number", "modifier", "Landroidx/compose/ui/Modifier;", "checkBiometricSupport", "getCancellationSignal", "launchBiometric", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
@androidx.compose.animation.ExperimentalAnimationApi()
public final class MainActivity extends androidx.activity.ComponentActivity {
    private android.os.CancellationSignal cancellationSignal;
    @org.jetbrains.annotations.Nullable()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> ch;
    @org.jetbrains.annotations.Nullable()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> chAlert;
    private final android.hardware.biometrics.BiometricPrompt.AuthenticationCallback authenticationCallback = null;
    private java.util.HashMap _$_findViewCache;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> getCh() {
        return null;
    }
    
    public final void setCh(@org.jetbrains.annotations.Nullable()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> getChAlert() {
        return null;
    }
    
    public final void setChAlert(@org.jetbrains.annotations.Nullable()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.Q)
    @java.lang.Override()
    @androidx.compose.material.ExperimentalMaterialApi()
    @androidx.compose.foundation.ExperimentalFoundationApi()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    private final boolean checkBiometricSupport() {
        return false;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.Q)
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void launchBiometric() {
    }
    
    private final android.os.CancellationSignal getCancellationSignal() {
        return null;
    }
    
    @androidx.compose.runtime.Composable()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.Q)
    public final void CustomKeyboard() {
    }
    
    @androidx.compose.runtime.Composable()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.Q)
    @android.annotation.SuppressLint(value = {"NewApi"})
    public final void CustomKeyboard(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.String> input, @org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.ScrollState scrollState, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Character, kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private final void NumberButton(java.lang.String number, kotlin.jvm.functions.Function1<? super java.lang.Character, kotlin.Unit> onClick, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public final void ComposeButton(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
}