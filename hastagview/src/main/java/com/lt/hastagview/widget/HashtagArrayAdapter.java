package com.lt.hastagview.widget;

import static com.lt.hastagview.widget.UtilsExtKt.setTextHashTagsPostsCount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;

import com.lt.hastagview.R;


/**
 * Default adapter for displaying hashtag in {@link SocialAutoCompleteTextView}.
 * Note that this adapter is completely optional, any adapter extending
 * {@link android.widget.ArrayAdapter} can be attached to {@link SocialAutoCompleteTextView}.
 */
public class HashtagArrayAdapter<T extends HashtagAble> extends SocialArrayAdapter<T> {
    private final int countPluralRes;

    public HashtagArrayAdapter(@NonNull Context context) {
        this(context, R.plurals.posts);
    }

    public HashtagArrayAdapter(@NonNull Context context, @PluralsRes int countPluralRes) {
        super(context, R.layout.socialview_layout_hashtag, R.id.tvHashtag);
        this.countPluralRes = countPluralRes;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.socialview_layout_hashtag, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final T item = getItem(position);
        if (item != null) {
            holder.hashtagView.setText(item.getId());
            final int count = item.getCount();
            setTextHashTagsPostsCount(holder.countView, count);
        }
        return convertView;
    }

    private static class ViewHolder {
        private final TextView hashtagView;
        private final TextView countView;

        ViewHolder(View itemView) {
            hashtagView = itemView.findViewById(R.id.tvHashtag);
            countView = itemView.findViewById(R.id.postsCount);
        }
    }

}
