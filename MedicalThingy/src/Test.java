public class Test {
    public static void main(String[] args) {
        MainWindow main = new MainWindow();
        Client server = new Client("128.61.86.69",5651);
        Client.send("Operator");
        Client.send("Exit");
        main.run();
        /*while(true){
            int i = 0;
            System.out.println(i);
        }*/
    }
}
