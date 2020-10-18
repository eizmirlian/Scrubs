import java.io.*;
import java.util.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5651);
        while (true) {
            Socket s = null;
            try {
                s = ss.accept();
                System.out.println("Good!");
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                Thread t = new ClientHandler(s, dis, dos);
                t.start();
            } catch (Exception e) {
                s.close();
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler extends Thread {
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;
    private Nurse nurse;
    static Operator operator;
    private String type;

    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.dis = dis;
        this.dos = dos;
        this.s = s;
    }

    @Override
    public void run() {
        String received;
        String toreturn;
        while (true) {
            try {
                received = dis.readUTF();
                if (received.equals("Operator") && ClientHandler.operator == null) {
                    this.type = "Operator";
                    ClientHandler.operator = new Operator(this.s, this.dis, this.dos);
                    Nurse.operator = ClientHandler.operator;
                    break;
                } else if (received.contains(",") && received.substring(0, received.indexOf(",")).equals("Nurse")) {
                    this.type = "Nurse";
                    String name = received.substring(received.indexOf(",") + 1);
                    this.nurse = new Nurse(this.s, this.dis, this.dos);
                    if (ClientHandler.operator != null) {
                        if (!ClientHandler.operator.nurses.containsKey(name)) {
                            ClientHandler.operator.nurses.put(name, this.nurse);
                            if (ClientHandler.operator.backlog.containsKey(name)) {
                                ClientHandler.operator.sendBackLog(name);
                            }
                        }
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (true) {
            try {
                received = dis.readUTF();
                System.out.println("Request Recieved from " + type);
                if (received.equals("Exit")) {
                    System.out.println("Connection Closed");
                    this.s.close();
                    break;
                }
                toreturn = received;
                switch (this.type) {
                    case "Operator":
                        String recipient = received.substring(received.indexOf("responder\":\"") + 12,
                                received.indexOf("\", \"time"));
                        ClientHandler.operator.send(recipient, toreturn);
                        break;
                    case "Nurse":
                        this.nurse.send(toreturn);
                        break;
                    default:
                        System.out.println("Unknown format");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            this.dis.close();
            this.dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Operator {
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;
    HashMap<String, Nurse> nurses = new HashMap<String, Nurse>();
    HashMap<String, LinkedList<String>> backlog = new HashMap<String, LinkedList<String>>();

    public Operator(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dos = dos;
        this.dis = dis;
    }

    public void send(String name, String toreturn) {
        if (this.nurses.containsKey(name)) {
            Nurse receiver = this.nurses.get(name);
            try {
                receiver.dos.writeUTF(toreturn);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (this.backlog.containsKey(name)) {
            this.backlog.get(name).add(toreturn);
        } else {
            LinkedList<String> tasks = new LinkedList<String>();
            tasks.add(toreturn);
            this.backlog.put(name, tasks);
        }
    }

    public void sendBackLog(String name) {
        for (String m : this.backlog.get(name)) {
            this.send(name, m);
        }
    }
}

class Nurse {
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;
    static Operator operator;

    public Nurse(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dos = dos;
        this.dis = dis;
    }

    public void send(String toreturn) {
        try {
            operator.dos.writeUTF(toreturn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
