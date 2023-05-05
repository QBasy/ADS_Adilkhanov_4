public class MyTestingClass {
    private int x;
    private String y;

    public MyTestingClass(int x, String y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + ((y == null) ? 0 : y.hashCode());
        return result;
    }
    public boolean equals(Object obj)
    {

    }
}
