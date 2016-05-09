import javax.xml.ws.handler.HandlerResolver;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fornia.fu on 2015/11/13.
 */
public class CopyTest {

    public static void main(String[] args){

        List<Integer> list = new ArrayList();
        list.add(0);
        list.add(1);
       /* updateList(list);*/

        Person p = new Person(1,"male");


        HttpProxy.updatePerson(p);

        System.out.println(p.getAge()+p.getSex());


    }
    public static void updatePerson(Person p){

        p.setAge(5);

    }





}


class Person{
    private int age;
    private String sex;

    Person(int age,String sex){

        this.age=age;
        this.sex=sex;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
