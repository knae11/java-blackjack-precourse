package domain.common;

public class GuideMessage {
    private static final String GUIDE = "## ";
    private GuideMessage(){
    }

    public static void print(String message){
        System.out.println(GUIDE + message);
    }
}

