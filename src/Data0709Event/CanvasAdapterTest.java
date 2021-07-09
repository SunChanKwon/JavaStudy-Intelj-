package Data0709Event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CanvasAdapterTest extends MouseAdapter {

    MouseAdapterTest2.MyCanvas mc;//2만번지 갖고 있다.
    public CanvasAdapterTest(){

    }

    public CanvasAdapterTest(MouseAdapterTest2.MyCanvas mc){
        this.mc=mc;
    }
    public void mouseReleased(MouseEvent me)
    {
        if(me.getButton()==1)
        {
        mc.x=me.getX();
        mc.y=me.getY();
        mc.repaint();
        }
    }

    public static void main(String[] args) {

    }
}
