public class ConsoleInputHandler {
    private String simulatedInput;

    public void setSimulatedInput(String input) {
        this.simulatedInput = input;
    }

    public String getInput() {
        return simulatedInput != null ? simulatedInput : "";
    }
}
