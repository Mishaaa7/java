package com.example.labw9;


        import android.appwidget.AppWidgetManager;
        import android.appwidget.AppWidgetProvider;
        import android.content.Context;
        import android.widget.RemoteViews;

public class MainActivity extends AppWidgetProvider {

    private Context context;
    private AppWidgetManager appWidgetManager;
    private int[] appWidgetIds;

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        // здесь ваш текст
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {
        this.context = context;
        this.appWidgetManager = appWidgetManager;
        this.appWidgetIds = appWidgetIds;
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.activity_main);
        views.setTextViewText(R.id.tv, "Мой первый виджет!");
        appWidgetManager.updateAppWidget(appWidgetIds, views);

    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        // здесь ваш текст
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        // здесь ваш текст
    }

}

