package composite;
import java.util.ArrayList;
import java.util.List;
public class Drawing implements Drawable{
    List<Drawable> drawables = new ArrayList<>();

    public void add(Drawable drawable){
        drawables.add(drawable);
    }

    @Override
    public void draw(){
        for(Drawable drawable : drawables){
            drawable.draw();
        }
    }
}
