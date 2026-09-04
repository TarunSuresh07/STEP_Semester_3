public class W3Problem3 {
    static class HostelRoom {
        public String roomNo;
        public int beds;
        public int occupied;

        public void allot(String studentName) {
            if (occupied < beds) {
                System.out.println(studentName + " allotted to room " + roomNo);
                occupied++;
            } else {
                System.out.println("Waiting list: room " + roomNo + " is full");
            }
        }
    }

    public static void main(String[] args) {
        HostelRoom room214 = new HostelRoom();
        room214.roomNo = "C-214";
        room214.beds = 2;

        HostelRoom sameRoom = room214;
        sameRoom.allot("Ravi");

        System.out.println("room214 occupied (seen via first variable): " + room214.occupied);

        HostelRoom separate = new HostelRoom();
        separate.roomNo = "C-214";
        separate.beds = 2;

        System.out.println("sameRoom == room214: " + (sameRoom == room214));
        System.out.println("separate == room214: " + (separate == room214));

        room214.allot("Meera");
        room214.allot("Karthik");
    }
}
