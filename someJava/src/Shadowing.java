public class Shadowing {

    String id = "this class variable";

    public static void main(String[] args){

        String id = "this is method variable which shadows class variable";

        System.out.println(id);

    }

    public void changeClassId(String id) {
        id = "changed";
    }

}


