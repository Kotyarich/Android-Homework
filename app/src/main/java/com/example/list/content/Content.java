package com.example.list.content;

import com.example.list.R;

import java.util.ArrayList;
import java.util.List;

public class Content {

    public static final List<ListItem> ITEMS = new ArrayList<>();
    public static final int START_COUNT = 100;

    static {
        for (int i = 1; i <= START_COUNT; i++) {
            addItem(createListItem(i));
        }
    }

    public static void addItem(ListItem item) {
        ITEMS.add(item);
    }

    public static ListItem createListItem(int position) {
        int color = position % 2 == 0 ? R.color.colorEven : R.color.colorOdd;
        return new ListItem(Integer.toString(position), color);
    }

    public static int getSize() {
        return ITEMS.size();
    }

    public static class ListItem {
        public final String content;
        public final int mColor;

        public ListItem(String content, int color) {
            this.content = content;
            this.mColor = color;
        }
    }
}
