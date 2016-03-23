package com.ss.magicsquare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.ss.magicsquare.adapter.MagicSquareAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int[] mMagicArray;

    private Button mSmallMagicButton, mBigMagicButton;
    private GridView mMagicSquareGV;
    private MagicSquareAdapter mSmallMagicSquareAdapter, mBigMagicSquareAdapter;


    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSmallMagicButton = (Button) findViewById(R.id.small_magic_button);
        mBigMagicButton = (Button) findViewById(R.id.big_magic_button);

        mMagicSquareGV = (GridView) findViewById(R.id.gv_magic_square);

        mSmallMagicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                initMagicArray(3);

                if(mSmallMagicSquareAdapter == null){
                    mSmallMagicSquareAdapter = new MagicSquareAdapter(getApplicationContext(), mMagicArray);
                }

                mMagicSquareGV.setAdapter(mSmallMagicSquareAdapter);
                mMagicSquareGV.setNumColumns(3);

            }
        });

        mBigMagicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                initMagicArray(5);

                if(mBigMagicSquareAdapter == null){

                    mBigMagicSquareAdapter = new MagicSquareAdapter(getApplicationContext(), mMagicArray);
                }
                mMagicSquareGV.setAdapter(mBigMagicSquareAdapter);
                mMagicSquareGV.setNumColumns(5);

            }
        });
    }


    /**
     * mMagicArray initialization
     * @param size
     */
    private void initMagicArray(int size){

        int[][] array = new int[size][size];

        int row = size - 1;
        int col = size / 2;
        array[row][col] = 1;

        for (int i = 2; i <= size * size; i++) {
            if (array[(row + 1) % size][(col + 1) % size] == 0) {
                row = (row + 1) % size;
                col = (col + 1) % size;
            }
            else {
                row = (row - 1 + size) % size;
            }
            array[row][col] = i;
        }

        mMagicArray = convertData(array);
    }

    /**
     * Convert 2 dimmention array to one dimmention array
     * @param data
     * @return
     */
    private int[] convertData(int[][] data){

        ArrayList<Integer> list = new ArrayList();

        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[i].length; j++){
                list.add(data[i][j]);
            }
        }

        return toIntArray(list.toArray(new Integer[0]));
    }

    /**
     * Convert Integer array to int array
     * @param list
     * @return
     */
    int[] toIntArray(Integer[] list){
        int[] ret = new int[list.length];
        for(int i = 0;i < ret.length;i++)
            ret[i] = list[i];
        return ret;
    }

}
