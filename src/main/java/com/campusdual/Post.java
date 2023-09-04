package com.campusdual;

import com.campusdual.PostTypeClasses.ImageContentPost;
import com.campusdual.PostTypeClasses.StringContentPost;
import com.campusdual.PostTypeClasses.VideoContentPost;

import java.util.ArrayList;
import java.util.Date;

/**POST CLASS**/
public class Post{
    private Date date;
    private ArrayList<Comment> comments;
    private StringContentPost stringContentPost;
    private ImageContentPost imageContentPost;
    private VideoContentPost videoContentPost;
}
