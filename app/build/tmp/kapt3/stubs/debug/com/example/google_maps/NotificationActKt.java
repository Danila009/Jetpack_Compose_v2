package com.example.google_maps;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a@\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004\u001a8\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\b\u001a@\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b\u001a8\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\b\u001a:\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\bH\u0007\u00a8\u0006\u0014"}, d2 = {"NotificationExpand", "", "bigPictureWithThumbnailNotification", "context", "Landroid/content/Context;", "channelId", "", "notificationId", "", "textTitle", "textContent", "bigImage", "Landroid/graphics/Bitmap;", "priority", "createNotificationChannel", "largeTextNotification", "largeTextWithBigIconNotification", "largeIcon", "simpleNotification", "simpleNotificationWithTapAction", "app_debug"})
public final class NotificationActKt {
    
    @androidx.compose.runtime.Composable()
    @androidx.compose.animation.ExperimentalAnimationApi()
    public static final void NotificationExpand() {
    }
    
    public static final void simpleNotification(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String channelId, int notificationId, @org.jetbrains.annotations.NotNull()
    java.lang.String textTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String textContent, int priority) {
    }
    
    @androidx.compose.animation.ExperimentalAnimationApi()
    public static final void simpleNotificationWithTapAction(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String channelId, int notificationId, @org.jetbrains.annotations.NotNull()
    java.lang.String textTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String textContent, int priority) {
    }
    
    public static final void largeTextNotification(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String channelId, int notificationId, @org.jetbrains.annotations.NotNull()
    java.lang.String textTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String textContent, int priority) {
    }
    
    public static final void largeTextWithBigIconNotification(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String channelId, int notificationId, @org.jetbrains.annotations.NotNull()
    java.lang.String textTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String textContent, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap largeIcon, int priority) {
    }
    
    public static final void bigPictureWithThumbnailNotification(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String channelId, int notificationId, @org.jetbrains.annotations.NotNull()
    java.lang.String textTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String textContent, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bigImage, int priority) {
    }
    
    public static final void createNotificationChannel(@org.jetbrains.annotations.NotNull()
    java.lang.String channelId, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
}