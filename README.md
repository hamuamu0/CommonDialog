# CommonDialog
这是一个封装好了的通用dialog，利用builder模式编写。
可以自定义布局样式，设置title标题文字和message消息文字内容。
设置点击事件，自定义逻辑操作，方便快捷的操作各种逻辑，开箱即用。

### 使用方式

```
CommonDialog build;

//dialog弹窗
private void dialog(){
         build = new CommonDialog.Builder(this)
                .view(R.layout.dialog)//设置弹窗的样式layout
                .style(R.style.Dialog) //设置主题，这里可以将背景设为透明，这样只显示你需要显示的dialog部分
                .cancelTouchout(true) //设置点击dialog之外是否弹窗消失，true为消失，false为不消失
                .setTitle(R.id.txt_title, "这是一个弹窗标题")//根据id来设置标题的显示文字
                .setMessage(R.id.txt_message, "这是一个弹窗消息内容")//根据id来设置消息内容的显示文字
                .addViewOnclick(R.id.txt_sure, new View.OnClickListener() {//处理确认点击事件
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "点击了确定按钮", Toast.LENGTH_SHORT).show();
                        build.dismiss();
                    }
                })
                .addViewOnclick(R.id.txt_cancel, new View.OnClickListener() {//处理取消的点击事件
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();
                        build.dismiss();
                    }
                }).build();

                build.show();

    }
```

这里需要注意一点，由于我们在设置的时候必须设置一下背景为透明，不然会导致背景为白色，不能按照自己设置的样式加载弹窗的长宽。
