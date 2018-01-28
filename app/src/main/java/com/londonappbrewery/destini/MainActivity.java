package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mButtonTop;
    Button mButtonBottom;

    int mStoryIndex = 0;

    int[][] mStoryArray = {
            {R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2},
            {R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2},
            {R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2},
            {R.string.T4_End, -1, -1},
            {R.string.T5_End, -1, -1},
            {R.string.T6_End, -1, -1},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 0 || mStoryIndex == 1) {
                    setStoryLevel(3);
                    updateTexts();
                } else if (mStoryIndex == 2) {
                    setStoryLevel(6);
                    updateTexts();
                }
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 0) {
                    setStoryLevel(2);
                    updateTexts();
                } else if (mStoryIndex == 1) {
                    setStoryLevel(4);
                    updateTexts();
                } else if (mStoryIndex == 2) {
                    setStoryLevel(5);
                    updateTexts();
                }
            }
        });
    }

    public void setStoryLevel(int level) {
        mStoryIndex = level - 1;
    }

    public void updateTexts() {
        mStoryTextView.setText(mStoryArray[mStoryIndex][0]);
        if (mStoryIndex < 3) {
            mButtonTop.setText(mStoryArray[mStoryIndex][1]);
            mButtonBottom.setText(mStoryArray[mStoryIndex][2]);
        } else {
            mButtonBottom.setVisibility(View.INVISIBLE);
            mButtonTop.setVisibility(View.INVISIBLE);
        }
    }

}
