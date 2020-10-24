package Exception_Hanling_In_Java;

import java.util.*;

abstract class Connection {
    int connectionId;
    int customerId;
    double balance;

    Connection(int connectionId, int customerId, double balance) {
        this.connectionId = connectionId;
        this.customerId = customerId;
        this.balance = balance;
    }

    double getBalance() {
        return balance;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    int getConnectionId() {
        return connectionId;
    }

    int getCustomerId() {
        return customerId;
    }

    abstract double recharge(double ramount);

    abstract double deduct(double damount);
}

class PrePaid extends Connection {
    PrePaid(int connectionId, int customerId, double balance) {
        super(connectionId, customerId, balance);
    }

    double recharge(double ramount) {
        balance = balance + ramount;
        return balance;
    }

    double deduct(double damount) {
        balance = balance - damount;
        return balance;
    }
}

class Inventory {
    ArrayList<Connection> al;

    Inventory() {
        al = new ArrayList<Connection>();
    }

    boolean addConnection(Connection c) {
        int j[] = new int[5];
        int count = 0;
        for (Connection tmp : al) {
            if (tmp.getConnectionId() == c.getConnectionId()) {
                return false;
            }
        }
        al.add(c);
        return true;
    }

    double recharge(int id, double amount) {
        int count = 0;
        for (Connection tmp : al) {
            if (tmp.getConnectionId() == id) {
                tmp.recharge(amount);
                al.set(count, tmp);
                return tmp.getBalance();

            }
            count++;
        }
        return -1;
    }

    double deduct(int id, double amount) throws Exception {
        int count = 0;
        for (Connection tmp : al) {
            if (tmp.getConnectionId() == id) {
                if (tmp.getBalance() < 0) {
                    throw new ConnectionLockedException(tmp.getBalance());
                }
                tmp.deduct(amount);
                al.set(count, tmp);
                return tmp.getBalance();
            }
            count++;
        }
        return -1;
    }

}

class ConnectionLockedException extends Exception {
    double currentBalance;

    ConnectionLockedException(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getMessage() {
        return "balance is.." + currentBalance;
    }

    public String toString() {
        return "ConnectionLockedException...";
    }
}

class ConnectionDemo {
    public static void main(String args[]) {
        Inventory i = new Inventory();
        PrePaid p1 = new PrePaid(1, 10, 1000);
        PrePaid p2 = new PrePaid(2, 11, 1000);
        PrePaid p3 = new PrePaid(3, 12, 1000);
        double amount = i.recharge(p1.getConnectionId(), 200);
        System.out.println("Recharged for " + amount);

        // i.deduct(p3.getConnectionId(),200);

    }
}
