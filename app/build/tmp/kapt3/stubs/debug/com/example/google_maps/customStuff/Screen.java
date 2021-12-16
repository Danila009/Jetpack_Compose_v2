package com.example.google_maps.customStuff;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\r\u000e\u000f\u0010\u0011B\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u0082\u0001\u0004\u0012\u0013\u0014\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/example/google_maps/customStuff/Screen;", "", "id", "", "title", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;)V", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getId", "()Ljava/lang/String;", "getTitle", "Home", "Items", "Profile", "Search", "Settings", "Lcom/example/google_maps/customStuff/Screen$Home;", "Lcom/example/google_maps/customStuff/Screen$Search;", "Lcom/example/google_maps/customStuff/Screen$Profile;", "Lcom/example/google_maps/customStuff/Screen$Settings;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.ui.graphics.vector.ImageVector icon = null;
    
    private Screen(java.lang.String id, java.lang.String title, androidx.compose.ui.graphics.vector.ImageVector icon) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.ui.graphics.vector.ImageVector getIcon() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/google_maps/customStuff/Screen$Home;", "Lcom/example/google_maps/customStuff/Screen;", "()V", "app_debug"})
    public static final class Home extends com.example.google_maps.customStuff.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.google_maps.customStuff.Screen.Home INSTANCE = null;
        
        private Home() {
            super(null, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/google_maps/customStuff/Screen$Search;", "Lcom/example/google_maps/customStuff/Screen;", "()V", "app_debug"})
    public static final class Search extends com.example.google_maps.customStuff.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.google_maps.customStuff.Screen.Search INSTANCE = null;
        
        private Search() {
            super(null, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/google_maps/customStuff/Screen$Profile;", "Lcom/example/google_maps/customStuff/Screen;", "()V", "app_debug"})
    public static final class Profile extends com.example.google_maps.customStuff.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.google_maps.customStuff.Screen.Profile INSTANCE = null;
        
        private Profile() {
            super(null, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/google_maps/customStuff/Screen$Settings;", "Lcom/example/google_maps/customStuff/Screen;", "()V", "app_debug"})
    public static final class Settings extends com.example.google_maps.customStuff.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.google_maps.customStuff.Screen.Settings INSTANCE = null;
        
        private Settings() {
            super(null, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/google_maps/customStuff/Screen$Items;", "", "()V", "list", "", "Lcom/example/google_maps/customStuff/Screen;", "getList", "()Ljava/util/List;", "app_debug"})
    public static final class Items {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.google_maps.customStuff.Screen.Items INSTANCE = null;
        @org.jetbrains.annotations.NotNull()
        private static final java.util.List<com.example.google_maps.customStuff.Screen> list = null;
        
        private Items() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.example.google_maps.customStuff.Screen> getList() {
            return null;
        }
    }
}