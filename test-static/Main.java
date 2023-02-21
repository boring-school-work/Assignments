public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Naa", 300);
        Person person2 = new Person("Yaa", 2);

        Person.setVotingAge(18);
        System.out.println(Person.getVotingAge());
        person1.display();
        person2.display();
    }
}
