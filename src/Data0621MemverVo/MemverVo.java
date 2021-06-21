package Data0621MemverVo;

public class MemverVo {

    //캡슐화 시켜서 다른곳에서 이동시지 못하게함
    private String name;
    private String depart;
    private String hire;
    private int sal;

    public MemverVo() {

    }
    public MemverVo(String name, String depart, String hire, int sal)
    {
        this.name = name;
        this.depart = depart;
        this.hire =hire;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getHire() {
        return hire;
    }

    public void setHire(String hire) {
        this.hire = hire;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }
}


