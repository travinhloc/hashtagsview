package com.lt.hastagview.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lt.hastagview.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

/**
 * Default adapter for displaying mention in {@link SocialAutoCompleteTextView}.
 * Note that this adapter is completely optional, any adapter extending
 * {@link android.widget.ArrayAdapter} can be attached to {@link SocialAutoCompleteTextView}.
 */
public class MentionArrayAdapter<T extends MentionAble> extends SocialArrayAdapter<T> {
    private final int userAvatar;

    public MentionArrayAdapter(@NonNull Context context) {
        this(context, R.drawable.ic_placeholder_nuddg);
    }

    public MentionArrayAdapter(@NonNull Context context, @DrawableRes int defaultAvatar) {
        super(context, R.layout.socialview_layout_mention, R.id.tvUsername);
        this.userAvatar = defaultAvatar;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.socialview_layout_mention, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final T item = getItem(position);
        if (item != null) {
            holder.username.setText(item.getUserName());
            holder.fullName.setText(item.getDisplayName());
            final String avatar = item.getAvatar();
            final RequestCreator request;
            if (avatar == null || avatar.isEmpty()) {
                request = Picasso.get().load(userAvatar);
            } else {
                request = Picasso.get().load((String) avatar);
            }
            request.error(userAvatar).into(holder.avatarView);
        }
        return convertView;
    }

    private static class ViewHolder {
        private final ImageView avatarView;
        private final TextView username;
        private final TextView fullName;

        ViewHolder(View itemView) {
            avatarView = itemView.findViewById(R.id.ivAvatar);
            username = itemView.findViewById(R.id.tvUsername);
            fullName = itemView.findViewById(R.id.tvFullName);
        }
    }
}
