package javastudy;

public class Test {

    public String test(Users users){
        return users.getHello();
    }
    public static void main(String[] args) {
        A a = new A();
        Users users = new Users();
        Test test = new Test();
        
        System.out.println(test.test(a));
        System.out.println(test.test(users));
    }
}
