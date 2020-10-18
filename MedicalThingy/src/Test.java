public class Test {
    public static void main(String[] args) {
        MainWindow main = new MainWindow();
        Client server = new Client("128.61.86.69",5651);
        Client.send("Operator");
        main.run();
        while(true){
            String in = Client.listen();
            main.acceptAcknowledge(new Acknowledge(in));
        }
    }
}
