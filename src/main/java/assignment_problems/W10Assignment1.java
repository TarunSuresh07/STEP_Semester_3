public class W10Assignment1 {
    public static void main(String[] args) {
        Node p = new Node(5, 3);
        p.next = new Node(4, 2);
        p.next.next = new Node(0, 1);
        p.next.next.next = new Node(2, 0);

        Node q = new Node(5, 2);
        q.next = new Node(-3, 1);
        q.next.next = new Node(1, 0);

        Node result = addPolynomials(p, q);
        printPolynomial(result);

        Node p2 = new Node(3, 2);
        p2.next = new Node(1, 0);

        Node q2 = new Node(-3, 2);
        q2.next = new Node(4, 1);

        Node result2 = addPolynomials(p2, q2);
        printPolynomial(result2);
    }

    static Node addPolynomials(Node p, Node q) {
        Node dummy = new Node(0, -1);
        Node tail = dummy;

        while (p != null && q != null) {
            if (p.exp > q.exp) {
                tail.next = new Node(p.coeff, p.exp);
                p = p.next;
            } else if (p.exp < q.exp) {
                tail.next = new Node(q.coeff, q.exp);
                q = q.next;
            } else {
                int sum = p.coeff + q.coeff;
                if (sum != 0) {
                    tail.next = new Node(sum, p.exp);
                }
                p = p.next;
                q = q.next;
            }
            tail = tail.next;
        }

        while (p != null) {
            tail.next = new Node(p.coeff, p.exp);
            p = p.next;
            tail = tail.next;
        }

        while (q != null) {
            tail.next = new Node(q.coeff, q.exp);
            q = q.next;
            tail = tail.next;
        }

        return dummy.next;
    }

    static void printPolynomial(Node head) {
        if (head == null) {
            System.out.println("0");
            return;
        }

        StringBuilder sb = new StringBuilder();
        Node temp = head;
        boolean first = true;

        while (temp != null) {
            int c = temp.coeff;
            int e = temp.exp;

            if (c == 0) {
                temp = temp.next;
                continue;
            }

            if (!first) {
                if (c > 0) {
                    sb.append(" + ");
                } else {
                    sb.append(" - ");
                }
            }

            int abs = Math.abs(c);

            if (e == 0) {
                sb.append(abs);
            } else if (e == 1) {
                if (abs == 1) {
                    sb.append("x");
                } else {
                    sb.append(abs).append("x");
                }
            } else {
                if (abs == 1) {
                    sb.append("x^").append(e);
                } else {
                    sb.append(abs).append("x^").append(e);
                }
            }

            if (c < 0) {
                sb = new StringBuilder(sb.toString().replace(" - ", " + "));
            }

            first = false;
            temp = temp.next;
        }

        if (sb.length() == 0) {
            System.out.println("0");
        } else {
            System.out.println(sb.toString());
        }
    }
}

class Node {
    int coeff;
    int exp;
    Node next;

    Node(int coeff, int exp) {
        this.coeff = coeff;
        this.exp = exp;
    }
}
