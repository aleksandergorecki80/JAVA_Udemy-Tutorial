package package2;

public class ClassB {
    public void publicMethodInClassB(){
        System.out.println("This is a publicMethodInClassB");
        privateMethodInClassB();
    }

    private void privateMethodInClassB(){
        System.out.println("This is a privateMethodInClassB");
    }

    protected void protectedMethodInClassB(){
        System.out.println("This is a protectedMethodInClassB");
    }

    void packageProtectedOfClassB(){
        System.out.println("This is a packageProtected of Class B");
    }

}
