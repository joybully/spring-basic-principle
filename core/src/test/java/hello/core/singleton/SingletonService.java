package hello.core.singleton;

public class SingletonService {

    //static 영역에 객체 1개만 생성
    private static final SingletonService instance = new SingletonService();

    //public으로 열어 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 한다.
    public static SingletonService getInstance(){
        return instance;
    }

    //생성자를 private로 선언해 new를 이용한 객체생성을 막는다.
    private SingletonService(){}

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
