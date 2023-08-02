package package1;

import package2.ClassB;
import package2.OtherClass;
import package3.ClassC;

public class ClassA {
    public static void main(String[] args) {
        ClassB classB = new ClassB();

        classB.publicMethodInClassB();

        OtherClass otherClass = new OtherClass();
        otherClass.publicMethodInOtherClass();

        ClassC classC = new ClassC();
        classC.anything();
    }
}
