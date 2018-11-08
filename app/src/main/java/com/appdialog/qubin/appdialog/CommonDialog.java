package com.appdialog.qubin.appdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class CommonDialog extends Dialog {


    private Context context;
    private int height, width;
    private boolean cancelTouchout;
    private View view;

    private CommonDialog(Builder builder) {
        super(builder.context);
        context = builder.context;
        height = builder.height;
        width = builder.width;
        cancelTouchout = builder.cancelTouchout;
        view = builder.view;
    }


    private CommonDialog(Builder builder, int resStyle) {
        super(builder.context, resStyle);
        context = builder.context;
        height = builder.height;
        width = builder.width;
        cancelTouchout = builder.cancelTouchout;
        view = builder.view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(view);

        setCanceledOnTouchOutside(cancelTouchout);

        setCancelable(cancelTouchout);
    }

    public static final class Builder {

        private Context context;
        private int height, width;
        private boolean cancelTouchout;
        private View view;
        private int resStyle = -1;


        public Builder(Context context) {
            this.context = context;
        }

        public Builder view(int resView) {
            view = LayoutInflater.from(context).inflate(resView, null);
            return this;
        }


        public Builder style(int resStyle) {
            this.resStyle = resStyle;
            return this;
        }

        public Builder cancelTouchout(boolean val) {
            cancelTouchout = val;
            return this;
        }

        public Builder addViewOnclick(int viewRes,View.OnClickListener listener){
            view.findViewById(viewRes).setOnClickListener(listener);
            return this;
        }

        public Builder setTitle(int viewRes,String title){
            TextView txtTitle = (TextView) view.findViewById(viewRes);
            txtTitle.setText(title);
            return this;
        }

        public Builder setMessage(int viewRes,String message){
            TextView txtMessage = (TextView)view.findViewById(viewRes);
            txtMessage.setText(message);
            return this;
        }



        public CommonDialog build() {
            if (resStyle != -1) {
                return new CommonDialog(this, resStyle);
            } else {
                return new CommonDialog(this);
            }
        }
    }
}

