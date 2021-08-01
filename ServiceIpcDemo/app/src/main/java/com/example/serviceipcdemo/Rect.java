package com.example.serviceipcdemo;

import android.os.Parcel;
import android.os.Parcelable;

public class Rect implements Parcelable {
    public int top;
    public int bottom;
    public int left;
    public int right;

    public Rect() {

    }

    private Rect(Parcel in) {
        // 读取Parcel里面的数据。这个是按照顺序来的
        readFromParcel(in);
    }

    public static final Creator<Rect> CREATOR = new Creator<Rect>() {
        @Override
        public Rect createFromParcel(Parcel in) {
            return new Rect(in);
        }

        @Override
        public Rect[] newArray(int size) {
            return new Rect[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        // 这两个的顺序一定要对，一定要是对的。因为序列化之后，就是一堆的二进制，拿到手之后其实你也不知道是个啥东西。
        parcel.writeInt(top);
        parcel.writeInt(bottom);
        parcel.writeInt(left);
        parcel.writeInt(right);
    }

    private void readFromParcel(Parcel in) {
        // 这两个的顺序一定要对，一定要是对的。因为序列化之后，就是一堆的二进制，拿到手之后其实你也不知道是个啥东西。
        top = in.readInt();
        bottom = in.readInt();
        left = in.readInt();
        right = in.readByte();
    }
}
