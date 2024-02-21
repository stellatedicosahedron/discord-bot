package memes;

import java.util.ArrayList;
import java.util.Hashtable;

public class Constants {
    public static ArrayList<Meme> memes = new ArrayList<>();

    static{
        memes.add(new HelloChat());
        memes.add(new Xnopyt());
    }
}
