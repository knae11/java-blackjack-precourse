package domain.common;

public enum Answer {
    YES("y"), NO("n");

    private final String answer;

    Answer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
