package com.example.google_maps;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007JP\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007JH\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007J(\u0010\u0014\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0007J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J(\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0015J(\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/example/google_maps/SqlRoomAct;", "Landroidx/activity/ComponentActivity;", "()V", "mUserViewModel", "Lcom/example/google_maps/data/UserViewModel;", "InsertFun", "", "navCon", "Landroidx/navigation/NavController;", "Lazy", "list", "Lcom/example/google_maps/data/User;", "id", "Landroidx/compose/runtime/MutableState;", "", "firstName", "", "lastName", "age", "ReadFun", "UpdateFun", "delete", "inputCheck", "", "insertDataToDatabase", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "updateItem", "app_debug"})
public final class SqlRoomAct extends androidx.activity.ComponentActivity {
    private com.example.google_maps.data.UserViewModel mUserViewModel;
    private java.util.HashMap _$_findViewCache;
    
    public SqlRoomAct() {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"CoroutineCreationDuringComposition"})
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.compose.runtime.Composable()
    public final void InsertFun(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navCon) {
    }
    
    @androidx.compose.runtime.Composable()
    @android.annotation.SuppressLint(value = {"CoroutineCreationDuringComposition"})
    public final void ReadFun(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navCon, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Integer> id, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.String> firstName, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.String> lastName, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Integer> age) {
    }
    
    @androidx.compose.runtime.Composable()
    public final void Lazy(@org.jetbrains.annotations.NotNull()
    com.example.google_maps.data.User list, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navCon, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Integer> id, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.String> firstName, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.String> lastName, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Integer> age) {
    }
    
    @androidx.compose.runtime.Composable()
    public final void UpdateFun(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Integer> id, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navCon, @org.jetbrains.annotations.Nullable()
    com.example.google_maps.data.User delete) {
    }
    
    private final void insertDataToDatabase(java.lang.String firstName, java.lang.String lastName, int age, android.content.Context context) {
    }
    
    private final void updateItem(java.lang.String firstName, java.lang.String lastName, int age, int id) {
    }
    
    private final boolean inputCheck(java.lang.String firstName, java.lang.String lastName, int age) {
        return false;
    }
}