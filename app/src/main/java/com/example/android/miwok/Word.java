package com.example.android.miwok;

/**
 * creates a class that takes Miwok and English words to be generated later
 */

public class Word {

    private String mMiwokWord;
    private String mDefaultWord;
    private int mResId = NO_IMAGE;
    private static final int NO_IMAGE = -1;
    private int mSound;



    public Word(String m, String def, int s){
        mMiwokWord = m;
        mDefaultWord = def;
        mSound = s;


    }


    /**
     *
     * @param m word for a miwok translation
     * @param def word for a defualt translation (English for instance)
     * @param p drawable resource ID
     */

    public Word(String m, String def, int p, int s){
        mMiwokWord = m;
        mDefaultWord = def;
        mResId = p;
        mSound = s;

    }

    public String getmMiwokWord() {
        return mMiwokWord;
    }

    public String getmDefaultWord() {
        return mDefaultWord;
    }

    public int getmResId() {
        return mResId;
    }

    public int getmSound() {
        return mSound;
    }

    public boolean hasImage(){

        return mResId!=NO_IMAGE;
    }

}
