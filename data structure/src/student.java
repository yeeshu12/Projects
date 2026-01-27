public class student {
    public String name;
    public int age;
    public String Grade;

    public student(String n, int a, String G) {
        this.name = n;
        this.age = a;
        this.Grade = G;
    }
    public void display() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Grade: " + this.Grade);
    }
}

