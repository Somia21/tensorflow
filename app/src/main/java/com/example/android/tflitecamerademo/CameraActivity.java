/* Copyright 2017 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

package com.example.android.tflitecamerademo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

public class CameraActivity extends Activity {
    private ImageClassifier classifier;
    private String TAG = "CameraActivity";
    private Bitmap resizeAbleBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        if (null == savedInstanceState) {
            getFragmentManager().beginTransaction().replace(R.id.container, Camera2BasicFragment.newInstance()).commit();
        }

//        try {
//            classifier = new ImageClassifier(this);
//            resizeAbleBitmap=getResizedBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.ger), ImageClassifier.DIM_IMG_SIZE_X, ImageClassifier.DIM_IMG_SIZE_Y);
//            String lable = classifier.classifyFrame(resizeAbleBitmap);
//            Log.d(TAG,"table="+lable);
//
//        } catch (IOException e) {
//            Log.e(TAG, "Failed to initialize an image classifier.");
//        }
    }
}
