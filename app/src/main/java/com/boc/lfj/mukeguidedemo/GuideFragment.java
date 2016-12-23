package com.boc.lfj.mukeguidedemo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



public class GuideFragment extends Fragment {
    private static String TAG = GuideFragment.class.getSimpleName();
    private static String KEY = "index";
    
    private CustomWidthVideoView mVideoView;
    private ImageView mImageView;

   private int index;

    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View guideView = inflater.inflate(R.layout.fragment_guide,container,false);
        mImageView = (ImageView) guideView.findViewById(R.id.imageview);
        mVideoView = (CustomWidthVideoView) guideView.findViewById(R.id.videoview);
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        mVideoView.setWidthHeight(metrics.widthPixels,metrics.heightPixels);
        Uri uri1 = Uri.parse("android.resource://"+getActivity().getPackageName() + "/" + R.raw.guide01);
        Uri uri2 = Uri.parse("android.resource://"+getActivity().getPackageName() + "/" + R.raw.guide01);
        Uri uri3 = Uri.parse("android.resource://"+getActivity().getPackageName() + "/" + R.raw.guide01);
        
        switch (index){
            case 0:
                mImageView.setImageResource(R.mipmap.bg_page_01);
                mVideoView.setVideoURI(uri1);
                break;
            case 1:
                mImageView.setImageResource(R.mipmap.bg_page_02);
                mVideoView.setVideoURI(uri2);
                break;
            case 2:
                mImageView.setImageResource(R.mipmap.bg_page_03);
                mVideoView.setVideoURI(uri3);
                break;
        }
        Log.d(TAG,"onCreateView");
        mVideoView.start();
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mVideoView.start();
            }
        });
        return guideView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        index = bundle.getInt(KEY);
        Log.d(TAG,"oncreate"+index);
    }
    
    public static GuideFragment newInstance(int index) {
        Bundle args = new Bundle();
        args.putInt(KEY,index);

        GuideFragment fragment = new GuideFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
