package jdk14newfeature;

public class EnhancedSwitch {

    public static void main(String[] args) {
        String today = "M";
        String result = switch (today) {
            case "M", "T", "W" -> "MTW";
            case "TH", "F", "SA", "SU" -> "TFS";
            default -> {
                if(today.isEmpty())
                    yield "Good";
                else
                    yield "Very good";
            }
        };

        System.out.println(result);
    }
}
