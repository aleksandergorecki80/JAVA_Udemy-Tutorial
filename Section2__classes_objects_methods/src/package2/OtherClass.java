package package2;

public class OtherClass {
    public void publicMethodInOtherClass(){
        ClassB classB = new ClassB();
        classB.protectedMethodInClassB();

        classB.packageProtectedOfClassB();
    }
}
