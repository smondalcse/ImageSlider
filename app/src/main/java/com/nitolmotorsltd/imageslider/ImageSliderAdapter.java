package com.nitolmotorsltd.imageslider;

import android.util.Log;
import android.widget.Toast;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class ImageSliderAdapter implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener {

    HashMap<String, String> HashMapForURL ;
    HashMap<String, Integer> HashMapForLocalRes ;

    @Override
    public void onSliderClick(BaseSliderView slider) {

        //Toast.makeText(this,slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void AddImagesUrlOnline(){

        HashMapForURL = new HashMap<String, String>();

        HashMapForURL.put("CupCake", "http://androidblog.esy.es/images/cupcake-1.png");
        HashMapForURL.put("Donut", "http://androidblog.esy.es/images/donut-2.png");
        HashMapForURL.put("Eclair", "http://androidblog.esy.es/images/eclair-3.png");
        HashMapForURL.put("Froyo", "http://androidblog.esy.es/images/froyo-4.png");
        HashMapForURL.put("GingerBread", "http://androidblog.esy.es/images/gingerbread-5.png");
    }

    public void AddImageUrlFormLocalRes(){

        HashMapForLocalRes = new HashMap<String, Integer>();

        HashMapForLocalRes.put("CupCake", R.drawable.img1);
        HashMapForLocalRes.put("Donut", R.drawable.img2);
        HashMapForLocalRes.put("Eclair", R.drawable.img3);
        HashMapForLocalRes.put("Froyo", R.drawable.img4);


    }
}
