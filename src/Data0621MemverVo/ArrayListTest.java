package Data0621MemverVo;

import java.util.List;

public class ArrayListTest {

    public ArrayListTest() {
        CollectionData data = new CollectionData();
        List<MemberVo> lst = data.getMember();

        lst.add(2,new MemberVo("ZZZZ","총괄부","2021-05-15",6666));
        lst.remove(0);
        for (int i = 0; i < lst.size(); i++) {
            MemberVo vo = lst.get(i);
          vo.MemberPrint();//asdf//주석달았아요 확인해봅시다 ㅅest
        }
    }

    public static void main(String[] args) {

        new ArrayListTest();
    }
}
