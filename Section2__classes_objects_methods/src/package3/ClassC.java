package package3;

import package2.ClassB;

public class ClassC extends ClassB {
    public static void main(String[] args) {
        ClassB classB = new ClassB();
        classB.publicMethodInClassB();
    }

    public void anything(){
        super.protectedMethodInClassB();
    }

}
