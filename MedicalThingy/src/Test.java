public class Test {
    public static void main(String[] args) {
        MainWindow main = new MainWindow();
        Client server = new Client("2610:148:1f00:1000:c419:5a2b:c846:1d96", 5651);
        Client.send("Operator");
        main.run();
        while (true) {
            String in = Client.listen();
            main.acceptAcknowledge(new Acknowledge(in));
        }
    }
}
