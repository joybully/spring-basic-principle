package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;

    //원래 있어야 할 코드, 하지만 롬복을 이용하면 생략가능하다
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdfas");

    //원래 출력코드, @ToString으로 대체가능
//        String name = helloLombok.getName();
//        System.out.println("name = " + name);
        System.out.println("helloLombok = " + helloLombok);
    }
}
