package classLoader;

/**
 * Created by Fornia.fu on 2016/4/28.
 */
public class Main
{

    public static void main(String[] args){

        ClassInitSequence classInitSequence = new ClassInitSequence();
        ClassInitSequence.staticMethod();
        classInitSequence.commonMethod();
    }
}
