#CircileImageView
CircleImageView is a circle image view (that's bullshit).

It's a lightweight widget and compatible with other image loading libraries, like ImageLoader & DummyPicLoader (Oh my beloved DPL).

##Usage
###Use it directly in a XML layout file.

    <sun.bob.circleimageview.CircleView
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:src="@drawable/test"
        android:id="@+id/id_circleview"
    />

###Use it in Java code and load image with DPL.
    DummyPicLoader.getInstance(this).loadImageFromUri("android.resource://sun.bob.circleimageviewtest/"+R.drawable.test,
            (ImageView)findViewById(R.id.id_circleview1));
    DummyPicLoader.getInstance(this).loadImageFromUrl("http://www.themoviethemesong.com/wp-content/uploads/2014/05/Futurama-1.png"
                                    ,(ImageView)findViewById(R.id.id_circleview2));


##Is it safe?
It's safe when using image loaders mentioned above.

It MAY cause an OOM if you specify a big image directly to it.