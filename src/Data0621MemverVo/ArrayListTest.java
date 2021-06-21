package Data0621MemverVo;

import java.util.List;

public class ArrayListTest {

    public ArrayListTest() {
        CollectionData data = new CollectionData();
        List<MemverVo> lst = data.getMember();

        lst.add(2,new MemverVo("ZZZZ","총괄부","2021-05-15",6666));
        lst.remove(0);
        for (int i = 0; i < lst.size(); i++) {
            MemverVo vo = lst.get(i);
          vo.MemberPrint();
        }
    }

    public static void main(String[] args) {

        new ArrayListTest();
    }
}
