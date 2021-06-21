package Data0621MemverVo;

import java.util.ArrayList;
import java.util.List;

public class CollectionData {

    public CollectionData(){

    }
    public List<MemverVo> getMember(){
        //ArrayList<MemverVo> al = new ArrayList<MemverVo>();//이렇게하는건 처음이다.
        //제너릭을 사용하는방법
        List<MemverVo> al2 = new ArrayList<MemverVo>();

        al2.add(new MemverVo("AAAA","기획부","2015-05-10",5000));
        al2.add(new MemverVo("BBBB","총무부","2015-05-11",6000));
        al2.add(new MemverVo("CCCC","인사부","2015-05-12",7000));
        al2.add(new MemverVo("DDDD","개발부","2015-05-13",8000));
        al2.add(new MemverVo("FFFF","지원부","2015-05-14",9000));

        return al2;
    }

}
